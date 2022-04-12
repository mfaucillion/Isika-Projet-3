package fr.isika.cda14.efund.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Project extends ProjectGeneric{
	
	@Column(name="target_amount")
	private Integer targetAmount;
	
	@Column(name="current_amount")
	private Integer currentAmount;

}
