package fr.isika.cda14.efund.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.enums.ItemStatus;
import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.Shop;
import fr.isika.cda14.efund.repositories.ShopRepository;
import fr.isika.cda14.efund.viewmodel.ItemCreationForm;

@Stateless
public class ShopService {

	@Inject
	private ShopRepository shopRepo;

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
}
