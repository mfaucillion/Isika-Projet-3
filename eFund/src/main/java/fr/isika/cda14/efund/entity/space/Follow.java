package fr.isika.cda14.efund.entity.space;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Follow {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
}
