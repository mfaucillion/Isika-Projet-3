package fr.isika.cda14.efund.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.services.PaymentService;
import fr.isika.cda14.efund.viewmodel.PaymentShopVM;


@ManagedBean
@ViewScoped
public class CreatePaymentBean implements Serializable {
	private static final long serialVersionUID = 0;

	@Inject
	private PaymentService paymentService;

	private PaymentShopVM paymentForm = new PaymentShopVM();

	
	public void createInvoice() {
		System.out.println("Service : " + paymentForm);
		;
	}

	public PaymentShopVM getPaymentForm() {
		return paymentForm;
	}

	public void setPaymentForm(PaymentShopVM paymentForm) {
		this.paymentForm = paymentForm;
	}

}
