package fr.isika.cda14.efund.entity.project;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

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

	public void setTargetAmount(BigDecimal targetAmount) {
		this.targetAmount = targetAmount;
	}
	
	public BigDecimal getTargetAmount() {
		return targetAmount;
	}

}
