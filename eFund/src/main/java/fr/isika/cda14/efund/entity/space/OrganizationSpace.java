package fr.isika.cda14.efund.entity.space;

import java.util.List;

import javax.persistence.CascadeType;
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
public class OrganizationSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Shop shop;

	@OneToMany
	@JoinColumn(name = "organization_space_id")
	private List<Follow> follows;

	@OneToMany
	@JoinColumn(name = "organization_space_id")
	private List<ContentBlock> contentBlocks;
	
	@OneToMany(mappedBy = "organizationSpace", cascade = CascadeType.ALL)
	private List<Project> projects;
	
	@OneToMany(mappedBy = "organizationSpace", cascade = CascadeType.ALL)
	private List<Event> events;
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Follow> getFollows() {
		return follows;
	}

	public void setFollows(List<Follow> follows) {
		this.follows = follows;
	}

	public List<ContentBlock> getContentBlocks() {
		return contentBlocks;
	}

	public void setContentBlocks(List<ContentBlock> contentBlocks) {
		this.contentBlocks = contentBlocks;
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

	public Long getId() {
		return id;
	}

}
