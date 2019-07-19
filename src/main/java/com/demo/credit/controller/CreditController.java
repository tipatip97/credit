package com.demo.credit.controller;

import com.demo.credit.model.CreditParameters;
import com.demo.credit.service.CreditService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping(path = "/")
    String mainPage(Model model) {
        model.addAttribute("creditParameters", new CreditParameters());

        return "credit";
    }

    @PostMapping(path = "/")
    String mainPage(Model model, @Valid CreditParameters creditParameters, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "credit";
        } else {
            model.addAttribute("payments", creditService.calculate(creditParameters));
            model.addAttribute("creditParameters", creditParameters);
        }

        return "credit";
    }
}
