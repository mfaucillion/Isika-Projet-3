package fr.isika.cda14.efund.repositories;

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

}
