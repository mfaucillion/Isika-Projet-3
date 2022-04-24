
package fr.isika.cda14.efund.managedbeans;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.services.InteractionService;
import fr.isika.cda14.efund.services.ProjectService;
import fr.isika.cda14.efund.tool.FileUpload;
import fr.isika.cda14.efund.tool.SessionTool;
import fr.isika.cda14.efund.viewmodel.ContentVM;
import fr.isika.cda14.efund.viewmodel.DonationVM;

@ManagedBean
@ViewScoped
public class ProjectPageBean {

	@Inject
	private ProjectService projectService;

	@Inject
	private InteractionService interactionService;
	
	private Project project;

	private OrganizationAccount organizationAccount;
	
	private DonationVM donationVM = new DonationVM();
	
	private ContentVM contentBlockMV = new ContentVM();

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
		ZonedDateTime endDateTime = ZonedDateTime.ofInstant(endDate.toInstant(), ZoneId.of("UTC"));
		Long remainingDays = ChronoUnit.DAYS.between(ZonedDateTime.now(), endDateTime);

		if (remainingDays < 0) {
			remainingDays = 0L;
		}
		return remainingDays;
	}

	/* Méthodes d'interaction User -> Project */

	/* Section Favoris */

	public void addFavorite() {
		interactionService.addFavorite(SessionTool.getUserId(), project);
	}

	public void removeFavorite() {
		interactionService.removeFavorite(SessionTool.getUserId(), project.getId());
	}

	public Boolean isFaved() {
		return interactionService.checkFavorite(SessionTool.getUserId(), project.getId());
	}

	/* Section Likes */

	public void addLike() {
		interactionService.addLike(SessionTool.getUserId(), project);
	}

	public void removeLike() {
		interactionService.removeLike(SessionTool.getUserId(), project.getId());
	}

	public Boolean isLiked() {
		return interactionService.checkLike(SessionTool.getUserId(), project.getId());
	}
	
	/* Ajout de Donation */
	
	public void createDonation() {
		projectService.createDonation(donationVM, project.getId());
	}
	
	/* Gestion des blocs de contenu dans l'onglet Contenu */
	
	public Boolean isOfType(String blockType, String tagType) {
		return blockType.equals(tagType);
	}
	
	public void createBlock(String type) {
		contentBlockMV.setType(type);
		projectService.addContent(contentBlockMV, project);
	}
	
	public void removeBlock(Long blockId) {
		projectService.removeBlock(blockId);
	}
	
	public void uploadFile(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		String filePath = "/content/" + file.getFileName();
		contentBlockMV.setContent("img" + filePath);
		FileUpload.doUpload(file, filePath);
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

	public DonationVM getDonationVM() {
		return donationVM;
	}

	public void setDonationVM(DonationVM donationVM) {
		this.donationVM = donationVM;
	}

	public ContentVM getContentBlockMV() {
		return contentBlockMV;
	}

	public void setContentBlockMV(ContentVM contentBlockMV) {
		this.contentBlockMV = contentBlockMV;
	}
}