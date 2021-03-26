package com.sqa.nhom15.SQANhom15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody

public class LoginController {

    @GetMapping("/login-page")
    public ModelAndView showLoginPage() {
        ModelAndView model = new ModelAndView("/login/login-page");

        return model;
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "/ngoaile/access-denied";
    }
}
