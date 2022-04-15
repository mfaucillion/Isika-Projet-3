package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.viewmodel.CreateUserViewModel;

@ManagedBean
public class UserCreateBean {

	@Inject
	private AccountService accountService;

	private CreateUserViewModel createUser = new CreateUserViewModel();

	public String create() {
		Long id = accountService.createUser(createUser);
		return "createUserBis?id=" + id + "faces-redirect=true";
	}
	
	public String modify(Long id) {
		accountService.updateUser(id,createUser);
		return "index.xhtml?faces-redirect=true";
	}

	public CreateUserViewModel getCreateUser() {
		return createUser;
	}

	public void setCreateUser(CreateUserViewModel createUser) {
		this.createUser = createUser;
	}

}
