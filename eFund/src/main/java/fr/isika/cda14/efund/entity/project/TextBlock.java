package fr.isika.cda14.efund.entity.project;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "text_block")
public class TextBlock extends ContentBlock {
	
	private String content;
	
	private Integer size;
	

}
