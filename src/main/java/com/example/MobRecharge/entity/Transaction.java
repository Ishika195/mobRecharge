package com.example.MobRecharge.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private float amount;
	@NotBlank
	private ModOfPayment modOfPayment;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User userId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Plan planId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private BankAccount accountId;
	
	@CreationTimestamp
	private Date createdAt;
	@UpdateTimestamp
	private Date updatedAt;

	@Digits(integer = 10, fraction = 0)
	@Positive
	@NotNull
	private Long mobileNumber;
	
	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getId() {
		return id;
	}
	public Plan getPlanId() {
		return planId;
	}
	public void setPlanId(Plan planId) {
		this.planId = planId;
	}
	public BankAccount getAccountId() {
		return accountId;
	}
	public void setAccountId(BankAccount accountId) {
		this.accountId = accountId;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public ModOfPayment getModOfPayment() {
		return modOfPayment;
	}
	public void setModOfPayment(ModOfPayment modOfPayment) {
		this.modOfPayment = modOfPayment;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
}
