package com.example.servicesforyou.web;

import com.example.servicesforyou.models.binding.RegisterBindingModel;
import com.example.servicesforyou.models.binding.SendRequestBindingModel;
import com.example.servicesforyou.models.entity.UserEntity;
import com.example.servicesforyou.repositories.UserRepository;
import com.example.servicesforyou.services.RequestService;
import com.example.servicesforyou.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final RequestService requestService;

    public UserController(UserService userService, UserRepository userRepository, RequestService requestService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.requestService = requestService;
    }

    @ModelAttribute("userModel")
    public RegisterBindingModel initUserModel() {
        return new RegisterBindingModel();
    }

    @ModelAttribute("requestModel")
    public SendRequestBindingModel initRequestModel() {
        return new SendRequestBindingModel();
    }

    @GetMapping("/register")
    public String register(){
        return "register-form";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterBindingModel userModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors() || !userModel.getPassword().equals(userModel.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            return "redirect:/users/register";
        }

        this.userService.registerAndLoginUser(userModel);

        return "redirect:/";

    }

    @GetMapping("/send/request")
    public String sendRequest(){
        return "request-send";
    }

    @PostMapping("/send/request")
    public String sendRequest(@Valid SendRequestBindingModel requestModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){


        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("requestModel", requestModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.requestModel", bindingResult);

            return "redirect:/users/send/request";
        }

        if (userRepository.findByEmail(requestModel.getEmail()).isEmpty()){
            //TODO error - not found user with this email address in the database
            return "redirect:/";
        }

        requestService.addRequest(requestModel);

        return "redirect:/";

    }

    @GetMapping("/profile")
    public String viewProfile(Model model, Principal principal){

        if (principal == null){
            return "redirect:/users/login";
        }
        var user = userService.findUserByEmail(principal.getName()).orElseThrow();

        model.addAttribute("user", user);


        return "view-profile";

     }



}
