package fr.isika.cda14.efund.entity.report;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import fr.isika.cda14.efund.entity.project.Comment;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "comment_report")
public class CommentReport extends Report {

	@OneToOne
	@JoinColumn(name = "comment_id")
	private Comment comment;

}
