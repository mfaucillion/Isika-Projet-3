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
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.entity.shop.Shop;
import fr.isika.cda14.efund.entity.space.OrganizationSpace;

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

	public OrganizationSpace findOrgSpace(Long id) {
		return em.find(OrganizationSpace.class, id);
	}

	public void update(OrganizationSpace orgSpace) {
		em.merge(orgSpace);
	}

	/* */
	public OrganizationAccount loadOrganizationAccountWithChildren(Long id) {
		String query = "SELECT distinct shop "
				+ "FROM OrganizationAccount org "
				+ "INNER JOIN org.organizationSpace space "
				+ "INNER JOIN space.shop shop "
				+ "INNER JOIN FETCH shop.items "
				+ "WHERE org.id=:id";
		Shop shop = em.createQuery(query, Shop.class).setParameter("id", id).getSingleResult();

		query = "SELECT distinct space " + "FROM OrganizationAccount org "
				+ "INNER JOIN org.organizationSpace space "
				+ "INNER JOIN FETCH space.projects "
				+ "INNER JOIN space.shop shop "
				+ "WHERE space.shop in :shop";
		OrganizationSpace space = em.createQuery(query, OrganizationSpace.class).setParameter("shop", shop)
				.getSingleResult();

		query = "SELECT distinct space "
				+ "FROM OrganizationAccount org "
				+ "INNER JOIN org.organizationSpace space "
				+ "INNER JOIN FETCH space.events "
				+ "INNER JOIN space.shop shop "
				+ "WHERE org.organizationSpace in :space";
		space = em.createQuery(query, OrganizationSpace.class).setParameter("space", space).getSingleResult();

		query = "SELECT distinct org "
				+ "FROM OrganizationAccount org "
				+ "INNER JOIN org.organizationSpace space "
				+ "INNER JOIN space.shop shop "
				+ "WHERE org.organizationSpace in :space";
		OrganizationAccount account = em.createQuery(query, OrganizationAccount.class).setParameter("space", space)
				.getSingleResult();

		return account;
	}

	public OrganizationAccount getOrgFromProjectOrEvent(Long id) {
		String query = "SELECT orgAcc "
				+ "FROM OrganizationAccount orgAcc "
				+ "JOIN orgAcc.organizationSpace orgSpace "
				+ "JOIN orgSpace.projects pro "
				+ "WHERE pro.id =:id ";
		System.out.println("c'est id projet: " + id +" " + query);
		OrganizationAccount account = em.createQuery(query, OrganizationAccount.class)
				.setParameter("id", id)
				.getSingleResult();
		return account;
	}
	
}
