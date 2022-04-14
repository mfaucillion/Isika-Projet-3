package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.services.ItemCreationService;
import fr.isika.cda14.efund.viewmodel.ItemCreationForm;

@ManagedBean
public class ItemCreationBean {

	@Inject
	private ItemCreationService creationService;
	
	private ItemCreationForm itemCreationForm = new ItemCreationForm();

	public String createItem() {
		creationService.create(itemCreationForm);
		return "createItem.xhtml";

	}
	

	public ItemCreationForm getItemCreationForm() {
		return itemCreationForm;
	}

	public void setItemCreationForm(ItemCreationForm itemCreationForm) {
		this.itemCreationForm = itemCreationForm;
	}

}
