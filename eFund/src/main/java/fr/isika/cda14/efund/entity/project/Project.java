package fr.isika.cda14.efund.entity.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Project extends GenericProject{
	
	@Column(name="target_amount")
	private Integer targetAmount;
	
	@Column(name="current_amount")
	private Integer currentAmount;

}
