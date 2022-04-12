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
	
}
