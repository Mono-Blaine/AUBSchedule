package Implementation;

public class Instructor {
	private String fName;
	private String lName;
	
	public Instructor(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
	}

	public String getFirstName() {
		return fName;
	}

	public String getLastName() {
		return lName;
	}

}
