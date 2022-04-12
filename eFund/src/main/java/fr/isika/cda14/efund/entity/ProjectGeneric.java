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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ProjectGeneric {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	private String name;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	@Column(name="end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	
	@Enumerated(EnumType.STRING)
	private ProjectCategory projectCategory;
	
	@OneToMany
	@JoinColumn(name = "contenttab_id")
	private List <ContentTab> listContentTab = new LinkedList <>();
	
	private String summary;
	
	@Column(name="image_path")
	private String imagePath;

	private String location;
	
	@Enumerated(EnumType.STRING)
	private Range range;
	
	

	
	
}
