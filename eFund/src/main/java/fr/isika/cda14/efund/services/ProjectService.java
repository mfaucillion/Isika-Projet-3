package fr.isika.cda14.efund.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.enums.ProjectStatus;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.entity.space.OrganizationSpace;
import fr.isika.cda14.efund.repositories.AccountRepository;
import fr.isika.cda14.efund.repositories.ProjectRepository;
import fr.isika.cda14.efund.viewmodel.ProjectCreationFormVM;

@Stateless
public class ProjectService {

	@Inject
	private ProjectRepository projectRepo;
	@Inject
	private AccountRepository accountRepo;

	public void create(ProjectCreationFormVM projectCreationFormVM, Long id) {
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
		
		OrganizationSpace orgSpace = accountRepo.findOrgSpace(id);
		
		newProject.setOrganizationSpace(orgSpace);
		
		projectRepo.create(newProject);
	}

	public List<Project> findAll() {
		return projectRepo.findAll();
	}

}
