package fr.isika.cda14.efund.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.account.OrganizationInfo;
import fr.isika.cda14.efund.entity.space.OrganizationSpace;
import fr.isika.cda14.efund.repositories.OrganizationAccountRepo;
import fr.isika.cda14.efund.viewmodel.OrganizationForm;

@Stateless
public class AccountService {
	
	@Inject
	OrganizationAccountRepo orgRepo;

	public Long createOrg(OrganizationForm inputOrg) {
		OrganizationAccount newOrg = new OrganizationAccount();
		newOrg.setEmail(inputOrg.getEmail());
		newOrg.setPassword(inputOrg.getPassword());
		newOrg.setDisplayedName(inputOrg.getDisplayedName());
		newOrg.setOrganizationInfo(new OrganizationInfo());
		newOrg.setOrganizationSpace(new OrganizationSpace());
		
		return orgRepo.persists(newOrg);
	}

	public void updateOrg(Long id, OrganizationForm inputOrg) {
		OrganizationAccount myOrg = orgRepo.find(id);
		
		myOrg.getOrganizationInfo().setName(inputOrg.getOrganizationName());
		myOrg.getOrganizationInfo().setSiret(inputOrg.getSiret());
		myOrg.getOrganizationInfo().setSummary(inputOrg.getSummary());
		myOrg.getOrganizationInfo().setDescription(inputOrg.getDescription());
		
		orgRepo.update(myOrg);
	}
	
}
