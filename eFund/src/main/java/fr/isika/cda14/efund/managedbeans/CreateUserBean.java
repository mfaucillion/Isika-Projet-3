package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.exception.UserAlreadyExistsException;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.tool.FileUpload;
import fr.isika.cda14.efund.tool.SessionTool;
import fr.isika.cda14.efund.viewmodel.CreateUserViewModel;

@ManagedBean
@ViewScoped
public class CreateUserBean {

	@Inject
	private AccountService accountService;

	private CreateUserViewModel createUser = new CreateUserViewModel();
	
	UserAccount account;

	public String create() {

		try {
			
			this.account = accountService.createUser(createUser);
			SessionTool.writeInSession(account);
			
			return "userCreationForm2?id=" + account.getId() + "faces-redirect=true";

		} catch (UserAlreadyExistsException ex) {
			System.out.println(ex.getMessage());
		}

		return "userCreationForm.xhtml";
	}
	
	public void upload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		String filePath = "/user/" + file.getFileName();
		
		FileUpload.doUpload(file, filePath);
		createUser.setImagePath("/img" + filePath);
	}

	public String modify(Long id) {
		accountService.updateUser(id, createUser);
		if (createUser.getImagePath() != null) {
			SessionTool.updateSessionImage(createUser.getImagePath());
		}
		return "index.xhtml?faces-redirect=true";
	}

	public CreateUserViewModel getCreateUser() {
		return createUser;
	}

	public void setCreateUser(CreateUserViewModel createUser) {
		this.createUser = createUser;
	}

}
