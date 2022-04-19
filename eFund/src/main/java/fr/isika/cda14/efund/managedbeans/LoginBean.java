package fr.isika.cda14.efund.managedbeans;

import java.util.Optional;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda14.efund.entity.account.Account;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.tool.SessionTool;

@ManagedBean
public class LoginBean {

	@Inject
	private AccountService accountService;

	private String email;
	private String password;

	public String login() {
		
		Optional<Account> optional = accountService.findByEmail(email);
		if (optional.isPresent()) {
			Account account = optional.get();
			if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
				
				// Si même email et mot de passe -> On redirige vers l'Index
				SessionTool.writeInSession(account);
				return "index";
			} else {
				// En cas d'erreur on ajoute des messages au formulaire pour indiquer l'erreur
				// une bonne pratique est de toujours dire identifiants incorrects sans
				// préciser si c'est un login erroné ou password erroné pour 
				// des questions de sécurité
				UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("loginForm");
				FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
						new FacesMessage("Identifiants incorrects"));
			}
		} else {
			// Si le user n'existe pas du tout -> on affiche l'erreur dans le formulaire de login
			UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("loginForm");
			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
					new FacesMessage("Utilisateur non reconnu"));
		}

		// Si erreurs de saisie -> on reste sur la même page
		return "login";
		
//		Account account = accountService.findAccountByLoginInfo(email, password);
//		if (account != null) {
//			writeInSession(account);
//		}
//		FacesContext.getCurrentInstance().me
		
	}
	
	public void readFromSession() {
		SessionTool.readFromSession();
	}

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
}
