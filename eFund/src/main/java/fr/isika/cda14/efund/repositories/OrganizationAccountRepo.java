package fr.isika.cda14.efund.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.account.Account;
import fr.isika.cda14.efund.entity.account.OrganizationAccount;

@Stateless
public class OrganizationAccountRepo {
	
	@PersistenceContext
	private EntityManager em;

	public Long persists(OrganizationAccount newOrg) {
		em.persist(newOrg);
		return newOrg.getId();
	}

	public OrganizationAccount find(Long id) {
		return em.find(OrganizationAccount.class, id);
	}

	public void update(OrganizationAccount myOrg) {
		em.merge(myOrg);		
	}
	
}