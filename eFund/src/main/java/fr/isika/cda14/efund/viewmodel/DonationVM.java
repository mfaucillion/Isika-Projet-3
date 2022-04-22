package fr.isika.cda14.efund.viewmodel;

import java.math.BigDecimal;

import fr.isika.cda14.efund.entity.space.UserSpace;

public class DonationVM {

	private BigDecimal amount;
	private String fullName;
	private String creditCardNumber;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
