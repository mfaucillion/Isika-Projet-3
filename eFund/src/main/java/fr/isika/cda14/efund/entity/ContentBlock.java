package fr.isika.cda14.efund.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "content_block")
public class ContentBlock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;

	@Column(name="post_date")
	@Temporal(TemporalType.DATE)
	private Date postDate;
}
