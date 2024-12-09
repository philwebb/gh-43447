package com.example.errorCheck.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.errorCheck.model.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

	Invoice findInvoiceById(Long invoiceId);

}