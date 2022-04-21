package fr.isika.cda14.efund.entity.space;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.isika.cda14.efund.entity.project.Comment;
import fr.isika.cda14.efund.entity.project.Donation;
import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.entity.project.Favorite;
import fr.isika.cda14.efund.entity.project.UserLike;
import fr.isika.cda14.efund.entity.report.Report;
import fr.isika.cda14.efund.entity.shop.BasketOrder;

@Entity
@Table(name = "user_space")
public class UserSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_space_id")
	private List<BasketOrder> basketOrders;

	@OneToMany
	@JoinColumn(name = "user_space_id")
	private List<Comment> comments;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_space_id")
	private List<Favorite> favorites;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_space_id")
	private List<UserLike> userLikes;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_space_id")
	private List<Event> events;

	@OneToMany
	@JoinColumn(name = "user_space_id")
	private List<Donation> donations;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_space_id")
	private List<Follow> follows;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_space_id")
	private List<Report> reports;

}
