package com.globe.mart.repository;



import com.globe.mart.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {


    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findCustomerByCustomerEmail(String email);



}
