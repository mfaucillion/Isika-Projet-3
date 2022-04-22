package fr.isika.cda14.efund.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.OrderLine;
import fr.isika.cda14.efund.repositories.AccountRepository;
import fr.isika.cda14.efund.repositories.ShopRepository;
import fr.isika.cda14.efund.services.ShopService;

@ManagedBean
@SessionScoped
public class ShopBean {

	Integer sumOfCart;
	OrganizationSpaceBean orgSpace;
	AccountRepository repo;
	@Inject
	ShopRepository shopRepo;

	@Inject
	private ShopService shopService;

	public void onLoad(String itemId) {
		if(itemId.isEmpty()) {
		}
		else {
			this.addOrderLineToCart(Long.parseLong(itemId));
		}
	}

	List<OrderLine> cart=new ArrayList<OrderLine>();

	public OrderLine createOrderLine(Item item) {

		return shopService.createOrderLine(item);

	}

	public void addOrderLineToCart(Long id) {
		Item item=shopRepo.findItem(id);
		OrderLine orderLine=new OrderLine();
		orderLine.setItem(item);
		if(cart.isEmpty()) {
			orderLine.setQuantity(1);
			cart.add(orderLine);
			System.out.println(id);
		}
		else if(cart.indexOf(orderLine)!=-1){
			orderLine.setQuantity(orderLine.getQuantity()+1);
			cart.add(orderLine);
		}


	}
	/* Calcul du prix total de mon cart*/
	public Integer sumOfmyCart() {
		if(cart.isEmpty()) {
			sumOfCart=0;
		}else {
		for(int i=0; i<cart.size();i++) {
			sumOfCart+=(cart.get(i).getQuantity()*cart.get(i).getItem().getPrice().intValueExact());
		}
		}
		return sumOfCart;
		
	}

	public List<OrderLine> getCart() {
		return cart;
	}

	public void setCart(List<OrderLine> cart) {
		this.cart = cart;
	}

	public Integer getSumOfCart() {
		return sumOfCart;
	}

	public void setSumOfCart(Integer sumOfCart) {
		this.sumOfCart = sumOfCart;
	}
	
	
}
