package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
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
public class CreateUserBean {

	@Inject
	private AccountService accountService;

	private CreateUserViewModel createUser = new CreateUserViewModel();

	public String create() {

		try {
			
			UserAccount account = accountService.createUser(createUser);
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
		createUser.setImagePath("img" + filePath);
		FileUpload.doUpload(file, filePath);
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
