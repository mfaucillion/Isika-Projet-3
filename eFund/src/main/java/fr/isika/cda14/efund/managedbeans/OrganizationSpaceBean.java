package fr.isika.cda14.efund.managedbeans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.common.ContentBlock;
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
	List<ContentBlock> blocks = new ArrayList<ContentBlock>();
		
	private Boolean isOwner;
	
	/* Loading OrganizationAccount and Session */
	public void onLoad(String id) {
		System.out.println("OnloadBeforeParseLong");
		Long orgId = Long.parseLong(id);
		System.out.println("OnloadAfterParseLong");
		orgAccount = accountService.loadOrganizationAccountWithChildren(orgId);
		projects = orgAccount.getOrganizationSpace().getProjects();
		events = orgAccount.getOrganizationSpace().getEvents();
		items = orgAccount.getOrganizationSpace().getShop().getItems();
		blocks = orgAccount.getOrganizationSpace().getContentBlocks();
//		Long orgAccountId = Long.parseLong(id);
//		orgAccount = accountService.findOrganizationAccount(orgAccountId);
//		projects = projectService.getOrgsProjects(orgAccount.getOrganizationSpace().getId());
//		events = eventService.getOrgsEvents(orgAccount.getOrganizationSpace().getId());
//		items = shopService.getShopItemList(orgAccount.getOrganizationSpace().getShop().getId());
//		tabs = accountService.getOrgsContentTabs(orgAccount.getOrganizationSpace().getId());
		
		if (orgAccount.getId().equals(SessionTool.getUserId())) {
			isOwner = true;
		} else {
			isOwner = false;
		}
	}
	
	public Boolean isOfType(String blockType, String tagType) {
		return blockType.equals(tagType);
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
	
	public List<ContentBlock> getBlocks() {
		return blocks;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public Boolean getIsOwner() {
		return isOwner;
	}
		
}
