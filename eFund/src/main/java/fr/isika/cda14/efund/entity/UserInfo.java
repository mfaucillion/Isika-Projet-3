package fr.isika.cda14.efund.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=50)
	private String firstName;
	
	@Column(length=50)
	private String lastName;
	
	@Column(length=120)
	private String address;
	
	@Column(length=16)
	private String zipcode;
	
	@Column(length=100)
	private String city;
	
	@Column(length=60)
	private String country;
	
	@Column(length=20)
	private String phone;
	
	@Column(length=320)
	private String email;

}
