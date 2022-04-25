package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.tool.SessionTool;

@ViewScoped
@ManagedBean
public class OrgModificationProfileBean {

	@Inject
	private AccountService accService;

	private OrganizationAccount organizationAccount;

	public void onLoad() {
		this.organizationAccount = accService.findOrganizationAccount(SessionTool.getUserId());
	}

	public OrganizationAccount getOrganizationAccount() {
		return organizationAccount;
	}
}
