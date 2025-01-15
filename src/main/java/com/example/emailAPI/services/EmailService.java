package com.example.emailAPI.services;

import com.example.emailAPI.models.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmailService {
    private final List<Email> emailList = new ArrayList<>();

    public void addEmail(Email email) {
        emailList.add(email);
    }

    public List<Email> getAllEmails() {
        return emailList;
    }

    public Optional<Email> getEmailByID(long id) {
        return emailList.stream().filter(email -> email.getId() == id).findFirst();
    }

    public void updateEmail(long id, Email newEmail) {
        getEmailByID(id).ifPresent(email -> {
            email.setAsunto(newEmail.getAsunto());
            email.setCuerpo(newEmail.getCuerpo());
            email.setRemitente(newEmail.getRemitente());
            email.setDestinatario(newEmail.getDestinatario());
            email.setFecha(newEmail.getFecha());
        });
    }

    public boolean deleteEmail(long id) {
        Optional<Email> email = getEmailByID(id);
        if (email.isPresent()) {
            emailList.remove(email.get());
            return true;
        } else {
            return false;
        }
    }
}
