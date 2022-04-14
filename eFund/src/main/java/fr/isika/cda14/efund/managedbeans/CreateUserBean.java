package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.viewmodel.CreateUserViewModel;

@ManagedBean
public class CreateUserBean {

	@Inject
	private AccountService accountService;

	private CreateUserViewModel createUser = new CreateUserViewModel();

	public String create() {
		accountService.createUser(createUser);
		return "createUser.xhtml";
	}

	public CreateUserViewModel getCreateUser() {
		return createUser;
	}

	public void setCreateUser(CreateUserViewModel createUser) {
		this.createUser = createUser;
	}

}
