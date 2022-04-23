package fr.isika.cda14.efund.entity.report;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "organization_report")
public class OrganizationReport extends Report {

//	@OneToOne
//	@JoinColumn(name = "organization_id")
//	private OrganizationAccount organizationAccount;
}
