package fr.isika.cda14.efund.managedbeans;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda14.efund.entity.account.Account;
import fr.isika.cda14.efund.services.AccountService;

@ManagedBean
public class LoginBean {

	@Inject
	private AccountService accountService;

	private String email;
	private String password;

	@PostConstruct
	private void init() {
		// ce code s'exécute dès la création du bean
		// attention il est possible que le refresh sur la page n'appelle pas ce bloc
	}

	public String login() {
		
		Optional<Account> optional = accountService.findByEmail(email);
		if (optional.isPresent()) {
			
			Account account = optional.get();
			if (account.getEmail().equals(email) && account.getPassword().equals(password)) {
				
				// Si même email et mot de passe -> On redirige vers l'Index
				writeInSession(account);
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

	public void writeInSession(Account account) {
		// Si on veut accèder à la session http
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		// Si on veut mémoriser (écrire) une information dans lasession http

		// le nom de l'attribut doit être unique, et le même partout
		session.setAttribute(SessionAttributesUtils.CONNECTED_USER_ID, account.getId());
		session.setAttribute(SessionAttributesUtils.CONNECTED_USER_NAME, account.getDisplayedName());
		session.setAttribute(SessionAttributesUtils.CONNECTED_USER_ROLE, account.getRole().toString());
	}

	public void readFromSession() {
		// Si on veut accèder à la session http
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		// Si on veut lire une valeur de la session
		// attention si rien n'a été écrit dans cet attribut => null
		Long id = (Long) session.getAttribute(SessionAttributesUtils.CONNECTED_USER_ID);
		String userName = (String) session.getAttribute(SessionAttributesUtils.CONNECTED_USER_NAME);
		String role = (String) session.getAttribute(SessionAttributesUtils.CONNECTED_USER_ROLE);
		if (id != null) {
			System.out.println("Utilisateur connecté : " + id + " - " + userName + " - " + role );
		} else {
			System.out.println("PAs d'id dans la session");
		}
	}

	public void resetSessionAttributes() {
		// Si on veut accèder à la session http
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
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
