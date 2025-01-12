package com.example.emailAPI.controllers;

import com.example.emailAPI.models.Email;
import com.example.emailAPI.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/cargarEmails")
    public String loadEmails(@RequestBody List<Email> emails) {
        int cantidadEmails = emails.size();
        emails.forEach(email -> emailService.addEmail(email)); //Añadir cada email a la lista
        return "Emails recibidos:"+cantidadEmails;
    }

    @GetMapping("/obtenerEmails")
    public List<Email> getEmails() {
        return emailService.getAllEmails();
    }

    @GetMapping("/email/{id}")
    public Email getEmailByID(@PathVariable long id) {
        Optional<Email> emailResponse = emailService.getEmailByID(id);
        return emailResponse.get();
    }
}
