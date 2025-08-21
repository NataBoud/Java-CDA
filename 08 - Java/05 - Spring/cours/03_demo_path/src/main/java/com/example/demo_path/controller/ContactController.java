package com.example.demo_path.controller;

import com.example.demo_path.model.Contact;
import com.example.demo_path.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @RequestMapping("/contacts")
    @ResponseBody
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @RequestMapping("/detail/{contactId}")
    public String detail(@PathVariable("contactId") UUID contactId, Model model) {
        Contact contact = contactService.getContactById(contactId);
        model.addAttribute("contact", contact);
        return "details";
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "home";
    }

    @RequestMapping("/search") // /search?contactName=Toto
    public String searchContact(@RequestParam(name = "contactName", required = false) String name, Model model) {
        Contact contact = contactService.getContactByName(name);
        model.addAttribute("contact", contact);
        return "details";
    }
}
