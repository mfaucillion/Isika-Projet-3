package fr.isika.cda14.efund.entity.account;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import fr.isika.cda14.efund.entity.account.paiement.PaymentMethod;
import fr.isika.cda14.efund.entity.shop.Basket;
import fr.isika.cda14.efund.entity.space.UserSpace;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "user_account")
public class UserAccount extends Account {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_info_id")
	private UserInfo userInfo;

	@OneToMany
	@JoinColumn(name = "user_account_id")
	private List<PaymentMethod> paymentMethods;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_space_id")
	private UserSpace userSpace;

	@OneToOne
	@JoinColumn(name = "basket_id")
	private Basket basket;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<PaymentMethod> getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	public UserSpace getUserSpace() {
		return userSpace;
	}

	public void setUserSpace(UserSpace userSpace) {
		this.userSpace = userSpace;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	
}
