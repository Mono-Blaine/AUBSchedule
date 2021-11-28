package Implementation;

import java.time.LocalTime;

public class Schedule {
	private String room = "N/A";
	private LocalTime from = LocalTime.of(0, 0);
	private LocalTime to = LocalTime.of(0, 0);
	private String instructor = "N/A";
	private String course = "N/A";
	private String subject = "N/A";
	private boolean monday = false;
	private boolean tuesday = false;
	private boolean wednesday = false;
	private boolean thursday = false;
	private boolean friday = false;
	private boolean saturday = false;
	
	public Schedule() {}

	public Schedule(String room, LocalTime from, LocalTime to, String instructor, String course, String subject,
			boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday) {
		this.room = room;
		this.from = from;
		this.to = to;
		this.instructor = instructor;
		this.course= course;
		this.subject = subject;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
	}

	public String getRoom() {
		return room;
	}

	public LocalTime getFromTime() {
		return from;
	}

	public LocalTime getToTime() {
		return to;
	}

	public String getInstructor() {
		return instructor;
	}

	public String getCourse() {
		return course;
	}

	public String getSubject() { return subject; }

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
	
	public String getDays() {
		String result = "";
		if (monday)
			result += "M ";
		if (tuesday)
			result += "T ";
		if (wednesday)
			result += "W ";
		if (thursday)
			result += "R ";
		if (friday)
			result += "F ";
		if (saturday)
			result += "F ";
		return result;
	}
}
