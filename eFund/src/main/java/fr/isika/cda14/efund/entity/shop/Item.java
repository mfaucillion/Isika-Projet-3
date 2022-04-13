package fr.isika.cda14.efund.entity.shop;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.isika.cda14.efund.entity.enums.ItemCategory;
import fr.isika.cda14.efund.entity.enums.ItemStatus;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String label;

	@Column(name = "quantity_stock")
	private Integer quantityStock;

	@Column(scale = 2)
	private BigDecimal price;

	@Column
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "item_status")
	private ItemStatus itemStatus;

	@Enumerated(EnumType.STRING)
	@Column(name = "item_category")
	private ItemCategory itemCategory;

	public void setLabel(String label) {
		this.label = label;
	}

	public void setQuantityStock(Integer quantityStock) {
		this.quantityStock = quantityStock;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setItemStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}
	
	
	
}


