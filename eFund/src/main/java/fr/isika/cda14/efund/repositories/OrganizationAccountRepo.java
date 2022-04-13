package fr.isika.cda14.efund.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.account.OrganizationInfo;

@Stateless
public class OrganizationAccountRepo {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void persists(OrganizationAccount newOrg) {
		newOrg.setOrganizationInfo(new OrganizationInfo());
		entityManager.persist(newOrg);
		
	}
}
