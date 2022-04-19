package fr.isika.cda14.efund.tool;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.isika.cda14.efund.entity.account.Account;
import fr.isika.cda14.efund.managedbeans.SessionAttributesUtils;

public class SessionTool {
	public static void writeInSession(Account account) {
		// Si on veut accèder à la session http
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		// Si on veut mémoriser (écrire) une information dans lasession http

		// le nom de l'attribut doit être unique, et le même partout
		session.setAttribute(SessionAttributesUtils.CONNECTED_USER_ID, account.getId());
		session.setAttribute(SessionAttributesUtils.CONNECTED_USER_NAME, account.getDisplayedName());
		session.setAttribute(SessionAttributesUtils.CONNECTED_USER_ROLE, account.getRole().toString());
	}

	public static void readFromSession() {
		// Si on veut accèder à la session http
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		// Si on veut lire une valeur de la session
		// attention si rien n'a été écrit dans cet attribut => null
		Long id = (Long) session.getAttribute(SessionAttributesUtils.CONNECTED_USER_ID);
		String userName = (String) session.getAttribute(SessionAttributesUtils.CONNECTED_USER_NAME);
		String role = (String) session.getAttribute(SessionAttributesUtils.CONNECTED_USER_ROLE);
		if (id != null) {
			System.out.println("Utilisateur connecté : " + id + " - " + userName + " - " + role);
		} else {
			System.out.println("PAs d'id dans la session");
		}
	}
	
	public static Long getUserId() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		return (Long) session.getAttribute(SessionAttributesUtils.CONNECTED_USER_ID);
	}
	
	public static String getRole() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

		return (String) session.getAttribute(SessionAttributesUtils.CONNECTED_USER_ROLE);
	}

	public static void resetSessionAttributes() {
		// Si on veut accèder à la session http
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
	}
}
