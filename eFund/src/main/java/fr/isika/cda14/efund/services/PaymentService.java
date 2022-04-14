package fr.isika.cda14.efund.services;

import javax.ejb.Stateless;

import fr.isika.cda14.efund.entity.shop.BasketOrder;
import fr.isika.cda14.efund.repositories.PaymentRepository;
import fr.isika.cda14.efund.viewmodel.PaymentForm;

@Stateless
public class PaymentService {
	
	PaymentRepository payRepository;

	public PaymentService() {
		super();
	}
public void create(PaymentForm paymentForm) {
	System.out.println(paymentForm);
	BasketOrder newbasketOrder=new BasketOrder();
	newbasketOrder.setDate(null);
	newbasketOrder.setTotalItemsQuantity(null);
	newbasketOrder.setTotalPrice(null);
	payRepository.create(newbasketOrder);
	
	
}
	public void PrintInvoice() {
		
	}
	public void PrintItSucceded() {
		System.out.println("La communication a réussie !");
	}
}
