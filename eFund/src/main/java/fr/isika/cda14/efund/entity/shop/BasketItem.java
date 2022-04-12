package fr.isika.cda14.efund.entity.shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.isika.cda14.efund.entity.enums.ItemCategory;
import fr.isika.cda14.efund.entity.enums.ItemStatus;

@Entity
@Table(name = "basket_item")
public class BasketItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String label;

	@Column(name = "quantity_stock")
	private Integer quantityStock;

	@Column(scale = 2)
	private Double price;

	@Column
	private String description;

	@Enumerated(EnumType.STRING)
	private ItemStatus itemStatus;

	@Enumerated(EnumType.STRING)
	private ItemCategory itemCategory;

}
