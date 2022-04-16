package fr.isika.cda14.efund.entity.space;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.isika.cda14.efund.entity.common.ContentTab;
import fr.isika.cda14.efund.entity.project.GenericProject;
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
	private List<ContentTab> contentTabs;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "orgSpace")
	private List<GenericProject> genericProjects;

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

	public List<ContentTab> getContentTabs() {
		return contentTabs;
	}

	public void setContentTabs(List<ContentTab> contentTabs) {
		this.contentTabs = contentTabs;
	}

	public List<GenericProject> getGenericProjects() {
		return genericProjects;
	}

	public void setGenericProjects(List<GenericProject> genericProjects) {
		this.genericProjects = genericProjects;
	}

	public Long getId() {
		return id;
	}

}
