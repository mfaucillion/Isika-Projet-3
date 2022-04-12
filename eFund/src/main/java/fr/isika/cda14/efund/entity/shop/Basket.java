package fr.isika.cda14.efund.entity.shop;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Double amount;

	@Column(name = "tatal_item_quantity")
	private Double totalItemQuantity;

	@Temporal(TemporalType.DATE)
	private Date date;

	@OneToMany
	@JoinColumn(name = "my_basket_items")
	private List<BasketItem> mybasketItems;

}
