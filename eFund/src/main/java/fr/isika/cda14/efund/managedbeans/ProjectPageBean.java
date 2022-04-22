
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

@ManagedBean
@ViewScoped
public class ProjectPageBean {

	@Inject
	private ProjectService projectService;

	private Project project;

	private OrganizationAccount organizationAccount;

	private Long remainingDays;

	public void onLoad(String id) {
		this.project = projectService.findProject(Long.parseLong(id));
		this.organizationAccount = projectService.getOrgFromProject(Long.parseLong(id));
		this.remainingDays = calculRemainingDays();
	}

	public int percentage(BigDecimal currentCollect, BigDecimal target) {
		return (currentCollect.intValue() * 100) / target.intValue();
	}

	private Long calculRemainingDays() {
		Date endDate = new Date(this.project.getEndDate().getTime());
		System.out.println(endDate);
		ZonedDateTime endDateTime = ZonedDateTime.ofInstant(endDate.toInstant(), ZoneId.of("UTC"));

		return ChronoUnit.DAYS.between(ZonedDateTime.now(), endDateTime);
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
}