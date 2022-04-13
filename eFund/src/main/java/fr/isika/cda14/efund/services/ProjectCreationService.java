package fr.isika.cda14.efund.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.repositories.ProjectRepository;
import fr.isika.cda14.efund.viewModels.ProjectCreationFormVM;

@Stateless
public class ProjectCreationService {
	
	@Inject
	private ProjectRepository projectRepo;
	
	public void create(ProjectCreationFormVM projectCreationFormVM) {
		System.out.println("Service; " + projectCreationFormVM);
		Project newProject = new Project();
		newProject.setName(projectCreationFormVM.getName());
		newProject.setEndDate(projectCreationFormVM.getEndDate());
		newProject.setSummary(projectCreationFormVM.getSummary());
		newProject.setImagePath(projectCreationFormVM.getImagePath());
		newProject.setLocation(projectCreationFormVM.getLocation());
		newProject.setProjectCategory(projectCreationFormVM.getCategory());
		newProject.setProjectRange(projectCreationFormVM.getProjectRange());
		projectRepo.create(newProject);
		
		
	}

}
