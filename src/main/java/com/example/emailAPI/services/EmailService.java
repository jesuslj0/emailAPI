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
}
