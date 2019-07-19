package com.demo.credit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreditController {

    @GetMapping(path = "/")
    String mainPage(Model model) {
        return "credit";
    }
}
