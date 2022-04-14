package fr.isika.cda14.efund.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.account.UserAccount;

@Stateless
public class UserAccountRepository {

	@PersistenceContext
	private EntityManager em;

	public void persists(UserAccount newUser) {
		em.persist(newUser);

	}

}
