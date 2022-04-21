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

	public List<Project> findAll() {
		return this.em.createQuery("SELECT pro FROM Project pro", Project.class).getResultList();
	}

	// recherche d'un projet à partir d'un id
	public Project findProject(Long id) {
		return this.em.find(Project.class, id);
	}

	public void remove(Project project) {
		em.remove(project);
	}

	public void update(Project proj) {
		em.merge(proj);		

	public List<Project> getTopProjects() {
		String query = "SELECT proj "
				+ "FROM Project proj "
				+ "ORDER BY proj.creationDate";
		return em.createQuery(query, Project.class).setMaxResults(3).getResultList();
	}
}
