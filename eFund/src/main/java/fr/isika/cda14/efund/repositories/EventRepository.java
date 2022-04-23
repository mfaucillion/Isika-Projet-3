package fr.isika.cda14.efund.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.project.Event;

@Stateless
public class EventRepository {

	@PersistenceContext
	private EntityManager em;

	public void create(Event event) {
		em.persist(event);
	}

	public List<Event> findAll() {
		List<Event> events;
		events = em.createQuery("SELECT e FROM Event e", Event.class).getResultList();
		return events;
	}

	public Event find(Long id) {
		return em.find(Event.class, id);
	}

	public void remove(Event event) {
		em.remove(event);
	}

	public void update(Event myEvent) {
		em.merge(myEvent);
	}

	public List<Event> getTopEvents() {
		String query = "SELECT event " + "FROM Event event " + "ORDER BY event.creationDate";
		return em.createQuery(query, Event.class).setMaxResults(3).getResultList();
	}

	public List<Event> getOrgsEvents(Long orgSpaceId) {
		String query = "SELECT events FROM OrganizationSpace os JOIN os.events events WHERE os.id=:id";
		return em.createQuery(query, Event.class).setParameter("id", orgSpaceId).getResultList();
	}
}
