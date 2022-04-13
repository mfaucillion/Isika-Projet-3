package fr.isika.cda14.efund.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.repositories.OrganizationAccountRepo;
import fr.isika.cda14.efund.viewmodel.OrganizationForm;

@Stateless
public class AccountService {
	
	@Inject
	OrganizationAccountRepo organizationAccountRepo;

	public void createOrg(OrganizationForm organizationForm) {
		OrganizationAccount newOrg = new OrganizationAccount();
		newOrg.setEmail(organizationForm.getEmail());
		newOrg.setPassword(organizationForm.getPassword());
		newOrg.setDisplayedName(organizationForm.getDisplayedName());
		
		organizationAccountRepo.persists(newOrg);
		System.out.println("je suis le service !" + organizationForm);
		
	}
	
}
