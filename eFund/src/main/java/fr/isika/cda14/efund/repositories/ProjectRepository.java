package fr.isika.cda14.efund.repositories;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.project.Project;

@Stateless
public class ProjectRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void create(Project project) {
		em.persist(project);
		
	}
}
