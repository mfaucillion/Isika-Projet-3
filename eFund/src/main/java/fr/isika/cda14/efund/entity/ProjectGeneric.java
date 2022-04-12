package fr.isika.cda14.efund.entity;

import java.util.Date;
import java.util.LinkedList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ProjectGeneric {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	protected Long id;
	
	protected String name;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.DATE)
	protected Date creationDate;
	
	@Column(name="end_date")
	@Temporal(TemporalType.DATE)
	protected Date endDate;

	protected String summary;
	
	@Column(name="image_path")
	protected String imagePath;

	protected String location;
	
	@Enumerated(EnumType.STRING)
	protected ProjectCategory projectCategory;
	
	@Enumerated(EnumType.STRING)
	protected ProjectRange projectRange;
	
	@Enumerated(EnumType.STRING)
	protected ProjectStatus projectStatus;
	
	@OneToMany
	@JoinColumn(name = "contenttab_id")
	protected List <ContentTab> listContentTab;
	
	@OneToMany
	@JoinColumn(name = "like_id")
	protected List <UserLike> likes;
}
