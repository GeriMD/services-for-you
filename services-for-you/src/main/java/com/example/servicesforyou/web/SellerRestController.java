package com.example.servicesforyou.web;

import com.example.servicesforyou.models.DTO.SellerDTO;
import com.example.servicesforyou.services.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sellers")
public class SellerRestController {
    private final SellerService sellerService;

    public SellerRestController(SellerService sellerService) {
        this.sellerService = sellerService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<SellerDTO>> getSellers(
            Principal principal
    ) {
        return ResponseEntity.ok(
                sellerService.getAllSellers());
    }
}
