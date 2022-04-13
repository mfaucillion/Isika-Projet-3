package fr.isika.cda14.efund.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.enums.ItemStatus;
import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.repositories.ItemRepository;
import fr.isika.cda14.efund.viewmodel.ItemCreationForm;

@Stateless
public class ItemCreationService {
	
	@Inject
	private ItemRepository itemRepo;
	
	public void create(ItemCreationForm itemCreationForm) {
		System.out.println("Service : " + itemCreationForm);
		Item newItem = new Item();
		newItem.setLabel(itemCreationForm.getLabel());
		newItem.setDescription(itemCreationForm.getDescription());
		newItem.setItemCategory(itemCreationForm.getItemCategory());
		newItem.setPrice(itemCreationForm.getPrice());
		newItem.setItemStatus(ItemStatus.AVAILABLE);
		itemRepo.create(newItem);
	}

}
