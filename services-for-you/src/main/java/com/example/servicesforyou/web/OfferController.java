package com.example.servicesforyou.web;

import com.example.servicesforyou.exception.MyNotFoundException;
import com.example.servicesforyou.models.binding.AddOfferBindingModel;
import com.example.servicesforyou.models.user.MyUserDetails;
import com.example.servicesforyou.services.OfferService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {

 private final OfferService offerService;


    public OfferController(OfferService offerService) {
        this.offerService = offerService;

    }

    @GetMapping("/all")
    public String allOffers(
            Model model,
            @PageableDefault(
                    sort = "price",
                    direction = Sort.Direction.ASC,
                    page = 0,
                    size = 5) Pageable pageable) {

        model.addAttribute("offers", offerService.getAllOffers(pageable));

        return "all-offers";
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

    @GetMapping("/{id}")
    public String getOfferDetail(@PathVariable("id") Long id,
                                 Model model) {

        var offerDto =
                offerService.findOfferById(id).orElseThrow(() -> new MyNotFoundException("Offer with id " + id + " was not found!"));

        model.addAttribute("offer", offerDto);

        return "offer-details";
    }

    @PreAuthorize("isOwnerOrAdmin(#id)")
    @DeleteMapping("/{id}")
    public String deleteOffer(@PathVariable("id") Long id){
        offerService.deleteOfferById(id);

        return "redirect:/offers/all";
    }

}
