package fr.isika.cda14.efund.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.entity.account.paiement.Payment;
import fr.isika.cda14.efund.entity.common.Address;
import fr.isika.cda14.efund.entity.enums.ItemStatus;
import fr.isika.cda14.efund.entity.enums.OrderStatus;
import fr.isika.cda14.efund.entity.shop.BasketOrder;
import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.OrderLine;
import fr.isika.cda14.efund.entity.shop.Shop;
import fr.isika.cda14.efund.repositories.AccountRepository;
import fr.isika.cda14.efund.repositories.ShopRepository;
import fr.isika.cda14.efund.tool.SessionTool;
import fr.isika.cda14.efund.viewmodel.ItemCreationForm;
import fr.isika.cda14.efund.viewmodel.PaymentShopVM;

@Stateless
public class ShopService {

	private BigDecimal sumOfCart;
	@Inject
	private ShopRepository shopRepo;
	@Inject
	private AccountRepository repo;

	public void create(ItemCreationForm itemCreationForm, Long shopId) {
		Item newItem = new Item();

		newItem.setLabel(itemCreationForm.getLabel());
		newItem.setDescription(itemCreationForm.getDescription());
		newItem.setItemCategory(itemCreationForm.getItemCategory());
		newItem.setPrice(itemCreationForm.getPrice());
		newItem.setImagePath(itemCreationForm.getImagePath());
		newItem.setItemStatus(ItemStatus.AVAILABLE);

		Shop shop = shopRepo.findShop(shopId);
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

	/* creer un orderline à partir d'un item */
	public OrderLine createOrderLine(Item item) {
		OrderLine orderLine = new OrderLine();
		orderLine.setItem(item);
		
		return orderLine;
	}

	public BasketOrder persistBasketOrder(BasketOrder basketOrder) {
		return shopRepo.persist(basketOrder);
	}

	/* Calcul du prix total de mon cart */
	public BigDecimal sumOfmyCart(List<OrderLine> cart) {
		sumOfCart = new BigDecimal(0);
		for (int i = 0; i < cart.size(); i++) {

			sumOfCart = sumOfCart
					.add(cart.get(i).getItem().getPrice().multiply(BigDecimal.valueOf(cart.get(i).getQuantity())));
		}
		return sumOfCart;

	}

	public BasketOrder createBasketOrder(List<OrderLine> cart) {
		BasketOrder basketOrder = new BasketOrder();
		basketOrder.setOrderLines(cart);
		basketOrder.setTotalItemsQuantity(computeQuantity(cart));
		// here
		basketOrder.setTotalPrice(sumOfmyCart(cart));
		basketOrder.setStatus(OrderStatus.PROCESSING);
		// La date du cart est la date de n'importe quel element
		basketOrder.setDate(new Date());
		
		UserAccount uAccount = repo.findUser(SessionTool.getUserId());
		basketOrder.setUserSpace(uAccount.getUserSpace());
		
		Address adr = uAccount.getUserInfo().getUserAddress();
		basketOrder.setBillingAddress(adr);

		return basketOrder;

	}

	private Integer computeQuantity(List<OrderLine> cart) {
		Integer totalitemQuantity = 0;
		for (int i = 0; i < cart.size(); i++) {
			totalitemQuantity += cart.get(i).getQuantity();
		}
		return totalitemQuantity;
	}

	public Item findItem(Long id) {
		Item item = shopRepo.findItem(id);
		return item;
	}

	public BasketOrder getFullBasketOrder(Long orderId) {
		return shopRepo.getFullBasketOrder(orderId);
	}

	public Payment saveMyPayment(Payment payment) {
		return shopRepo.persist(payment);
	}
}
