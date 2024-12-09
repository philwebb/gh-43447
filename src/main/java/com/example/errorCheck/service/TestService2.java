package com.example.errorCheck.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.errorCheck.model.Invoice;
import com.example.errorCheck.model.StudentFeesToInvoice;
import com.example.errorCheck.repository.InvoiceRepository;
import com.example.errorCheck.repository.StudentFeesToInvoiceRepository;

@Service
public class TestService2 {

	@Autowired
	private StudentFeesToInvoiceRepository testRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	public Set<StudentFeesToInvoice> method2(Long invoiceId) {
		Invoice invoice = this.invoiceRepository.findInvoiceById(invoiceId);
		return this.testRepository.findByInvoiceId(invoice.getId());
	}
}
