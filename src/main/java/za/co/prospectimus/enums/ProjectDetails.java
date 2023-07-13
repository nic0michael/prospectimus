package za.co.prospectimus.enums;

public enum ProjectDetails {
	DEFAULT("1.0","Business Dashboard");

	String projectName;
	String projectVersion;

	
	private ProjectDetails(String projectName, String projectVersion) {
		this.projectName = projectName;
		this.projectVersion = projectVersion;
	}


	public String projectName() {
		return projectName;
	}


	public String projectVersion() {
		return projectVersion;
	}
	
	

}
