package fr.isika.cda14.efund.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Project extends ProjectGeneric{
	
	private Integer targetAmount;
	
	private Integer currentAmount;
	
	@Enumerated(EnumType.STRING)
	private Status status;

}
