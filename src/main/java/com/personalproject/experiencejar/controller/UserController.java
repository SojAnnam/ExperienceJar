package com.personalproject.experiencejar.controller;


import com.personalproject.experiencejar.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {


    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;

    }


    @PostMapping(value = "/register")
    public String handleRegistration(Model model,
                                     @RequestParam MultiValueMap<String, String> formData,
                                     @RequestParam Map<String, String> userData){

        System.out.println("IN POST REGISTER METHOD");

        String errorMessage = userService.doRegistration(formData);

        // IN CASE OF INVALID INPUT, RE-RENDER REGISTRATION PAGE
        if (errorMessage != null) {
            System.out.println(errorMessage);
            model.addAttribute("error", errorMessage);
            model.addAttribute("user", userData);

            return "registration";
        }

        return "redirect:/";
    }




}
