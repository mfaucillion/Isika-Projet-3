package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.viewmodel.OrganizationForm;

@ManagedBean
public class CreateOrganizationAccountBean {

	private OrganizationForm organization = new OrganizationForm();
	
	@Inject
	AccountService accountService;

	public String create() {
		System.out.println(organization);
		
		accountService.createOrg(organization);
		return "modify.xhtml";
	}

	public OrganizationForm getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationForm organization) {
		this.organization = organization;
	}

}
