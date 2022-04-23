package fr.isika.cda14.efund.repositories;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.project.Favorite;

@Stateless
public class InteractionRepository {

	@PersistenceContext
	EntityManager em;

	public void persists(Favorite fav) {
		em.persist(fav);
	}

	public List<Favorite> checkFavorite(Long userId, Long projId) {
		String query = "SELECT fav from Favorite fav " + "WHERE fav.userSpace.id=:uid "
				+ "AND fav.genericProject.id=:pid";
		return em.createQuery(query, Favorite.class).setParameter("uid", userId).setParameter("pid", projId)
				.getResultList();

	}

	public void remove(Favorite fav) {
		em.remove(fav);
	}

	public Favorite getFavorite(Long userId, Long projId) {
		String query = "SELECT fav from Favorite fav " + "WHERE fav.userSpace.id=:uid "
				+ "AND fav.genericProject.id=:pid";
		return em.createQuery(query, Favorite.class).setParameter("uid", userId).setParameter("pid", projId)
				.getSingleResult();

	}
}
