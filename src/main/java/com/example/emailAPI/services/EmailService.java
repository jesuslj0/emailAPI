package com.example.emailAPI.services;

import com.example.emailAPI.models.Email;
import com.example.emailAPI.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    public void addEmail(Email email) {
        repository.save(email);
    }

    public Iterable<Email> getAllEmails() {
        return repository.findAll();
    }

    public Optional<Email> getEmailByID(long id) {
        return repository.findById(id);
    }

    public void updateEmail(long id, Email newEmail) {
        repository.save(newEmail);
    }

    public boolean deleteEmail(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
