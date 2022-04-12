package fr.isika.cda14.efund.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserAccount extends Account{
	
	@OneToOne
	private UserInfo userInfo;
	
}
