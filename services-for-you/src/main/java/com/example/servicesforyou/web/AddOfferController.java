package com.example.servicesforyou.web;

import com.example.servicesforyou.models.binding.AddOfferBindingModel;
import com.example.servicesforyou.models.user.MyUserDetails;
import com.example.servicesforyou.services.OfferService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class AddOfferController {

 private final OfferService offerService;


    public AddOfferController(OfferService offerService) {
        this.offerService = offerService;

    }


    @GetMapping("/add")
    public String addOffer(Model model){
        if (!model.containsAttribute("addOfferModel")){
            model.addAttribute("addOfferModel", new AddOfferBindingModel());
        }


        return "add-offer";
    }

    @PostMapping("/add")
    public String addOffer(@Valid AddOfferBindingModel addOfferBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           @AuthenticationPrincipal MyUserDetails userDetails){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addOfferModel", addOfferBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel", bindingResult);

            return "redirect:/offers/add";
        }

        offerService.addOffer(addOfferBindingModel, userDetails);

        return "redirect:/offers/all";

    }
}
