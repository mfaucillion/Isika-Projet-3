package fr.isika.cda14.efund.entity.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stretch_goal")
public class StretchGoal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	protected Long id;
	
	private Integer target;
	
	private String description;
	
}
