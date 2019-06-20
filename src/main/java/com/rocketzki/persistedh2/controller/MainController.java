package com.rocketzki.persistedh2.controller;

import com.rocketzki.persistedh2.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private LaptopService laptopService;


    @Autowired
    public MainController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping("/")
    @ResponseBody
    public String getHomePage() {
        return "Welcome Dear " + SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping("/laptops")
    @ResponseBody
    public String getLaptops() {
        return laptopService.getAllLaptops().toString();
    }
}
