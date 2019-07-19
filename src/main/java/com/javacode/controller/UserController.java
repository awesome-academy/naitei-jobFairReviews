package com.javacode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @GetMapping({"/"})
    public String hello(@RequestParam(value="", required=false, defaultValue="") String name, Model model) {
//        model.addAttribute("name", name);
        return "user/home";
    }
}
