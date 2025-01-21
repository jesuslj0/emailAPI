package com.example.emailAPI.repository;

import com.example.emailAPI.models.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository <Email, Long> {

}
