package fr.isika.cda14.efund.managedbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;
import org.primefaces.event.CellEditEvent;

import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.entity.enums.AccountStatus;
import fr.isika.cda14.efund.services.AccountService;

@ManagedBean
@ViewScoped
public class AdminDashboardBean {
	
	@Inject
	AccountService accountService;
	
	private List<UserAccount> users;
	
	private UserAccount selectedUser;
	
	public void onLoad() {
		this.users = accountService.getAllUsers();
	}
	
	public List<UserAccount> getUsers() {
		return users;
	}
	
	public void onCellEdit(CellEditEvent<AccountStatus> event) {
		AccountStatus oldValue = (AccountStatus) event.getOldValue();
		AccountStatus newValue = (AccountStatus) event.getNewValue();
		
		UserAccount user = (UserAccount) event.getComponent().getAttributes().get("userAttr");
		user.setAccountStatus(newValue);
		
		accountService.updateUser(user);
		
        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	public void deleteUser() {
		accountService.deleteUser(this.selectedUser.getId());
		this.users.remove(this.selectedUser);
        this.selectedUser = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Compte utilisateur supprimé"));
        PrimeFaces.current().ajax().update("j_idt17:form:messages", "j_idt17:form:dt-users");
	}
	
	public UserAccount getSelectedUser() {
		return selectedUser;
	}
	
	public AccountStatus[] getAccountStatus() {
		return AccountStatus.values();
	}
	
	public void setSelectedUser(UserAccount selectedUser) {
		this.selectedUser = selectedUser;
	}
}
