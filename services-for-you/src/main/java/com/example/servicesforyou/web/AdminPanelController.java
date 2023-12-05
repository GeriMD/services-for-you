package com.example.servicesforyou.web;

import com.example.servicesforyou.services.RequestService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AdminPanelController {
    private final RequestService requestService;

    public AdminPanelController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/admin/all/requests")
    public String showAdminPanel(Model model, @PageableDefault(
            page = 0, size = 5
    ) Pageable pageable) {

        model.addAttribute("requests", requestService.getAllRequests(pageable));


        return "admin-panel";
    }


    @DeleteMapping("/admin/all/requests/{id}")
    public String deleteOffer(
            @PathVariable("id") Long id) {
        requestService.deleteRequestById(id);

        return "redirect:/admin/all/requests";
    }


}
