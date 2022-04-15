package fr.isika.cda14.efund.repositories;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.account.Account;
import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.account.UserAccount;

@Stateless
public class AccountRepository {

	@PersistenceContext
	private EntityManager em;

	/* Persistance des comptes User */
	public Long persist(UserAccount newUser) {
		em.persist(newUser);
		return newUser.getId();
	}

	/* Persistance des comptes Organization */
	public Long persist(OrganizationAccount newOrg) {
		em.persist(newOrg);
		return newOrg.getId();
	}

	/* Mise à jour des comptes User */
	public void update(UserAccount user) {
		em.merge(user);
	}

	/* Mise à jour des comptes Organization */
	public void update(OrganizationAccount myOrg) {
		em.merge(myOrg);
	}

	/* Recherche d'un compte User à partir d'un ID */
	public UserAccount findUser(Long id) {
		return em.find(UserAccount.class, id);
	}

	/* Recherche d'un compte Organization à partir d'un ID */
	public OrganizationAccount findOrganization(Long id) {
		return em.find(OrganizationAccount.class, id);
	}

	/* Recherche d'un compte tout type confondu à partir d'un email */
	public Optional<Account> findByEmail(String email) {
		try {
			Optional<Account> result = Optional.ofNullable(
					em.createQuery("SELECT acc " + "FROM Account acc " + "WHERE acc.email = :email ", Account.class)
							.setParameter("email", email).getSingleResult());
			return result;
		} catch (NoResultException ex) {
			System.out.println("Aucun utilisateur trouvé");
		}
		return Optional.empty();
	}

	/* Récupération de la liste de toutes les Organizations */
	public List<OrganizationAccount> findAll() {
		return this.em.createQuery(
				"SELECT orgAcc from OrganizationAccount orgAcc " + "left join fetch orgAcc.organizationInfo orgInfo",
				OrganizationAccount.class).getResultList();
	}

	/* Recherche d'un Organization Space id à partir d'un ID */
	public Long findOrgSpace(Long id) {
		return findOrganization(id).getOrganizationSpace().getId();
	}

}
