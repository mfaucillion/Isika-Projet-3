package fr.isika.cda14.efund.managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class LoginBean {
	
	@PostConstruct
	private void init() {
		// ce code s'exécute dès la création du bean
		// attention il est possible que le refresh sur la page n'appelle pas ce bloc
	}
	
	public void writeInSesstion() {
		// Si on veut accèder à la session http
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		
		// Si on veut mémoriser (écrire) une information dans lasession http
		long userId = 1L;
		
		// le nom de l'attribut doit être unique, et le même partout
		session.setAttribute(SessionAttributesUtils.CONNECTED_USER_ID, userId);
		
	}
	
	public void readFromSession() {
		// Si on veut accèder à la session http
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		// Si on veut lire une valeur de la session
		// attention si rien n'a été écrit dans cet attribut => null
		Long id = (Long) session.getAttribute(SessionAttributesUtils.CONNECTED_USER_ID);
		if(id != null) {
			System.out.println(id);
		} else {
			System.out.println("PAs d'id dans la session");
		}
	}
	
	public void resetSessionAttributes() {
		// Si on veut accèder à la session http
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				session.invalidate();
	}
}
