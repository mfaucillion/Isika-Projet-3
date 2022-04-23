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

	private Integer sumOfCart;

	private String orderId;

	@Inject
	private ShopService shopService;

	private List<OrderLine> cart = new ArrayList<OrderLine>();

	public void onLoad(String itemId) {
		if (itemId.isEmpty()) {
		} else {
			this.addOrderLineToCart(Long.parseLong(itemId));
		}
	}

	public OrderLine createOrderLine(Item item) {

		return shopService.createOrderLine(item);

	}

	public void addOrderLineToCart(Long id) {
		Item item = shopService.findItem(id);
		OrderLine orderLine = new OrderLine();
		orderLine.setItem(item);
		if (cart.isEmpty()) {
			orderLine.setQuantity(1);
			cart.add(orderLine);
			System.out.println("toto" + cart.size());

		} else {
			for (int i = 0; i < cart.size(); i++) {
				if (cart.get(i).getItem().getId().compareTo(id) == 0) {
					cart.get(i).setQuantity(cart.get(i).getQuantity() + 1);// pourquoi il n'affiche pas tata?
					// cart.add(orderLine);
					System.out.println("tata" + cart.indexOf(cart.get(i)));
				}
				System.out.println("tete" + cart.get(i).getItem().getId());
				System.out.println("tete" + cart.get(i).getItem().getLabel());
				System.out.println("l'id de l'item " + id + " et l'autre " + item.getId());
			}
			System.out.println("titi" + cart.size());
		}

		System.out.println("la talle est" + cart.size());

	}

	/* Methode pour persister mon cart et redireger vers la page de payment */
	public String payMyCart(List<OrderLine> cart) {

		shopService.createBasketOrder(shopService.payMyCart(cart));
		System.out.println(Long.toString(shopService.payMyCart(cart).getId()));
		return "userProfil";
	}

	public Integer sumOfmyCart(List<OrderLine> cart) {
		sumOfCart = shopService.sumOfmyCart(cart);
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
