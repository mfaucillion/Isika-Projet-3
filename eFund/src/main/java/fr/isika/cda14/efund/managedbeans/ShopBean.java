package fr.isika.cda14.efund.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.OrderLine;
import fr.isika.cda14.efund.services.ShopService;

@ManagedBean
@SessionScoped
public class ShopBean {
	
	@Inject
	private ShopService shopService;
	
	List<OrderLine> order=new ArrayList<OrderLine>();
	
	public OrderLine createOrderLine(Item item) {
		
		return shopService.createOrderLine(item);
		
	}
	
	

}
