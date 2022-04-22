package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.project.Donation;
import fr.isika.cda14.efund.services.ProjectService;
import fr.isika.cda14.efund.viewmodel.DonationVM;

@ManagedBean
@ViewScoped
public class DonationBean {
	
	@Inject
	ProjectService projectService;
	
	private DonationVM donationVM = new DonationVM();
	
	public String createDonation(String id) {
		System.out.println("Id passé : " + id);
		projectService.createDonation(donationVM, Long.parseLong(id));
		return "pageProject.xhtml";
	}
	
	public DonationVM getDonationVM() {
		return donationVM;
	}
}
