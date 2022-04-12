package fr.isika.cda14.efund.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "media_block")
public class MediaBlock extends ContentBlock {
	
	private String filePath;
	
	private String type;
	

}
