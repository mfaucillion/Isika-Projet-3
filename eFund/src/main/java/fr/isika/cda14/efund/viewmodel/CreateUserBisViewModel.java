package fr.isika.cda14.efund.viewmodel;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserBisViewModel implements Serializable {

		private static final long serialVersionUID = -7701014377447371993L;

		@NotEmpty(message = "Ne doit pas être vide")
		@NotNull(message = "Ne doit pas être null")
		@Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
		private String lastName;

		@NotEmpty(message = "Ne doit pas être vide")
		@NotNull(message = "Ne doit pas être null")
		@Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
		private String firstName;

		@NotEmpty(message = "Ne doit pas être vide")
		@NotNull(message = "Ne doit pas être null")
		@Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
		private String phone;
		

		@NotEmpty(message = "Ne doit pas être vide")
		@NotNull(message = "Ne doit pas être null")
		@Size(min = 1, max = 50, message = "Doit être entre 1 et 50 car.")
		private String address;
		
		@NotEmpty(message = "Ne doit pas être vide")
		@NotNull(message = "Ne doit pas être null")
		@Size(min = 1, max = 50, message = "Doit être entre 1 et 50 car.")
		private String zipcode;
		
		@NotEmpty(message = "Ne doit pas être vide")
		@NotNull(message = "Ne doit pas être null")
		@Size(min = 1, max = 50, message = "Doit être entre 1 et 50 car.")
		private String city;
		
		@NotEmpty(message = "Ne doit pas être vide")
		@NotNull(message = "Ne doit pas être null")
		@Size(min = 1, max = 50, message = "Doit être entre 1 et 50 car.")
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
	
