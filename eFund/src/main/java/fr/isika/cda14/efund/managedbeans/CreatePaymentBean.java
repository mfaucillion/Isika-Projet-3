package fr.isika.cda14.efund.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.services.PaymentService;
import fr.isika.cda14.efund.viewmodel.PaymentForm;


@ManagedBean
@ViewScoped
public class CreatePaymentBean implements Serializable {
	private static final long serialVersionUID = 0;

	@Inject
	private PaymentService paymentService;

	private PaymentForm paymentForm = new PaymentForm();

	
	public void createInvoice() {
		System.out.println("Service : " + paymentForm);
		;
	}

	public PaymentForm getPaymentForm() {
		return paymentForm;
	}

	public void setPaymentForm(PaymentForm paymentForm) {
		this.paymentForm = paymentForm;
	}

}
