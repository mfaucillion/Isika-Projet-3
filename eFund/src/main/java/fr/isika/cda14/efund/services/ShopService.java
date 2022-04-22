package fr.isika.cda14.efund.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.enums.ItemStatus;
import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.OrderLine;
import fr.isika.cda14.efund.entity.shop.Shop;
import fr.isika.cda14.efund.repositories.ShopRepository;
import fr.isika.cda14.efund.viewmodel.ItemCreationForm;

@Stateless
public class ShopService {

	@Inject
	private ShopRepository shopRepo;
	private Integer index=-1;

	public void create(ItemCreationForm itemCreationForm, Long id) {
		Item newItem = new Item();

		newItem.setLabel(itemCreationForm.getLabel());
		newItem.setDescription(itemCreationForm.getDescription());
		newItem.setItemCategory(itemCreationForm.getItemCategory());
		newItem.setPrice(itemCreationForm.getPrice());
		newItem.setImagePath(itemCreationForm.getImagePath());
		newItem.setItemStatus(ItemStatus.AVAILABLE);

		Shop shop = shopRepo.findShop(id);
		shop.getItems().add(newItem);

		shopRepo.update(shop);

	}

	public List<Item> getShopItemList(Long id) {
		return shopRepo.getShopItemList(id);
	}

	public void deleteItem(Long id) {
		Item item = shopRepo.findItem(id);
		shopRepo.removeItem(item);
	}
	/*creer un orderline à partir d'un item */
	public OrderLine createOrderLine(Item item) {
		OrderLine orderLine=new OrderLine();
		orderLine.setItem(item);
		shopRepo.add(orderLine); //je l'ai enlevé pour ne pas persisters
		return orderLine;

	}
	/*Ecrire une methode pour verifier s'il y a un orderLine
	 *  où l'item existe, si oui, incrmeneter la quantité*/

	//public OrderLine createOrderLine(Long id) {
		//Item item=shopRepo.findItem(id);
		/* si l'id de l'item exist, je ne cree pas d'orderLine sinon ok*/
		//OrderLine orderLine=new OrderLine();
		//orderLine.setItem(item);
		//shopRepo.add(orderLine);
		//return orderLine;
	//}
}
