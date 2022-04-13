package fr.isika.cda14.efund.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 120)
	private String address;

	@Column(length = 16)
	private String zipcode;

	@Column(length = 100)
	private String city;

	@Column(length = 60)
	private String country;

}