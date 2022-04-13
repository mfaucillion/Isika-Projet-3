package fr.isika.cda14.efund.entity.space;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.isika.cda14.efund.entity.account.AdminAccount;
import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.entity.project.GenericProject;
import fr.isika.cda14.efund.entity.report.Report;
import fr.isika.cda14.efund.entity.shop.BasketOrder;

@Entity
@Table(name = "admin_space")
public class AdminSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "admin_account_id")
	private AdminAccount adminAccount;

	@OneToMany
	@JoinColumn(name = "admin_space_id")
	private List<UserAccount> userAccounts;

	@OneToMany
	@JoinColumn(name = "admin_space_id")
	private List<OrganizationAccount> organizationAccounts;

	@OneToMany
	@JoinColumn(name = "admin_space_id")
	private List<BasketOrder> basketOrders;

	@OneToMany
	@JoinColumn(name = "admin_space_id")
	private List<GenericProject> genericProjects;

	@OneToMany
	@JoinColumn(name = "admin_space_id")
	private List<Report> reports;
}
