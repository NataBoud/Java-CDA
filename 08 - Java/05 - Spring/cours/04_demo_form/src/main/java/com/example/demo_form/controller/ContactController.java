package com.example.demo_form.controller;

import com.example.demo_form.model.Contact;
import com.example.demo_form.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @RequestMapping("/form")
    public String form(Model model) {
        model.addAttribute("contact", new Contact());
        return "form";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "list";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("contact") Contact contact) {
        System.out.println(contact);
        // Modification du post pour vérifier s'il y a un contact
        return "redirect:/list";
    }

    // Suite Crud
    @RequestMapping("/update")
    public String update(@RequestParam("contactID")UUID id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "form";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("contactID") UUID id) {
        System.out.println("Delete contact " + id);
        return "redirect:/list";
    }

}
