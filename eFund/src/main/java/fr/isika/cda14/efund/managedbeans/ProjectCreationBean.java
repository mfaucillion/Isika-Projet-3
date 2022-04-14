package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.services.ProjectCreationService;
import fr.isika.cda14.efund.viewmodel.ProjectCreationFormVM;

@ManagedBean
public class ProjectCreationBean {

	@Inject
	private ProjectCreationService projectCreationService;

	private ProjectCreationFormVM projectCreationFormVM = new ProjectCreationFormVM();

	public String createProject() {
		projectCreationService.create(projectCreationFormVM);
		return "projectCreationForm.xhtml";
	}

	public ProjectCreationFormVM getProjectCreationFormVM() {
		return projectCreationFormVM;
	}

	public void setProjectCreationFormVM(ProjectCreationFormVM projectCreationFormVM) {
		this.projectCreationFormVM = projectCreationFormVM;
	}

}
