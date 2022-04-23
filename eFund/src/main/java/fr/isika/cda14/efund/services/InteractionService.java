package fr.isika.cda14.efund.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.UserAccount;
import fr.isika.cda14.efund.entity.project.Favorite;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.repositories.InteractionRepository;

@Stateless
public class InteractionService {
	@Inject
	AccountService accountService;
	
	@Inject
	ProjectService projectService;
	
	@Inject
	InteractionRepository repo;

	public void addFavorite(Long userId, Project project) {
		Favorite fav = new Favorite();
		
		UserAccount user = accountService.findUserAccountById(userId);
		fav.setGenericProject(project);
		fav.setUserSpace(user.getUserSpace());
		
		repo.persists(fav);
	}
	
	
}
