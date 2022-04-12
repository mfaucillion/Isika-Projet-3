package fr.isika.cda14.efund.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrganizationInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Long id;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 14)
	private String siret;
	
	@Column(length = 1000)
	private String description;
	
	@Column(length = 200)
	private String summary;
	

}
