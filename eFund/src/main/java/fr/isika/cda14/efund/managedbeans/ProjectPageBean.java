
package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.services.ProjectService;
import fr.isika.cda14.efund.viewmodel.ProjectCreationFormVM;

@ManagedBean
public class ProjectPageBean {

	@Inject
	private ProjectService projectService;

	private ProjectCreationFormVM projectCreationFormVM = new ProjectCreationFormVM();

	private Project project;

	private OrganizationAccount organizationAccount;

	public void onLoad(String id) {
		project = projectService.findProject(Long.parseLong(id));
	}

	public Project getProject() {
		return project;
	}

	public OrganizationAccount getOrgAccount(Long id) {
		System.out.println("coucou " + organizationAccount);
		return projectService.getOrgFromProjectEvent(id);

	}
}