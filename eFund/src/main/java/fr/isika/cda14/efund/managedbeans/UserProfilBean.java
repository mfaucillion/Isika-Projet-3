package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.tool.FileUpload;
import fr.isika.cda14.efund.viewmodel.CreateUserViewModel;
@ViewScoped
@ManagedBean
public class UserProfilBean {
	@Inject
	private AccountService accService;
	private UserAccount userAccount;
	private CreateUserViewModel userViewModel=new CreateUserViewModel();

	
	public void onLoad(String userId) {
		userAccount=getUserAccount(Long.parseLong(userId));
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	private UserAccount getUserAccount(Long id) {
		return this.accService.findUserAccountById(id);
	}

	public void upload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		String filePath = "/user/" + file.getFileName();
		userViewModel.setImagePath("img" + filePath);
		FileUpload.doUpload(file, filePath);
	}
}
