package fr.isika.cda14.efund.entity.shop;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda14.efund.entity.enums.OrderStatus;

@Entity
@Table(name = "basket_order")
public class BasketOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "total_price")
	private Double totalPrice;

	@Column(name = "total_items_quantity")
	private Integer totalItemsQuantity;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@Column(name = "billing_address")
	private String billingAddress;

	@OneToOne
	private Basket basket;

	@OneToMany
	@JoinColumn(name = "basket_order_id")
	private List<OrderLine> orderLines;

}