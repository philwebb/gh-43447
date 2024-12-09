package com.example.errorCheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.errorCheck.model.AppUser;
import com.example.errorCheck.model.Invoice;
import com.example.errorCheck.model.Payment;
import com.example.errorCheck.model.StudentFeesToInvoice;
import com.example.errorCheck.repository.InvoiceRepository;
import com.example.errorCheck.repository.PaymentRepository;
import com.example.errorCheck.repository.StudentFeesToInvoiceRepository;
import com.example.errorCheck.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class TestService1 {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private TestService2 testService2;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private StudentFeesToInvoiceRepository studentFeesToInvoiceRepository;

	@PostConstruct
	public void init() {
		AppUser user = this.userRepository.save(new AppUser());

		var invoice1 = new Invoice();
		invoice1.setCreatedFrom(user);
		invoice1.setAddedPaymentFrom(user);
		this.invoiceRepository.save(invoice1);

		StudentFeesToInvoice studentFeesToInvoice = new StudentFeesToInvoice();
		studentFeesToInvoice.setInvoice(invoice1);
		this.studentFeesToInvoiceRepository.save(studentFeesToInvoice);
	}

	@Transactional
	public int addPayment(Long userId) {

		Payment payment = new Payment();

		var invoice = new Invoice();
		invoice.setId(1L);
		payment.setInvoice(invoice);

		AppUser appUser = new AppUser();
		appUser.setId(userId);
		payment.setCreatedFrom(appUser);
		this.paymentRepository.save(payment);

		var test = this.testService2.method2(invoice.getId());

		return test.size();
	}
}
