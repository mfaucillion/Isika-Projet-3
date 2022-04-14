package fr.isika.cda14.efund.managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.viewmodel.OrganizationForm;

@ManagedBean
@ViewScoped
public class OrganizationAccountBean {

	private OrganizationForm organization = new OrganizationForm();
	
	@Inject
	AccountService accountService;

	public String create() {
		
		Long newOrgID = accountService.createOrg(organization);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("viewmodel", organization);
		return "createOrgBis?id=" + newOrgID + "faces-redirect=true";
	}
	
	public String modify(Long id) {
		accountService.updateOrg(id, organization);
		return "index";
	}

	public OrganizationForm getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationForm organization) {
		this.organization = organization;
	}
}
