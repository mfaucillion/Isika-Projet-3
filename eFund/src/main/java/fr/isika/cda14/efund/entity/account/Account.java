package fr.isika.cda14.efund.entity.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import fr.isika.cda14.efund.entity.enums.AccountStatus;
import fr.isika.cda14.efund.entity.enums.Role;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	@Column(length = 50)
	protected String password;

	@Column(name = "displayed_name", length = 50)
	protected String displayedName;

	@Column(length = 320)
	protected String email;

	@Column(name = "image_path", length = 260)
	protected String imagePath;

	@Enumerated(EnumType.STRING)
	protected Role role;

	@Enumerated(EnumType.STRING)
	@Column(name = "account_status")
	protected AccountStatus accountStatus;

}
