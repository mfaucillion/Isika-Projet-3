package fr.isika.cda14.efund.entity.report;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "comment_report")
public class CommentReport extends Report {

//	@OneToOne
//	@JoinColumn(name = "comment_id")
//	private Comment comment;

}
