package fr.isika.cda14.efund.managedbeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.OrderLine;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.services.ShopService;
import fr.isika.cda14.efund.tool.SessionTool;

@ManagedBean
@SessionScoped
public class ShopBean {

	private Integer sumOfCart;

	private String orderId;
	private OrganizationAccount orgAccount;

	@Inject
	private ShopService shopService;

	@Inject
	private AccountService accountService;
	// private List<Item> orgaShop = new ArrayList<Item>();
	private List<OrderLine> cart = new ArrayList<OrderLine>();

	// public void onLoad1(String id) {
	// Long orgId = Long.parseLong(id);
	// orgAccount = accountService.loadOrganizationAccountWithChildren(orgId);
	// orgaShop = orgAccount.getOrganizationSpace().getShop().getItems();
	// }

	public void onLoad(String itemId) throws IOException {
		if (itemId.isEmpty()) {
		} else {
			this.addOrderLineToCart(this.createOrderLine(Long.parseLong(itemId)));
		}
	}

	public OrderLine createOrderLine(Item item) {
		shopService.createOrderLine(item);
		System.out.println("mon item item" + item);
		return shopService.createOrderLine(item);

	}

	public OrderLine createOrderLine(Long id) {
		Item item = shopService.findItem(id);
		System.out.println("tutu mon item " + item.getLabel() + " grace a l'id" + id
				+ "***********************************************************");
		shopService.createOrderLine(item);
		// this.addOrderLineToCart(item.getId());
		// System.out.println("mon chariot"+cart);
		return shopService.createOrderLine(item);
	}

public void addOrderLineToCart(OrderLine orderLine) throws IOException{
		boolean orderlineExists = false;
		if (cart.isEmpty()) {
			orderLine.setQuantity(1);
			orderLine.setDate(Calendar.getInstance().getTime());
			cart.add(orderLine);
			System.out.println(
					"toto new item in empty cart item_name" + cart.get(cart.indexOf(orderLine)).getItem().getLabel()
					+ " item_quantity : " + cart.get(cart.indexOf(orderLine)).getQuantity() + " , cart_size : "
					+ cart.size() + "***********************************************************");

		} else if (cart.isEmpty() == false) {
			for (int i = 0; i < cart.size(); i++) {
				if (cart.get(i).getItem().getId().compareTo(orderLine.getItem().getId()) == 0) {
					cart.get(i).setQuantity(cart.get(i).getQuantity() + 1);// pourquoi il n'affiche pas tata?
					// cart.add(orderLine);
					orderlineExists = true;
					System.out.println("non_empty cart tata, orderline_id: " + cart.indexOf(cart.get(i)) + "item_name"
							+ cart.get(i).getItem().getLabel() + " item_quantity : "
							+ cart.get(i).getQuantity() + " , cart_size : " + cart.size()
							+ "***********************************************************");
					System.out.println("non_empty cart tete, order_quantity" + cart.get(i).getQuantity()
							+ "the item_id is :" + cart.get(i).getItem().getId() + " and the label is "
							+ cart.get(i).getItem().getLabel()
							+ "***********************************************************");
				} 
			}
		}else if (orderlineExists == true) {
			orderLine.setQuantity(1);
			orderLine.setDate(Calendar.getInstance().getTime());
			cart.add(orderLine);
			System.out.println("new item in non empty cart item_name"
					+ cart.get(cart.indexOf(orderLine)).getItem().getLabel() + " item_quantity : "
					+ cart.get(cart.indexOf(orderLine)).getQuantity() + "the size of the cart is " + cart.size()
					+ "***********************************************************");
		}
		System.out.println("titi taille de mon cart:" + cart.size() + "***********************************************************");
	}

	/* Methode pour persister mon cart et redireger vers la page de payment */
	public String payMyCart(List<OrderLine> cart) {

		shopService.createBasketOrder(shopService.payMyCart(cart));
		System.out.println(Long.toString(shopService.payMyCart(cart).getId()));
		System.out.println("l'id du user est" + SessionTool.getUserId());
		return "userProfil?id=" + SessionTool.getUserId() + "faces-redirect=true";
	}

	public Integer sumOfmyCart(List<OrderLine> cart) {
		sumOfCart = shopService.sumOfmyCart(cart);
		return sumOfCart;
	}

	public String getUserIdFromSession() {

		return Long.toString(SessionTool.getUserId());

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

	// public List<Item> getOrgaShop() {
	// return orgaShop;
	// }

	// public void setOrgaShop(List<Item> shop) {
	// this.orgaShop = shop;
	// }

	public OrganizationAccount getOrgAccount() {
		return orgAccount;
	}

	public void setOrgAccount(OrganizationAccount orgAccount) {
		this.orgAccount = orgAccount;
	}

}
