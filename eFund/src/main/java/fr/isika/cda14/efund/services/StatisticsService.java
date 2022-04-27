package fr.isika.cda14.efund.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.common.Statistics;
import fr.isika.cda14.efund.repositories.StatisticsRepository;
import fr.isika.cda14.efund.viewmodel.StatisticsViewModel;

@Stateless
public class StatisticsService {
	@Inject
	StatisticsRepository statsRepo;
	
	StatisticsViewModel statsVM = new StatisticsViewModel();

	public StatisticsViewModel getStats() {
		Statistics stats = statsRepo.getStats();
		
		Integer nbGenericProjects = stats.getNbProjects() + stats.getNbEvents();
		Integer averageGenericProjects =  nbGenericProjects / stats.getNbOrganizations();
		Integer averageDonations = stats.getTotalDonations() / stats.getNbProjects();
		Integer averageVolunteers = stats.getNbVolunteers() / stats.getNbEvents();
		
		statsVM.setNbOrganizations(stats.getNbOrganizations());
		statsVM.setNbProjects(stats.getNbProjects());
		statsVM.setNbEvents(stats.getNbEvents());
		statsVM.setNbVolunteers(stats.getNbVolunteers());
		statsVM.setNbDonations(stats.getNbDonations());
		statsVM.setTotalDonations(stats.getTotalDonations());
		statsVM.setSoldProducts(stats.getSoldProducts());
		statsVM.setAverageDonations(averageDonations);
		statsVM.setAverageVolunteers(averageVolunteers);
		statsVM.setAverageGenericProjects(averageGenericProjects);
		
		return statsVM;
	}	
	
}
