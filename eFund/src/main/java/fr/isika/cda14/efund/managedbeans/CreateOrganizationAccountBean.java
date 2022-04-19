package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.tool.FileUpload;
import fr.isika.cda14.efund.tool.SessionTool;
import fr.isika.cda14.efund.viewmodel.OrganizationForm;

@ManagedBean
@ViewScoped
public class CreateOrganizationAccountBean {

	@Inject
	AccountService accountService;
	
	private OrganizationForm organization = new OrganizationForm();

	public String create() {

		OrganizationAccount account = accountService.createOrg(organization);
		SessionTool.writeInSession(account);
		return "createOrgBis?id=" + account.getId() + "faces-redirect=true";
	}

	public String modify(Long id) {
		accountService.updateOrg(id, organization);
		return "pageOng?id=" + id + "faces-redirect=true";
	}

	public void upload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		String filePath = "/organization/" + file.getFileName();
		organization.setImagePath("img" + filePath);
		FileUpload.doUpload(file, filePath);
	}
	
	public OrganizationForm getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationForm organization) {
		this.organization = organization;
	}

}
