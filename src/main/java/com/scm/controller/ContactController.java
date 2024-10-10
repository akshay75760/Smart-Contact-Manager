package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.Contact;
import com.scm.forms.ContactForm;
import com.scm.services.ContactService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/user/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping("/add")
    // Add Contact page
    public String addContactView(Model model ){
        ContactForm contactForm = new ContactForm();
        // contactForm.setName("Akshay");
        // contactForm.setFavorite(true);
        model.addAttribute("contactForm", contactForm);
        return "user/add_contact";
    }

    @PostMapping("/add")
    public String saveContact(@ModelAttribute ContactForm contactForm){
        
        // Process the Form data

        // Form -->Contact

        Contact cantact = new Contact();
        
        cantact.setName(contactForm.getName());
        cantact.setEmail(contactForm.getEmail());
        cantact.setPhoneNumber(contactForm.getPhoneNumber());
        cantact.setFavorite(contactForm.isFavorite());


        contactService.save(cantact);

        
        System.out.println(contactForm);
        return "redirect:/user/contacts/add";
    }
    
}
