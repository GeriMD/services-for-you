package com.example.servicesforyou.web;

import com.example.servicesforyou.models.DTO.SellerDTO;
import com.example.servicesforyou.services.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SellersController {

    private final SellerService sellerService;

    public SellersController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping("/sellers/all")
    public String allSellers(Model model) {
  List<SellerDTO> allSellers = sellerService.getAllSellers();
        model.addAttribute("sellers", allSellers);
       return "sellers";
    }


}
