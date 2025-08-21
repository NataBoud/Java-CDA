package com.example.demo_session_upload.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

@Controller

public class SessionController {

    @Autowired
    private HttpSession session;

    @RequestMapping("/ecrire")
    public void ecrire() {
        session.setAttribute("name", "toto");
        session.setAttribute("list", Arrays.asList("toto", "toto2"));
    }

    @RequestMapping("/lire")
    @ResponseBody
    public void lire() {
        String name = session.getAttribute("name").toString();
        System.out.println(name);
    }

    @RequestMapping("/delete")
    public void delete() {
//        session.invalidate();
        session.removeAttribute("list");
    }

}
