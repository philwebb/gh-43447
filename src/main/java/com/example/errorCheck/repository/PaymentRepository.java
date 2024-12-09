package com.example.errorCheck.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.errorCheck.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}