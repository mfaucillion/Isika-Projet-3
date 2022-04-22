package fr.isika.cda14.efund.entity.report;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import fr.isika.cda14.efund.entity.shop.Item;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "item_report")
public class ItemReport extends Report {

//	@OneToOne
//	@JoinColumn(name = "item_id")
//	private Item item;

}
