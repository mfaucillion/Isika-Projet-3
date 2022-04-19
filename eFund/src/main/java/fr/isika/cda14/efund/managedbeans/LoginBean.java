package fr.isika.cda14.efund.managedbeans;

import java.io.IOException;
import java.util.Optional;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.isika.cda14.efund.entity.account.Account;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.tool.SessionTool;

@ManagedBean
@ViewScoped
public class LoginBean {
	private static final String SERVER_HOME_URL = "http://127.0.0.1:8080/eFund/";

	@Inject
	private AccountService accountService;

	private String email;
	private String password;

	private String returnUrl;

	public void onLoad() {
		this.returnUrl = FacesContext.getCurrentInstance().getExternalContext().getRequestHeaderMap().get("referer");
	}

	public String login() throws IOException{		
		Optional<Account> optional = accountService.findByEmail(email);
		if (optional.isPresent()) {
			Account account = optional.get();
			if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
				
				SessionTool.writeInSession(account);
				FacesContext.getCurrentInstance().getExternalContext().redirect(returnUrl);				
			} else {
				UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("loginForm");
				FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
						new FacesMessage("Identifiants incorrects"));
			}
		} else {
			UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("loginForm");
			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
					new FacesMessage("Utilisateur non reconnu"));
		}

		return "login";

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
