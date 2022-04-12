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
@Table(name = "full_order")
public class BasketOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Double amount;

	@Column
	private Double totalItemQuantity;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@Column
	private String shippingAddress;

	@Column
	private String billingAddress;

	@OneToOne
	private Basket basket;

	@OneToMany
	@JoinColumn(name = "my_order_lines")
	private List<OrderLine> myOrderLines;

}