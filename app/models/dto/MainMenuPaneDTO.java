package models.dto;

public class MainMenuPaneDTO {
	
	private String journee;
	private String userConnected;
	private String institutionName;
	private String userType;

	
	public String getJournee() {
		return journee;
	}
	public void setJournee(String journee) {
		this.journee = journee;
	}
	public String getUserConnected() {
		return userConnected;
	}
	public void setUserConnected(String userConnected) {
		this.userConnected = userConnected;
	}
	public String getInstitutionName() {
		return institutionName;
	}
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
