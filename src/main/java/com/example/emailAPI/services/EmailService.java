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

    public Email updateEmail(Long id, Email newEmail) {
        Optional<Email> emailExist = repository.findById(id);

        if (emailExist.isPresent()) {
            Email email = emailExist.get();

            email.setAsunto(newEmail.getAsunto());
            email.setCuerpo(newEmail.getCuerpo());
            email.setDestinatario(newEmail.getDestinatario());
            // Guardar los cambios en la base de datos
            return repository.save(email);
        } else {
            throw new RuntimeException("No se encontró el email con ID: " + id);
        }
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
