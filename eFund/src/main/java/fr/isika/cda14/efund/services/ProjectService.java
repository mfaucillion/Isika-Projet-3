package fr.isika.cda14.efund.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.entity.enums.ProjectStatus;
import fr.isika.cda14.efund.entity.project.Donation;
import fr.isika.cda14.efund.entity.project.Favorite;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.entity.space.OrganizationSpace;
import fr.isika.cda14.efund.repositories.AccountRepository;
import fr.isika.cda14.efund.repositories.DonationRepository;
import fr.isika.cda14.efund.repositories.ProjectRepository;
import fr.isika.cda14.efund.tool.SessionTool;
import fr.isika.cda14.efund.viewmodel.DonationVM;
import fr.isika.cda14.efund.viewmodel.ProjectCreationFormVM;

@Stateless
public class ProjectService {

	@Inject
	private ProjectRepository projectRepo;

	@Inject
	private AccountRepository accountRepo;

	@Inject
	private DonationRepository donationRepo;

	public void create(ProjectCreationFormVM projectCreationFormVM, Long id) {
		Project newProject = new Project();
		newProject.setName(projectCreationFormVM.getName());
		newProject.setEndDate(projectCreationFormVM.getEndDate());
		newProject.setSummary(projectCreationFormVM.getSummary());
		newProject.setImagePath(projectCreationFormVM.getImagePath());
		newProject.setLocation(projectCreationFormVM.getLocation());
		newProject.setProjectCategory(projectCreationFormVM.getProjectCategory());
		newProject.setProjectRange(projectCreationFormVM.getProjectRange());
		newProject.setCurrentAmount(new BigDecimal(0));
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

	public Project findProject(Long id) {
		return projectRepo.findProject(id);
	}

	public List<Project> searchProjectFromPage(String searchProject) {
		return projectRepo.searchProjectFromPage(searchProject);
	}

	public void createDonation(DonationVM donationVM, Long id) {
		Donation newDon = new Donation();
		newDon.setAmount(donationVM.getAmount());

		// UserAccount userAccount = accountRepo.findUser(SessionTool.getUserId());
		UserAccount userAccount = accountRepo.findUser(1000L);
		newDon.setUserSpace(userAccount.getUserSpace());

		Project project = projectRepo.findProject(id);
		newDon.setProject(project);
		project.setCurrentAmount(project.getCurrentAmount().add(newDon.getAmount()));

		donationRepo.createDonationRepo(newDon);

	}

	public OrganizationAccount getOrgFromProject(Long id) {
		return accountRepo.getOrgFromProject(id);
	}

	public void deleteProject(Long id) {
		Project project = findProject(id);
		projectRepo.remove(project);
	}

	public void update(Project proj) {
		projectRepo.update(proj);
	}

	public List<Project> getTopProjects() {
		return projectRepo.getTopProjects();
	}
}
