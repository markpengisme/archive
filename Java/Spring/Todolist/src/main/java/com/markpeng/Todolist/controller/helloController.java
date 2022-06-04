package com.markpeng.Todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class helloController {

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("hello", "Hello World!!!");
        return "hello";
    }
}
