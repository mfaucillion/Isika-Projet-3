package fr.isika.cda14.efund.entity.project;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.isika.cda14.efund.entity.common.ContentTab;
import fr.isika.cda14.efund.entity.enums.ProjectCategory;
import fr.isika.cda14.efund.entity.enums.ProjectRange;
import fr.isika.cda14.efund.entity.enums.ProjectStatus;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class GenericProject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	protected String name;

	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	protected Date creationDate;

	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	protected Date endDate;

	protected String summary;

	@Column(name = "image_path")
	protected String imagePath;

	protected String location;

	@Enumerated(EnumType.STRING)
	@Column(name = "project_category")
	protected ProjectCategory projectCategory;

	@Enumerated(EnumType.STRING)
	@Column(name = "project_range")
	protected ProjectRange projectRange;

	@Enumerated(EnumType.STRING)
	@Column(name = "project_status")
	protected ProjectStatus projectStatus;

	@OneToMany
	@JoinColumn(name = "generic_project_id")
	protected List<ContentTab> listContentTab;

	@OneToMany
	@JoinColumn(name = "generic_project_id")
	protected List<UserLike> likes;

	@OneToMany
	@JoinColumn(name = "generic_project_id")
	protected List<Comment> comments;

	@OneToMany
	@JoinColumn(name = "generic_project_id")
	protected List<ContentTab> contentTabs;

	@OneToMany
	@JoinColumn(name = "generic_project_id")
	protected List<Favorite> favorites;

	public void setName(String name) {
		this.name = name;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}

	public void setProjectRange(ProjectRange projectRange) {
		this.projectRange = projectRange;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getSummary() {
		return summary;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getLocation() {
		return location;
	}

	public ProjectCategory getProjectCategory() {
		return projectCategory;
	}

	public ProjectRange getProjectRange() {
		return projectRange;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public List<ContentTab> getListContentTab() {
		return listContentTab;
	}

	public List<UserLike> getLikes() {
		return likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public List<ContentTab> getContentTabs() {
		return contentTabs;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}
	
	

}
