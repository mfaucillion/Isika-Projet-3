package fr.isika.cda14.efund.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.shop.BasketOrder;

@Stateless 
public class PaymentRepository {
	@PersistenceContext
	private EntityManager em;
	public void create(BasketOrder basketOrder) {
		em.persist(basketOrder);
	}
	
	

}
