package fr.isika.cda14.efund.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class OrganizationAccount extends Account{

	@OneToOne
	private OrganizationInfo organizationInfo;
	
}
