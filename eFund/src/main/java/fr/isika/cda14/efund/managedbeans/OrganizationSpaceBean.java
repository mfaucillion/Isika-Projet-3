package fr.isika.cda14.efund.managedbeans;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.entity.project.GenericProject;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.services.ProjectService;
import fr.isika.cda14.efund.services.ShopService;

@ManagedBean
@ViewScoped
public class OrganizationSpaceBean {
	@Inject
	AccountService accountService;
	
	@Inject
	ProjectService projectService;

	@Inject
	ShopService shopService;

	/* Test for themed CSS */
	private String bgcolor = "";

	OrganizationAccount orgAccount;

	List<Project> projects = new ArrayList<Project>();
	List<Event> events = new ArrayList<Event>();
	List<Item> items = new ArrayList<Item>();

	/* Loading OrganizationAccount an */
	public void onLoad(String id) {
		orgAccount = accountService.loadOrganizationAccountWithChildren(Long.parseLong(id));
		projects = orgAccount.getOrganizationSpace().getProjects();
		events = orgAccount.getOrganizationSpace().getEvents();
		items = orgAccount.getOrganizationSpace().getShop().getItems();
	}

	public void deleteItem(String id) {
		shopService.deleteItem(Long.parseLong(id));
	}
	
	public void deleteProject(String id) {
		projectService.deleteProject(Long.parseLong(id));
	}
	
	public void deleteEvent(String id) {
		projectService.deleteEvent(Long.parseLong(id));
	}

	public int pourcentage(BigDecimal current, BigDecimal target) {
		return (current.intValue() * 100 / target.intValue());
	}

	public OrganizationAccount getOrgAccount() {
		return orgAccount;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public List<Event> getEvents() {
		return events;
	}

	public List<Item> getItems() {
		return items;
	}

	public String getBgcolor() {
		return bgcolor;
	}
}
