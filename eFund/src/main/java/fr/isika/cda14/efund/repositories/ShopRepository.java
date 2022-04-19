package fr.isika.cda14.efund.repositories;

import java.util.List;

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
	
	public Item findItem(Long id) {
		return em.find(Item.class, id);		
	}

	public void update(Shop shop) {
		em.merge(shop);		
	}

	public List<Item> getShopItemList(Long id) {
		List<Item> myItems = em.createQuery("SELECT items FROM Shop shop WHERE shop.id=:id").setParameter("id", id).getResultList();
		System.out.println(myItems.size());
		return myItems;
	}

	public void removeItem(Item item) {
		em.remove(item);		
	}
	
}
