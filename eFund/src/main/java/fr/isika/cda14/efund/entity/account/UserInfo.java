package fr.isika.cda14.efund.entity.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.isika.cda14.efund.entity.common.Address;

@Entity
@Table(name = "user_info")
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 50, name = "first_name")
	private String firstName;

	@Column(length = 50, name = "last_name")
	private String lastName;

	@Column(length = 20)
	private String phone;

	@OneToOne
	@JoinColumn(name = "user_address_id")
	private Address userAddress;

}
