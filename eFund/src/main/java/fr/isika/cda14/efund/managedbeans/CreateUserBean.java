package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.exception.UserAlreadyExistsException;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.tool.SessionTool;
import fr.isika.cda14.efund.viewmodel.CreateUserViewModel;

@ManagedBean
public class CreateUserBean {

	@Inject
	private AccountService accountService;

	private CreateUserViewModel createUser = new CreateUserViewModel();

	public String create() {

		try {
			
			UserAccount account = accountService.createUser(createUser);
			SessionTool.writeInSession(account);
			
			return "createUserBis?id=" + account.getId() + "faces-redirect=true";

		} catch (UserAlreadyExistsException ex) {
			System.out.println(ex.getMessage());
		}

		return "createUser.xhtml";
	}

	public String modify(Long id) {
		accountService.updateUser(id, createUser);
		return "index.xhtml?faces-redirect=true";
	}

	public CreateUserViewModel getCreateUser() {
		return createUser;
	}

	public void setCreateUser(CreateUserViewModel createUser) {
		this.createUser = createUser;
	}

}
