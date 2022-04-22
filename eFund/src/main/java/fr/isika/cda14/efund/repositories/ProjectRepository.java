package fr.isika.cda14.efund.repositories;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda14.efund.entity.project.Favorite;
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

	// recherche d'un projet par son nom à partir de la page ProjectsList
	public List<Project> searchProjectFromPage(String searchProject) {
		String query = "SELECT projName FROM Project projName WHERE projName.name in :searchProject ";
		return em.createQuery(query, Project.class).setParameter("searchProject", searchProject).getResultList();
	}

	public void remove(Project project) {
		em.remove(project);
	}

	public void update(Project proj) {
		em.merge(proj);
	}

	public List<Project> getTopProjects() {
		String query = "SELECT proj " + "FROM Project proj " + "ORDER BY proj.creationDate";
		return em.createQuery(query, Project.class).setMaxResults(3).getResultList();
	}
}
