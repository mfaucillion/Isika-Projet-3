package fr.isika.cda14.efund.managedbeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.shop.BasketOrder;
import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.OrderLine;
import fr.isika.cda14.efund.repositories.AccountRepository;
import fr.isika.cda14.efund.repositories.ShopRepository;
import fr.isika.cda14.efund.services.ShopService;

@ManagedBean
@SessionScoped
public class ShopBean {

	private Integer sumOfCart;
	private String orderId;

	private OrganizationSpaceBean orgSpace;
	private AccountRepository repo;
	@Inject
	private ShopRepository shopRepo;

	@Inject
	private ShopService shopService;
	private List<OrderLine> cart=new ArrayList<OrderLine>();
	public void onLoad(String itemId) {
		if(itemId.isEmpty()) {
		}
		else {
			this.addOrderLineToCart(Long.parseLong(itemId));
		}
	}
	//public void onLoadOrder(String orderId) {

	//}

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
			System.out.println("toto"+cart.size());

		}
		else{
			for(int i=0; i<cart.size();i++) {
				if(cart.get(i).getItem().getId().compareTo(id) == 0) {
					cart.get(i).setQuantity(cart.get(i).getQuantity()+1);//pourquoi il n'affiche pas tata?
					//cart.add(orderLine);
					System.out.println("tata"+cart.indexOf(cart.get(i)));
				}
				System.out.println("tete"+cart.get(i).getItem().getId());
				System.out.println("tete"+cart.get(i).getItem().getLabel());
				System.out.println("l'id de l'item "+id+" et l'autre "+item.getId());
			}
			System.out.println("titi"+cart.size());
		}

		System.out.println("la talle est"+cart.size());
		//sumOfCart+=orderLine.getItem().getPrice().intValue();

	}
	/* Calcul du prix total de mon cart*/
	public Integer sumOfmyCart(List<OrderLine> cart) {
		if(cart.isEmpty()) {
			sumOfCart=0;
		}else {
			for(int i=0; i<cart.size();i++) {
				sumOfCart+=(cart.get(i).getQuantity()*cart.get(i).getItem().getPrice().intValueExact());
			}
		}
		return sumOfCart;
		//return "index";

	}
	/*Methode pour persister mon cart et redireger vers la page de payment*/
	public String payMyCart(List<OrderLine> cart) {
		BasketOrder basketOrder=new BasketOrder();
		basketOrder.setOrderLines(cart);
		Integer totalitemQuantity=0;
		for(int i=0;i<cart.size();i++) {
			totalitemQuantity+=cart.get(i).getQuantity();
		}
		basketOrder.setTotalItemsQuantity(totalitemQuantity);
		basketOrder.setTotalPrice(BigDecimal.valueOf(sumOfCart));
		shopService.createBasketOrder(basketOrder);
		System.out.println(Long.toString(basketOrder.getId()));
		return "userProfil";
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
