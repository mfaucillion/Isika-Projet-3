package fr.isika.cda14.efund.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	//modif
	public List<OrganizationAccount> findAll(){
		return this.em
				.createQuery("SELECT orgAcc from OrganizationAccount orgAcc " 
						+"left join fetch orgAcc.organizationInfo orgInfo", OrganizationAccount.class)
				.getResultList();
	}
}