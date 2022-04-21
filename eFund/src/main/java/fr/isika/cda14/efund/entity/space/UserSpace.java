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
import fr.isika.cda14.efund.entity.project.EventRegistration;
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

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "userSpace")
	private List<Favorite> favorites;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_space_id")
	private List<UserLike> userLikes;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "userSpace")
	private List<EventRegistration> eventRegistrations;

	@OneToMany(mappedBy = "userSpace")
	private List<Donation> donations;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_space_id")
	private List<Follow> follows;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "user_space_id")
	private List<Report> reports;

	public List<BasketOrder> getBasketOrders() {
		return basketOrders;
	}

	public void setBasketOrders(List<BasketOrder> basketOrders) {
		this.basketOrders = basketOrders;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public List<UserLike> getUserLikes() {
		return userLikes;
	}

	public void setUserLikes(List<UserLike> userLikes) {
		this.userLikes = userLikes;
	}

	public List<EventRegistration> getEventRegistrations() {
		return eventRegistrations;
	}

	public void setEventRegistrations(List<EventRegistration> eventRegistrations) {
		this.eventRegistrations = eventRegistrations;
	}

	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}

	public List<Follow> getFollows() {
		return follows;
	}

	public void setFollows(List<Follow> follows) {
		this.follows = follows;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public Long getId() {
		return id;
	}

}
