package fr.isika.cda14.efund.viewmodel;

import java.io.Serializable;

public class CreateUserViewModel implements Serializable {

	private static final long serialVersionUID = -7701014377447371993L;

	private String email;

	private String password;

	private String displayedName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayedName() {
		return displayedName;
	}

	public void setDisplayedName(String displayedName) {
		this.displayedName = displayedName;
	}

	@Override
	public String toString() {
		return "CreateUser [email=" + email + ", password=" + password + ", displayedName=" + displayedName + "]";
	}

}