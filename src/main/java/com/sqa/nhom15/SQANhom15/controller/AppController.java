package com.sqa.nhom15.SQANhom15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
@RequestMapping("/trangchu")
public class AppController {

    @GetMapping("/trangchu")
    public String homePage(Model model) {
        return "trangchu";
    }
}

