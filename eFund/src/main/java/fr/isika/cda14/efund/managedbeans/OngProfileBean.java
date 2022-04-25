package fr.isika.cda14.efund.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.services.AccountService;

@ViewScoped
@ManagedBean
public class OngProfileBean {
	
	@Inject
	private AccountService accService;
	
	private OrganizationAccount organizationAccount;
	
	private List<Project> projects;
	
	private List<Event> events;
	
	public void onLoad(String id) {
		this.organizationAccount = accService.findOrganizationAccount(Long.parseLong(id));
	}

}
