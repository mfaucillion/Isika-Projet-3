package fr.isika.cda14.efund.entity.space;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.isika.cda14.efund.entity.common.ContentBlock;
import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.entity.shop.Shop;

@Entity
@Table(name = "organization_space")
public class OrganizationSpace implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5730766511514977861L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String imagePath;
	
	@Column(name = "presentation_tab")
	private Boolean mainTab;
	
	@Column(name = "shop_tab")
	private Boolean shopTab;
	
	@Column(name = "projects_tab")
	private Boolean projectsTab;
	
	@Column(name = "events_tab")
	private Boolean eventsTab;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Shop shop;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "organization_space_id")
	private List<Follow> follows;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "organization_space_id")
	private List<ContentBlock> contentBlocks;
	
	@OneToMany(mappedBy = "organizationSpace", cascade = CascadeType.ALL)
	private List<Project> projects;
	
	@OneToMany(mappedBy = "organizationSpace", cascade = CascadeType.ALL)
	private List<Event> events;
	
	public OrganizationSpace() {
		this.shop = new Shop();
		this.imagePath = "/img/space/default.jpg";
	}
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Follow> getFollows() {
		return follows;
	}

	public List<ContentBlock> getContentBlocks() {
		return contentBlocks;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public List<Event> getEvents() {
		return events;
	}

	public Long getId() {
		return id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Boolean getMainTab() {
		return mainTab;
	}

	public void setMainTab(Boolean mainTab) {
		this.mainTab = mainTab;
	}

	public Boolean getShopTab() {
		return shopTab;
	}

	public void setShopTab(Boolean shopTab) {
		this.shopTab = shopTab;
	}

	public Boolean getProjectsTab() {
		return projectsTab;
	}

	public void setProjectsTab(Boolean projectsTab) {
		this.projectsTab = projectsTab;
	}

	public Boolean getEventsTab() {
		return eventsTab;
	}

	public void setEventsTab(Boolean eventsTab) {
		this.eventsTab = eventsTab;
	}
	

}
