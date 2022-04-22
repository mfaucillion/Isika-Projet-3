package fr.isika.cda14.efund.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.services.AccountService;

@ManagedBean
public class OrganizationsListBean {

	@Inject
	private AccountService organisationService;

	private List<OrganizationAccount> organizationsList;

	public void onLoad() {
		organizationsList=getAllOrganizations();
	}

	private List<OrganizationAccount> getAllOrganizations(){
		return this.organisationService.findAll();
	}

	public List<OrganizationAccount> getOrganizationsList() {
		return organizationsList;
	}

	public void setOrganizationsList(List<OrganizationAccount> organizationsList) {
		this.organizationsList = organizationsList;
	}

}
