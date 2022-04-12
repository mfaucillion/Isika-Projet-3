package fr.isika.cda14.efund.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Long id;
	
	private String password;
	private String username;
	
	@Enumerated(EnumType.STRING)
	private Role role;

}
