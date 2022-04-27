package fr.isika.cda14.efund.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.shop.BasketOrder;
import fr.isika.cda14.efund.repositories.PaymentRepository;
import fr.isika.cda14.efund.viewmodel.PaymentShopVM;

@Stateless
public class PaymentService {

	@Inject
	PaymentRepository payRepository;

	public void create(PaymentShopVM paymentForm) {
		BasketOrder newbasketOrder = new BasketOrder();
		newbasketOrder.setDate(null);
		newbasketOrder.setTotalItemsQuantity(null);
		newbasketOrder.setTotalPrice(null);
		
		payRepository.create(newbasketOrder);
	}
}
