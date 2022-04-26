package fr.isika.cda14.efund.managedbeans;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.account.paiement.Payment;
import fr.isika.cda14.efund.entity.shop.BasketOrder;
import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.OrderLine;
import fr.isika.cda14.efund.services.ShopService;
import fr.isika.cda14.efund.tool.SessionTool;
import fr.isika.cda14.efund.viewmodel.PaymentShopVM;

@ManagedBean
@SessionScoped
public class ShopBean {

	private BigDecimal sumOfCartFromBean = new BigDecimal(0);

	private String orderId;
	private PaymentShopVM paymentVM=new PaymentShopVM();
	private OrganizationAccount orgAccount;

	@Inject
	private ShopService shopService;

	// private List<Item> orgaShop = new ArrayList<Item>();
	private List<OrderLine> cart = new ArrayList<OrderLine>();

	// public void onLoad1(String id) {
	// Long orgId = Long.parseLong(id);
	// orgAccount = accountService.loadOrganizationAccountWithChildren(orgId);
	// orgaShop = orgAccount.getOrganizationSpace().getShop().getItems();
	// }

	public void onLoad(String itemId) throws IOException {
		if (itemId == null || itemId.isEmpty()) {
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

	public void addOrderLineToCart(OrderLine orderLine) throws IOException {
		boolean orderlineExists = false;
		if (cart.isEmpty()) {
			orderLine.setQuantity(1);
			orderLine.setDate(Calendar.getInstance().getTime());
			cart.add(orderLine);
			System.out.println(
					"toto new item in empty cart item_name" + cart.get(cart.indexOf(orderLine)).getItem().getLabel()
							+ " item_quantity : " + cart.get(cart.indexOf(orderLine)).getQuantity() + " , cart_size : "
							+ cart.size() + "***********************************************************");

		} else {
			for (int i = 0; i < cart.size(); i++) {
				if (cart.get(i).getItem().getId().compareTo(orderLine.getItem().getId()) == 0) {
					cart.get(i).setQuantity(cart.get(i).getQuantity() + 1);// pourquoi il n'affiche pas tata?
					// cart.add(orderLine);
					orderlineExists = true;
					System.out.println("non_empty cart tata, orderline_id: " + cart.indexOf(cart.get(i)) + "item_name"
							+ cart.get(i).getItem().getLabel() + " item_quantity : " + cart.get(i).getQuantity()
							+ " , cart_size : " + cart.size()
							+ "***********************************************************");
					System.out.println("non_empty cart tete, order_quantity" + cart.get(i).getQuantity()
							+ "the item_id is :" + cart.get(i).getItem().getId() + " and the label is "
							+ cart.get(i).getItem().getLabel()
							+ "***********************************************************");
				}
			}
			if ( !orderlineExists ) {
				orderLine.setQuantity(1);
				orderLine.setDate(Calendar.getInstance().getTime());
				cart.add(orderLine);
				System.out.println("new item in non empty cart item_name"
						+ cart.get(cart.indexOf(orderLine)).getItem().getLabel() + " item_quantity : "
						+ cart.get(cart.indexOf(orderLine)).getQuantity() + "the size of the cart is " + cart.size()
						+ "***********************************************************");
		} 
		
		}
		System.out.println("titi taille de mon cart:" + cart.size()
				+ "***********************************************************");
	}

	/* Methode pour persister mon cart et redireger vers la page de payment */
	public String payMyCart() {

		BasketOrder createdBasketOrder = shopService.createBasketOrder(this.cart);
		BasketOrder persistedBasketOrder=shopService.persistBasketOrder(createdBasketOrder);
		//sumOfCartFromBean = persistedBasketOrder.getTotalPrice();
		//System.out.println("persisted basket : " + persistedBasketOrder.getId());
		this.saveMyPayment(persistedBasketOrder);
		System.out.println("l'id du user est" + SessionTool.getUserId());
		
		resetCart();
		
		return "userProfil?faces-redirect=true&amp;id=" + SessionTool.getUserId();
	}

	private void resetCart() {
		this.cart.clear();
		this.sumOfCartFromBean = BigDecimal.ZERO;
	}

	public BigDecimal sumOfMyCart() {
		sumOfCartFromBean = shopService.sumOfmyCart(this.cart);
		return sumOfCartFromBean;
	}
	public Payment saveMyPayment(BasketOrder basketOrder) {
		Payment payment= new Payment();
		payment.setBasketOrder(basketOrder);
		payment.setCreditCardNumber(paymentVM.getCardNumber());
		payment.setCryptogram(paymentVM.getSecurityCode());
		payment.setFullName(paymentVM.getName());
		payment.setAmount(basketOrder.getTotalPrice());
		payment.setExpirationDate(paymentVM.getExpirationDate());
		payment.setPaymentDate(basketOrder.getDate());
		shopService.saveMyPayment(payment);
		return payment;
		
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

	

	public String getOrderId() {
		return orderId;
	}

	public BigDecimal getSumOfCartFromBean() {
		return sumOfCartFromBean;
	}

	public void setSumOfCartFromBean(BigDecimal sumOfCartFromBean) {
		this.sumOfCartFromBean = sumOfCartFromBean;
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

	public PaymentShopVM getPaymentShopForm() {
		return paymentVM;
	}

	public void setPaymentShopForm(PaymentShopVM paymentShopForm) {
		this.paymentVM = paymentShopForm;
	}
	

}
