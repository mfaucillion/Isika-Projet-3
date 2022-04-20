package fr.isika.cda14.efund.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

//@Entity
//@Table(name = "text_block")
public class TextBlock extends ContentBlock {

//	@Lob
//	@Column(length = 10000)
	private String content;

	private Integer size;

}
