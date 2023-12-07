package com.example.servicesforyou.web;

import com.example.servicesforyou.models.DTO.SellerDTO;
import com.example.servicesforyou.services.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sellers/all")
public class SellerRestController {
    private final SellerService sellerService;

    public SellerRestController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public ResponseEntity<List<SellerDTO>> getAllSellers(){
        return ResponseEntity.ok(sellerService.getAllSellers());

    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerDTO> getSellerById(@PathVariable("id") Long id){
        Optional<SellerDTO> sellerDTOOptional = sellerService.findSellerById(id);

        return sellerDTOOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SellerDTO> deleteSellerById(@PathVariable("id") Long id){
        sellerService.deleteSellerById(id);

        return ResponseEntity.noContent().build();

    }
}
