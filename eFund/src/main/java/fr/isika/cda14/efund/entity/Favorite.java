package fr.isika.cda14.efund.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Favorite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;

	@ManyToOne 
	private ProjectGeneric projectGeneric;
}
