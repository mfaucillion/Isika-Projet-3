package fr.isika.cda14.efund.services;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.enums.ProjectStatus;
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
		newProject.setProjectCategory(projectCreationFormVM.getProjectCategory());
		newProject.setProjectRange(projectCreationFormVM.getProjectRange());
		newProject.setTargetAmount(projectCreationFormVM.getTargetAmount());
		newProject.setProjectStatus(ProjectStatus.DRAFT);
		newProject.setCreationDate(new Date());

		projectRepo.create(newProject);

	}

}
