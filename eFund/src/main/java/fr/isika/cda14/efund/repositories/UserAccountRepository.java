package fr.isika.cda14.efund.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.account.UserAccount;

@Stateless
public class UserAccountRepository {

	@PersistenceContext
	private EntityManager em;

	public Long persists(UserAccount newUser) {
		em.persist(newUser);
		return newUser.getId();

	}

	public UserAccount find(Long id) {

		return em.find(UserAccount.class, id);
	}

	public void update(UserAccount user) {
		em.merge(user);

	}

}
