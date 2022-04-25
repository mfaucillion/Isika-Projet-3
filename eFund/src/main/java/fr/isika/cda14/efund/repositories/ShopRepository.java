package fr.isika.cda14.efund.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.shop.BasketOrder;
import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.OrderLine;
import fr.isika.cda14.efund.entity.shop.Shop;

@Stateless
public class ShopRepository {
	
	@PersistenceContext
	EntityManager em;

	public Shop findShop(Long id) {
		return em.find(Shop.class, id);
	}
	
	public Item findItem(Long id) {
		return em.find(Item.class, id);		
	}

	public void update(Shop shop) {
		em.merge(shop);		
	}

	public List<Item> getShopItemList(Long id) {
		return em.createQuery("SELECT items FROM Shop shop WHERE shop.id=:id", Item.class).setParameter("id", id).getResultList();
	}

	public void removeItem(Item item) {
		em.remove(item);		
	}

	public void add(OrderLine orderLine) {
		em.persist(orderLine);
		
	}

	public BasketOrder persist(BasketOrder basketOrder) {
		em.persist(basketOrder);
		return basketOrder;
	}
	
}
