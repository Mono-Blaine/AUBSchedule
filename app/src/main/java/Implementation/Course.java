package Implementation;
import java.time.LocalTime;

public class Course {
	private String  crn       = "N/A";
	private String  subject   = "N/A";
	private String  num       = "N/A";
	private String  section   = "N/A";
	private String  title     = "N/A";
	private float   credits   = 0;
	private String  college   = "N/A";
	private int 	enrolled  = 0;
	private int 	available = 0;
	private LocalTime begin = LocalTime.of(0, 0) ;
	private LocalTime end   = LocalTime.of(0, 0);
	private String  building  = "N/A";
	private String  roomNum   = "N/A";
	private boolean monday    = false;
	private boolean tuesday   = false;
	private boolean wednesday = false;
	private boolean thursday  = false;
	private boolean friday    = false;
	private boolean saturday  = false;
	private String  firstName = "N/A";
	private String  lastName  = "N/A";
	private String  semester  = "N/A";
	
	private boolean isDigits(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}
		return true;
	}	
	public Course(String[] arr) {
		try {
			this.semester = arr[0].split(" ")[0];
			System.out.println("XXXXXXXXXXXXXXXX:  "+semester);
			this.crn = arr[1];
			this.subject = arr[2];
			this.num = arr[3];
			this.section = arr[4];
			this.title = arr[5];
			if (isDigits(arr[6]))
				this.credits = Integer.parseInt(arr[6]);
			this.college = arr[8];
			if (isDigits(arr[9]))
				this.enrolled = Integer.parseInt(arr[9]);
			if (isDigits(arr[10]))
				this.available = Integer.parseInt(arr[10]);
			if (arr[11].compareTo("N/A") != 0)
				this.begin = LocalTime.of(Integer.parseInt(arr[11].substring(0, 2)), Integer.parseInt(arr[11].substring(2, 4)));
			if (arr[12].compareTo("N/A") != 0)
				this.end = LocalTime.of(Integer.parseInt(arr[12].substring(0, 2)), Integer.parseInt(arr[12].substring(2, 4)));
			this.building = arr[13];
			this.roomNum = arr[14];
			this.monday = arr[15].compareTo("M") == 0;
			this.tuesday = arr[16].compareTo("T") == 0;
			this.wednesday = arr[17].compareTo("W") == 0;
			this.thursday = arr[18].compareTo("R") == 0;
			this.friday = arr[19].compareTo("F") == 0;
			this.saturday = arr[20].compareTo("S") == 0;
			this.firstName = arr[33];
			this.lastName = arr[34];
		}
		catch (Exception e) {}
	}

	public String getCrn() {
		return crn;
	}

	public String getSubject() {
		return subject;
	}

	public String getCourse_num() {
		return num;
	}

	public String getSection() {
		return section;
	}

	public String getTitle() {
		return title;
	}

	public float getCredithrs() {
		return credits;
	}

	public String getCollege() {
		return college;
	}

	public int getActual_enroll() {
		return enrolled;
	}

	public int getSeats_available() {
		return available;
	}

	public LocalTime getBegin_time() {
		return begin;
	}

	public LocalTime getEnd_time() {
		return end;
	}

	public String getBldg() {
		return building;
	}

	public String getRoom() {
		return roomNum;
	}

	public boolean getMonday() {
		return monday;
	}

	public boolean getTuesday() {
		return tuesday;
	}

	public boolean getWednesday() {
		return wednesday;
	}

	public boolean getThursday() {
		return thursday;
	}

	public boolean getFriday() {
		return friday;
	}

	public boolean getSaturday() {
		return saturday;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSemester() {
		return semester;
	}
}
