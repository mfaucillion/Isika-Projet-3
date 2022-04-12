package fr.isika.cda14.efund.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private Long id;
	
	@Column(length=50)
	private String password;
	
	@Column(name = "displayed_name", length=50)
	private String displayedName;
	
	@Column(length=320)
	private String email;
	
	@Column(name = "image_path", length=260)
	private String imagePath;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "account_status")
	private AccountStatus accountStatus;

}
