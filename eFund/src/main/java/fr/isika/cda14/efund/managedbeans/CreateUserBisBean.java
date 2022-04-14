package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.viewmodel.CreateUserBisViewModel;

@ManagedBean
public class CreateUserBisBean {

	@Inject
	private AccountService accountService;

	private CreateUserBisViewModel createUserBis = new CreateUserBisViewModel();

	public String create(Long id) {
		accountService.updateUser(id,createUserBis);
		return "index.xhtml?faces-redirect=true";
		
		
	}

	public CreateUserBisViewModel getCreateUserBis() {
		return createUserBis;
	}

	public void setCreateUserBis(CreateUserBisViewModel createUserBis) {
		this.createUserBis = createUserBis;
	}
	
	

}
