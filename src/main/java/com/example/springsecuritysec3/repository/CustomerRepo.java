package com.example.springsecuritysec3.repository;

import com.example.springsecuritysec3.model.Customer;
import org.springframework.data.repository.CrudRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

public interface CustomerRepo extends CrudRepository<Customer,Long> {

    Optional<Customer> findByMailId(String email);
}
