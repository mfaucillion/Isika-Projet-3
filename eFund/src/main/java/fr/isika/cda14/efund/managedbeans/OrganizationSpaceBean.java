package fr.isika.cda14.efund.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.entity.project.GenericProject;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.services.AccountService;

@ManagedBean
public class OrganizationSpaceBean {
	@Inject
	AccountService accountService;
	
	OrganizationAccount orgAccount;
	List<Project> projects = new ArrayList<Project>();
	List<Event> events = new ArrayList<Event>();
	
	public void onLoad(String id) {

		orgAccount = accountService.findOrganizationccount(Long.parseLong(id));
		
		for (GenericProject gp : orgAccount.getOrganizationSpace().getGenericProjects()) {
			if (gp.getClass().equals(Project.class)) {
				projects.add((Project) gp);
			}
			if (gp.getClass().equals(Event.class)) {
				events.add((Event) gp);
			}
		}
	}
	
	public OrganizationAccount getOrgAccount() {
		return orgAccount;
	}
	
	public List<Event> getEvents() {
		return events;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
}
