package fr.isika.cda14.efund.viewmodel;

import java.math.BigDecimal;

import fr.isika.cda14.efund.entity.space.UserSpace;

public class DonationVM {

	private BigDecimal amount;
	private UserSpace userSpace;

	public UserSpace getUserSpace() {
		return userSpace;
	}

	public void setUserSpace(UserSpace userSpace) {
		this.userSpace = userSpace;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
