package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.forms.ContactForm;



@Controller
@RequestMapping("/user/contacts")
public class ContactController {

    @RequestMapping("/add")
    // Add Contact page
    public String addContactView(Model model ){
        ContactForm contactForm = new ContactForm();
        // contactForm.setName("Akshay");
        model.addAttribute("contactForm", contactForm);
        return "user/add_contact";
    }
}
