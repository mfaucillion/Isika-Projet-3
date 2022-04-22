package fr.isika.cda14.efund.managedbeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.ResponsiveOption;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.common.ContentTab;
import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.entity.shop.Item;
import fr.isika.cda14.efund.entity.shop.OrderLine;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.services.EventService;
import fr.isika.cda14.efund.services.ProjectService;
import fr.isika.cda14.efund.services.ShopService;
import fr.isika.cda14.efund.tool.SessionTool;

@ManagedBean
@ViewScoped
public class OrganizationSpaceBean {
	@Inject
	AccountService accountService;
	
	@Inject
	ProjectService projectService;
	
	@Inject
	EventService eventService;

	@Inject
	ShopService shopService;

	/* Test for themed CSS */
	private String bgcolor = "";

	OrganizationAccount orgAccount;

	
	List<Project> projects = new ArrayList<Project>();
	List<Event> events = new ArrayList<Event>();
	List<Item> items = new ArrayList<Item>();
	List<ContentTab> tabs = new ArrayList<ContentTab>();
	
	private List<ResponsiveOption> responsiveOptions;
	
	private Boolean isOwner;
	
	@PostConstruct
    public void init() {
        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("3000px", 4, 4));
        responsiveOptions.add(new ResponsiveOption("2000px", 3, 3));
        responsiveOptions.add(new ResponsiveOption("1240px", 2, 2));
        responsiveOptions.add(new ResponsiveOption("768px", 1, 1));
	}

	/* Loading OrganizationAccount and Session */
	public void onLoad(String id) {
		orgAccount = accountService.loadOrganizationAccountWithChildren(Long.parseLong(id));
		projects = orgAccount.getOrganizationSpace().getProjects();
		events = orgAccount.getOrganizationSpace().getEvents();
		items = orgAccount.getOrganizationSpace().getShop().getItems();
		tabs = orgAccount.getOrganizationSpace().getContentTabs();
		if (orgAccount.getId().equals(SessionTool.getUserId())) {
			isOwner = true;
		} else {
			isOwner = false;
		}
	}

	
	
	
	
	public OrderLine createOrderLine(Item item) {
		
		return shopService.createOrderLine(item);
		
	}
	
	public void deleteItem(String id) {
		shopService.deleteItem(Long.parseLong(id));
	}
	
	public void deleteProject(String id) {
		projectService.deleteProject(Long.parseLong(id));
	}
	
	public void deleteEvent(String id) {
		eventService.deleteEvent(Long.parseLong(id));
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
	
	public List<ContentTab> getTabs() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		onLoad(request.getParameter("id"));
		return tabs;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public Boolean getIsOwner() {
		return isOwner;
	}
	
	public List<ResponsiveOption> getResponsiveOptions() {
		return responsiveOptions;
	}
	
}
