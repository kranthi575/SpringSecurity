package com.example.springsecuritysec3.repository;

import com.example.springsecuritysec3.model.Customer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

@Repository
public interface CustomerRepo extends CrudRepository<Customer,Long> {

    Optional<Customer> findByemail(String email);
}
