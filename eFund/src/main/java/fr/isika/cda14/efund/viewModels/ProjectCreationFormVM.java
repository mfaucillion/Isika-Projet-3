package fr.isika.cda14.efund.viewModels;

import java.util.Date;

import fr.isika.cda14.efund.entity.enums.ProjectCategory;
import fr.isika.cda14.efund.entity.enums.ProjectRange;

public class ProjectCreationFormVM {

	private String name;
	private Date endDate;
	private String summary;
	private String imagePath;
	private String location;

	private ProjectCategory category;
	private ProjectRange projectRange;
	
	public ProjectCategory[] getProjectCategories() {
		return ProjectCategory.values();
	}
	
	public ProjectRange[] getProjectRanges() {
		return ProjectRange.values();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ProjectCategory getCategory() {
		return category;
	}

	public void setCategory(ProjectCategory category) {
		this.category = category;
	}

	public ProjectRange getProjectRange() {
		return projectRange;
	}

	public void setProjectRange(ProjectRange projectRange) {
		this.projectRange = projectRange;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProjectCreationFormVM [name=");
		builder.append(name);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", summary=");
		builder.append(summary);
		builder.append(", imagePath=");
		builder.append(imagePath);
		builder.append(", location=");
		builder.append(location);
		builder.append(", category=");
		builder.append(category);
		builder.append(", projectRange=");
		builder.append(projectRange);
		builder.append("]");
		return builder.toString();
	}

}
