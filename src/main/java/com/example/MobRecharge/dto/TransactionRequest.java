package com.example.MobRecharge.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.MobRecharge.entity.ModOfPayment;

public class TransactionRequest {
	private Integer id;

	@NotBlank(message = "Please enter a valid mode of payment")
	private ModOfPayment modOfPayment;
	
	@NotNull
	private Long userId;
	
	@NotNull
	private int planId;
	
	@NotNull
	@Positive
	private int accountNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ModOfPayment getModOfPayment() {
		return modOfPayment;
	}

	public void setModOfPayment(ModOfPayment modOfPayment) {
		this.modOfPayment = modOfPayment;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
