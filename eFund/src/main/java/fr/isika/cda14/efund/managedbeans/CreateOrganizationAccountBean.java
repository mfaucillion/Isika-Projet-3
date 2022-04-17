package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda14.efund.services.AccountService;
import fr.isika.cda14.efund.tool.FileUpload;
import fr.isika.cda14.efund.viewmodel.OrganizationForm;

@ManagedBean
@ViewScoped
public class CreateOrganizationAccountBean {

	@Inject
	AccountService accountService;
	
	private OrganizationForm organization = new OrganizationForm();

	public String create() {

		Long newOrgID = accountService.createOrg(organization);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("viewmodel", organization);
		return "createOrgBis?id=" + newOrgID + "faces-redirect=true";
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
