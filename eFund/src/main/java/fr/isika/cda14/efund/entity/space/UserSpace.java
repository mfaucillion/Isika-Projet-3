package fr.isika.cda14.efund.entity.space;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.entity.project.Comment;
import fr.isika.cda14.efund.entity.project.Donation;
import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.entity.project.Favorite;
import fr.isika.cda14.efund.entity.project.UserLike;
import fr.isika.cda14.efund.entity.shop.BasketOrder;

@Entity
@Table(name = "user_space")
public class UserSpace {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "user_account_id")
	private UserAccount userAccount;
	
	@OneToMany
	@JoinColumn(name = "basket_order_id")
	private List<BasketOrder> basketOrders;

	@OneToMany
	private List<Comment> comments;
	
	@OneToMany
	private List<Favorite> favorites;
	
	@OneToMany
	@JoinColumn(name = "user_like_id")
	private List<UserLike> userLikes;
	
	@OneToMany
	private List<Event> events;
	
	@OneToMany
	private List<Donation> donations;
	
	@OneToMany
	private List<Follow> follows;

}
