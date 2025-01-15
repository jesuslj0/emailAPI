package com.example.emailAPI.controllers;

import com.example.emailAPI.models.Email;
import com.example.emailAPI.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getEmailByID(@PathVariable long id) {
        Optional<Email> emailResponse = emailService.getEmailByID(id);
        if (emailResponse.isPresent()) {
            return ResponseEntity.ok(emailResponse.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email no encontrado");
        }
    }

    @PutMapping("actualizarEmail/{id}")
    public String updateEmail(@PathVariable long id, @RequestBody Email newEmail) {
        emailService.updateEmail(id, newEmail);
        return "Email con id: "+id+" actualizado correctamente.";
    }

    @DeleteMapping("borrarEmail/{id}")
    public ResponseEntity<String> borrarEmail(@PathVariable long id) {
        if (emailService.deleteEmail(id)){
            return ResponseEntity.ok("Email con id: "+id+" eliminado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo encontrar el email con id: "+id);
        }

    }

}
