
package fr.isika.cda14.efund.managedbeans;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.project.Project;
import fr.isika.cda14.efund.services.ProjectService;
import fr.isika.cda14.efund.viewmodel.ProjectCreationFormVM;

@ManagedBean
public class ProjectPageBean {

	@Inject
	private ProjectService projectService;

	private ProjectCreationFormVM projectCreationFormVM = new ProjectCreationFormVM();

	private Project project;

	private OrganizationAccount organizationAccount;

	public void onLoad(String id) {
		project = projectService.findProject(Long.parseLong(id));
	}

	public Project getProject() {
		return project;
	}

	public OrganizationAccount getOrgAccount(Long id) {
		System.out.println("coucou " + organizationAccount);
		return projectService.getOrgFromProjectEvent(id);
	}
	
	public int percentage(BigDecimal currentCollect, BigDecimal target) {
		return (currentCollect.intValue() * 100)/target.intValue();		
	}
	
	public int calculRemainingDays(String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	     try {
	    	 LocalDate todaysDate = LocalDate.now();
	    	 System.out.println("ce jour : " + todaysDate + " test date : " + endDate);
	         Date dateAvant = sdf.parse("02/25/2021");
	         Date dateApres = sdf.parse(endDate);
	         long diff = dateApres.getTime() - dateAvant.getTime();
	         float res = (diff / (1000*60*60*24));
	         System.out.println("Nombre de jours entre les deux dates est: "+ res + "date du jour : " + todaysDate);
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
        return 123;
		
	}
}