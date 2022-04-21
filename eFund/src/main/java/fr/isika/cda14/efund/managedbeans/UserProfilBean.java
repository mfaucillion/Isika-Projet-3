package fr.isika.cda14.efund.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.entity.project.Donation;
import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.entity.project.Favorite;
import fr.isika.cda14.efund.entity.project.GenericProject;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.services.ProjectService;
import fr.isika.cda14.efund.tool.FileUpload;
import fr.isika.cda14.efund.viewmodel.CreateUserViewModel;


@ViewScoped
@ManagedBean
public class UserProfilBean {

	@Inject
	private AccountService accService;

	private UserAccount userAccount;

	private List<Favorite> favorites;
	
	private List<Donation> donations;

	private CreateUserViewModel userViewModel = new CreateUserViewModel();

	public void onLoad(String userId) {
		this.userAccount = accService.findUserAccountById(Long.parseLong(userId));
		Long userSpaceId = userAccount.getUserSpace().getId();
		this.favorites = accService.getFavorites(userSpaceId);
		this.donations = accService.getDonations(userSpaceId);
	}
	
	public void upload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		String filePath = "/user/" + file.getFileName();
		userViewModel.setImagePath("img" + filePath);
		FileUpload.doUpload(file, filePath);
	}
	
	public String redirectToProjectPage(GenericProject gProject) {
		System.out.println(gProject.getId());		
		if (gProject instanceof Event) {
			return "pageEvent?id=" + gProject.getId() + "faces-redirect=true";
		} else {
			return "pageProject?id=" + gProject.getId() + "faces-redirect=true";
		}
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
	
	public UserAccount getUserAccount() {
		return userAccount;
	}
	
	public List<Donation> getDonations() {
		return donations;
	}
	
}
