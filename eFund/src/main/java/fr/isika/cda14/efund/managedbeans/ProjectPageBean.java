
package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.services.ProjectService;
import fr.isika.cda14.efund.viewmodel.ProjectCreationFormVM;

@ManagedBean
public class ProjectPageBean {

	@Inject
	private ProjectService projectCreationService;
	
	private ProjectCreationFormVM projectCreationFormVM = new ProjectCreationFormVM();

}