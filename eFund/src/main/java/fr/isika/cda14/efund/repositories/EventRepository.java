package fr.isika.cda14.efund.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.project.Event;

@Stateless
public class EventRepository {

	@PersistenceContext
	private EntityManager emEvent;

	public void create(Event event) {
		emEvent.persist(event);

	}

}
