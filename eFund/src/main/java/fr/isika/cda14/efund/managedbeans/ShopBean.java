package fr.isika.cda14.efund.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.OrderLine;
import fr.isika.cda14.efund.repositories.AccountRepository;
import fr.isika.cda14.efund.services.ShopService;

@ManagedBean
@SessionScoped
public class ShopBean {

	OrganizationSpaceBean orgSpace;
	AccountRepository repo;

	@Inject
	private ShopService shopService;

	public void onLoad(String itemId) {
		if(itemId.isEmpty()) {
		}
		else {
			this.createOrderLine(Long.parseLong(itemId));
		}
	}

	List<OrderLine> cart=new ArrayList<OrderLine>();

	public OrderLine createOrderLine(Item item) {

		return shopService.createOrderLine(item);

	}

	public void createOrderLine(Long id) {

		System.out.println(id);
		shopService.createOrderLine(id);
	}


}
