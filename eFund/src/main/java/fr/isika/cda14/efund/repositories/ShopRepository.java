package fr.isika.cda14.efund.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.Shop;

@Stateless
public class ShopRepository {
	
	@PersistenceContext
	EntityManager em;

	public Shop findShop(Long id) {
		return em.find(Shop.class, id);
	}

	public void update(Shop shop) {
		em.merge(shop);		
	}

}
