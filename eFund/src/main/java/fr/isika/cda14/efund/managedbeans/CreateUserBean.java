package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.exception.UserAlreadyExistsException;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.viewmodel.CreateUserViewModel;

@ManagedBean
public class CreateUserBean {

	@Inject
	private AccountService accountService;

	private CreateUserViewModel createUser = new CreateUserViewModel();

	public String create() {
		
//		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createAccountForm");
		try {
			Long id = accountService.createUser(createUser);
		
		return "createUserBis?id=" + id + "faces-redirect=true";
		
		
		} catch(UserAlreadyExistsException ex) {
			// On ajoute un message sur la vue qui résume l'exception
//			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(), new FacesMessage(ex.getMessage()));
			System.out.println(ex.getMessage());
		}
		
		// rester sur la même page en vidant les infos du formulaire (en cas d'erreur)
		return "createUser.xhtml";
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

	@Override
	public String toString() {
		return "UserCreateBean [accountService=" + accountService + ", createUser=" + createUser + "]";
	}
	
	

}
