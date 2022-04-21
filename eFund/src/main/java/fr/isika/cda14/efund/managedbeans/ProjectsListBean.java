package fr.isika.cda14.efund.managedbeans;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.services.ProjectService;

@ManagedBean
@ViewScoped
public class ProjectsListBean {

	@Inject
	private ProjectService projectService;
	
	private OrganizationAccount organizationAccount;

	private List<Project> projectsList;
	
	public void onLoad() {
		projectsList = getAllProjects();
	}

	private List<Project> getAllProjects() {
		return this.projectService.findAll();
	}
	
	public List<Project> getProjectList(){
		return projectsList;
	}

	public int percentage(BigDecimal currentCollect, BigDecimal target) {
		return (currentCollect.intValue() * 100) / target.intValue();
	}
}