package fr.isika.cda14.efund.entity.report;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "item_report")
public class ItemReport extends Report {

//	@OneToOne
//	@JoinColumn(name = "item_id")
//	private Item item;

}
