package fr.isika.cda14.efund.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.services.EventService;
import fr.isika.cda14.efund.services.ProjectService;

@ManagedBean
@ViewScoped
public class IndexBean {
	
	@Inject
	AccountService accountService;
	
	@Inject
	ProjectService projectService;
	
	@Inject
	EventService eventService;
	
	private List<Project> projects;
	private List<Event> events;
	private List<OrganizationAccount> orgs;
	
	public void onLoad() {
		this.projects = projectService.getTopProjects();
		this.events = eventService.getTopEvents();
		this.orgs = accountService.getTopOrgs();
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<OrganizationAccount> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<OrganizationAccount> orgs) {
		this.orgs = orgs;
	}
	
}
