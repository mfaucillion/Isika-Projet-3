package fr.isika.cda14.efund.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "content_tab")
public class ContentTab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "contentblock_id")
	private ContentBlock contentBlock;
	
	private String name;
	
	@ManyToOne 
	private ProjectGeneric projectGeneric;
	
}
