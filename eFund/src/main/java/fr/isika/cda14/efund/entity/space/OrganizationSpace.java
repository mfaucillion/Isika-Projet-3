package fr.isika.cda14.efund.entity.space;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.common.ContentTab;
import fr.isika.cda14.efund.entity.project.GenericProject;
import fr.isika.cda14.efund.entity.shop.Shop;

@Entity
@Table(name = "organization_space")
public class OrganizationSpace {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Shop shop;

	@OneToMany
	@JoinColumn(name = "organization_space_id")
	private List<Follow> follows;

	@OneToMany
	@JoinColumn(name = "organization_space_id")
	private List<ContentTab> contentTabs;

	@OneToMany
	@JoinColumn(name = "organization_space_id")
	private List<GenericProject> genericProjects;

}
