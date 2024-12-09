package com.example.errorCheck.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.errorCheck.model.StudentFeesToInvoice;

@Repository
public interface StudentFeesToInvoiceRepository extends CrudRepository<StudentFeesToInvoice, Long> {

	@EntityGraph(attributePaths = { "invoice.payments.createdFrom", })
	Set<StudentFeesToInvoice> findByInvoiceId(Long invoiceId);

}
