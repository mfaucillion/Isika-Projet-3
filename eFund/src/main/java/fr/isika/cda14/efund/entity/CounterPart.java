package fr.isika.cda14.efund.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "counter_part")
public class CounterPart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	protected Long id;
	
	private Integer amount;
	
	private String description;

	@ManyToOne 
	private GenericProject projectGeneric;

}
