package com.example.demo_fragments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("/")
    public String index() {
        return "pagea";
    }

    @RequestMapping("/pageb")
    public String pageb() {
        return "pageb";
    }

    @RequestMapping("/pagec")
    public String pagec() {
        return "pagec";
    }
}
