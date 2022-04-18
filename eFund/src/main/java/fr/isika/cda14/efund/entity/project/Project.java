package fr.isika.cda14.efund.entity.project;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.isika.cda14.efund.entity.space.OrganizationSpace;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Project extends GenericProject {

	@Column(name = "target_amount", scale = 2)
	private BigDecimal targetAmount;

	@Column(name = "current_amount", scale = 2)
	private BigDecimal currentAmount;

	@OneToMany
	@JoinColumn(name = "project_id")
	private List<Donation> donations;

	@OneToMany
	@JoinColumn(name = "project_id")
	protected List<CounterPart> counterParts;

	@OneToMany
	@JoinColumn(name = "project_id")
	protected List<StretchGoal> stretchGoals;
	
	@ManyToOne
	@JoinColumn(name = "organization_space_id")
	private OrganizationSpace organizationSpace;

	public void setTargetAmount(BigDecimal targetAmount) {
		this.targetAmount = targetAmount;
	}

	public BigDecimal getTargetAmount() {
		return targetAmount;
	}

	public BigDecimal getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(BigDecimal currentAmount) {
		this.currentAmount = currentAmount;
	}

	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}

	public List<CounterPart> getCounterParts() {
		return counterParts;
	}

	public void setCounterParts(List<CounterPart> counterParts) {
		this.counterParts = counterParts;
	}

	public List<StretchGoal> getStretchGoals() {
		return stretchGoals;
	}

	public void setStretchGoals(List<StretchGoal> stretchGoals) {
		this.stretchGoals = stretchGoals;
	}

	public OrganizationSpace getOrganizationSpace() {
		return organizationSpace;
	}

	public void setOrganizationSpace(OrganizationSpace organizationSpace) {
		this.organizationSpace = organizationSpace;
	}	
}
