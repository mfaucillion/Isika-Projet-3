
package fr.isika.cda14.efund.managedbeans;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.services.ProjectService;
import fr.isika.cda14.efund.services.InteractionService;
import fr.isika.cda14.efund.tool.SessionTool;

@ManagedBean
@ViewScoped
public class ProjectPageBean {

	@Inject
	private ProjectService projectService;
	
	@Inject
	private InteractionService interactionService;

	private Project project;

	private OrganizationAccount organizationAccount;

	private Long remainingDays;

	private Long donationDuration;

	public void onLoad(String id) {
		this.project = projectService.findProject(Long.parseLong(id));
		this.organizationAccount = projectService.getOrgFromProject(Long.parseLong(id));
		this.remainingDays = calculRemainingDays();
		this.donationDuration = calculdonationDuration();
	}

	public int percentage(BigDecimal currentCollect, BigDecimal target) {
		return (currentCollect.intValue() * 100) / target.intValue();
	}

	public Long calculdonationDuration() {
		Date endDate = new Date(this.project.getEndDate().getTime());
		Date startDate = new Date(this.project.getCreationDate().getTime());
		ZonedDateTime endDateTime = ZonedDateTime.ofInstant(endDate.toInstant(), ZoneId.of("UTC"));
		ZonedDateTime startDateTime = ZonedDateTime.ofInstant(startDate.toInstant(), ZoneId.of("UTC"));

		return ChronoUnit.DAYS.between(startDateTime, endDateTime);
	}

	public int countDown(BigDecimal remaining, BigDecimal duration) {
		if (duration.intValue() == 0) {
			return 0;
		}
		return ((remaining.intValue() * 100) / duration.intValue());
	}

	private Long calculRemainingDays() {
		Date endDate = new Date(this.project.getEndDate().getTime());
		System.out.println(endDate);
		ZonedDateTime endDateTime = ZonedDateTime.ofInstant(endDate.toInstant(), ZoneId.of("UTC"));
		Long remainingDays = ChronoUnit.DAYS.between(ZonedDateTime.now(), endDateTime);
		
		if (remainingDays < 0) {
			remainingDays = 0L;
		}
		return remainingDays;
	}
	
	public void addFavorite() {
		interactionService.addFavorite(SessionTool.getUserId(), project);
	}
	
	public void updateProject() {
		projectService.update(project);
	}

	public Project getProject() {
		return project;
	}

	public OrganizationAccount getOrganizationAccount() {
		return organizationAccount;
	}

	public Long getRemainingDays() {
		return remainingDays;
	}

	public Long getDonationDuration() {
		return donationDuration;
	}

}