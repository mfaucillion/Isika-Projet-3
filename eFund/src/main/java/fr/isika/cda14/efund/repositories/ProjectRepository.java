package fr.isika.cda14.efund.repositories;

import java.util.List;

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
	
	public List<Project> findAll(){
		return this.em
				.createQuery("SELECT pro FROM Project pro", Project.class)
				.getResultList();
	}

}
