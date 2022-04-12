package fr.isika.cda14.efund.entity.account.paiement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.isika.cda14.efund.entity.account.UserAccount;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PaymentMethod {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	protected Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_account_id")
	private UserAccount userAccount;

}
