package fr.isika.cda14.efund.repositories;

import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.account.Account;
import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.account.UserAccount;

@Stateless
public class UserAccountRepository {

	@PersistenceContext
	private EntityManager em;

	public void persists(UserAccount newUser) {
		em.persist(newUser);
	}

	public Optional<Account> findByEmail(String email) {
		try {
			Optional<Account> result = Optional.ofNullable(em.createQuery("SELECT acc "
					+ "FROM Account acc "
					+ "WHERE acc.email = :email ", Account.class)
					.setParameter("email", email)
					.getSingleResult());
			return result;
		}catch(NoResultException ex) {
			System.out.println("Aucun utilisateur trouvé");
		}
		return Optional.empty();
	}
	
}
