package fr.isika.cda14.efund.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "media_block")
public class MediaBlock extends ContentBlock {

//	@Column(name = "file_path")
	private String filePath;

	private String type;

}
