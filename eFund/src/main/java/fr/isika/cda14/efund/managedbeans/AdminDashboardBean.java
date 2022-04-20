package fr.isika.cda14.efund.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.services.AccountService;

@ManagedBean
@ViewScoped
public class AdminDashboardBean {
	
	@Inject
	AccountService accountService;
	
	private List<UserAccount> users;
	
	public void onLoad() {
		this.users = accountService.getAllUsers();
	}
	
	public List<UserAccount> getUsers() {
		return users;
	}
}
