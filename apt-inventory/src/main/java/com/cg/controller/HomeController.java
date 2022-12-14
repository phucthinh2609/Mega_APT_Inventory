package com.cg.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/")
    public ModelAndView getHome() {
        return new ModelAndView("index");
    }
    @GetMapping("/home")
    public ModelAndView getHomePage() {
        return new ModelAndView("home");
    }

}
