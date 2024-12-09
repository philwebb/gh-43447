package com.example.errorCheck.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIdentityReference(alwaysAsId = true)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_from")
	private AppUser createdFrom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "added_payment_from")
	private AppUser addedPaymentFrom;

	@OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY)
	@JsonIgnoreProperties(ignoreUnknown = true, value = { "invoice" }, allowSetters = true)
	private Set<Payment> payments;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AppUser getCreatedFrom() {
		return this.createdFrom;
	}

	public void setCreatedFrom(AppUser createdFrom) {
		this.createdFrom = createdFrom;
	}

	public AppUser getAddedPaymentFrom() {
		return this.addedPaymentFrom;
	}

	public void setAddedPaymentFrom(AppUser addedPaymentFrom) {
		this.addedPaymentFrom = addedPaymentFrom;
	}

	public Set<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

}