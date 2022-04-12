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
	
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	private String category;
	
	private List<ContentTab> listOrderLine = new LinkedList<>();
	
	private String summary;

	private String imagePath;

	private String location;
	
	@Enumerated(EnumType.STRING)
	private Range range;
	
	
}
