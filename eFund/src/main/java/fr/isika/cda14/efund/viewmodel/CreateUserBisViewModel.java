package fr.isika.cda14.efund.viewmodel;

import java.io.Serializable;

public class CreateUserBisViewModel implements Serializable {

	private static final long serialVersionUID = -7701014377447371993L;

	private String lastName;

	private String firstName;

	private String phone;

	private String address;

	private String zipcode;

	private String city;

	private String country;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "CreateUserBisViewModel [lastName=" + lastName + ", firstName=" + firstName + ", phone=" + phone
				+ ", address=" + address + ", zipcode=" + zipcode + ", city=" + city + ", country=" + country + "]";
	}

}
