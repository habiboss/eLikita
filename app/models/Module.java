package models;

import javax.persistence.*;

@Entity
@Table(name = "module")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "title")
	private String moduleTitle;
	@Column(name = "code")
	private String moduleCode;
	@Column(name = "year")
	private String moduleYear;
	@Column(name = "period")
	private String modulePeriod;
	@Column(name = "description")
	private Long moduleDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModuleTitle() {
		return moduleTitle;
	}

	public void setModuleTitle(String moduleTitle) {
		this.moduleTitle = moduleTitle;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getModuleYear() {
		return moduleYear;
	}

	public void setModuleYear(String moduleYear) {
		this.moduleYear = moduleYear;
	}

	public String getModulePeriod() {
		return modulePeriod;
	}

	public void setModulePeriod(String modulePeriod) {
		this.modulePeriod = modulePeriod;
	}

	public Long getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(Long moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

}
