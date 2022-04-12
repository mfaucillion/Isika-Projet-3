package fr.isika.cda14.efund.entity.account;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "organization_account")
public class OrganizationAccount extends Account{

	@OneToOne
	@JoinColumn(name = "organization_info_id")
	private OrganizationInfo organizationInfo;
	
}
