package Implementation;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.TreeMap;

public class Print {
	
	/**
	 * <b>requires:</b> none <p>
	 * <b>effects:</b> prints all the methods the user can use, their parameters, and what they do
	 * @return <i>void</i>
	 */
	public void printMethods() {
		System.out.format("Methods: \t...case insensitive except for the commands...\n"
				+ "%-50s \\\\ lists all the rooms in alphabetical and numerical order\n"
				+ "%-50s \\\\ lists the schedule for the given room\n"
				+ "%-50s \\\\ lists the schedule for the given room at the given date\n"
				+ "%-50s \\\\ lists the schedule for the given room at the given day\n"
				+ "%-50s \\\\ lists the last professor in the specified room, if any\n"
				+ "%-50s \\\\ lists the professor currently in the specified room, if any\n"
				+ "%-50s \\\\ lists the professor's entire schedule\n"
				+ "%-50s \\\\ lists the room the professor is currently in, if any\n"
				+ "%-50s \\\\ lists the professor's schedule at the day of calling\n",
				"roomSchedule", "roomSchedule <room> <number>", "roomSchedule <room> <number> <year> <month> <day>",
				"roomSchedule <room> <number> <day>", "whoWasThereLast <room> <number>", "whoIsThereNow <room> <number>",
				"profSchedule <first name> <last name>", "whereIsProf <first name> <last name>",
				"whereWillProfBe <first name> <last name>");
	}
	
	/**
	 * <b>requires:</b> <i>map</i> not be null <p>
	 * <b>effects:</b> prints all the schedules in the provided TreeMap in alphabetical and numerical room order
	 * @param map a TreeMap with keys of type <i>Room</i> and values of type List of <i>Schedule</i>
	 * @return <i>void</i>
	 */
	public void printRoomSchedule(TreeMap<Room, List<Schedule>> map) {
		String mon = "\n--> MONDAY:\n";
		String tues = "\n--> TUESDAY:\n";
		String wed = "\n--> WEDNESDAY:\n";
		String thurs = "\n--> THURSDAY:\n";
		String fri = "\n--> FRIDAY:\n";
		String sat = "\n--> SATURDAY:\n";
		
		for (Room r : map.keySet()) {
			for (Schedule sched : map.get(r))  {
				if (sched.getMonday())
					mon += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
							+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
				if (sched.getTuesday())
					tues += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
							+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
				if (sched.getWednesday())
					wed += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
							+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
				if (sched.getThursday())
					thurs += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
							+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
				if (sched.getFriday())
					fri += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
							+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
				if (sched.getSaturday())
					sat += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
							+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
			}
		}
		
		System.out.println(mon + tues + wed + thurs + fri + sat);
	}
	
	/**
	 * <b>requires:</b> <i>schedule</i> not be null <p>
	 * <b>effects:</b> prints all the schedules in the provided list in alphabetical and numerical room order
	 * @param schedule a List of type <i>Schedule</i> whose schedules are to be printed
	 * @return <i>void</i>
	 */
	public void printRoomSchedule(List<Schedule> schedule) {
		String mon = "\n--> MONDAY:\n";
		String tues = "\n--> TUESDAY:\n";
		String wed = "\n--> WEDNESDAY:\n";
		String thurs = "\n--> THURSDAY:\n";
		String fri = "\n--> FRIDAY:\n";
		String sat = "\n--> SATURDAY:\n";
		
		for (Schedule sched : schedule) {
			if (sched.getMonday())
				mon += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
			if (sched.getTuesday())
				tues += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
			if (sched.getWednesday())
				wed += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
			if (sched.getThursday())
				thurs += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
			if (sched.getFriday())
				fri += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
			if (sched.getSaturday())
				sat += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
		}
		
		System.out.println(mon + tues + wed + thurs + fri + sat);
	}
	
	/**
	 * <b>requires:</b> <i>schedule</i> and <i>day</i> not be null <p>
	 * <b>effects:</b> prints all the schedule in the provided list in alphabetical and numerical room order at the specified day
	 * @param schedule a List of type <i>Schedule</i> whose schedules are to be printed
	 * @return <i>void</i>
	 */
	public void printRoomScheduleDay(List<Schedule> schedule, java.time.DayOfWeek day) {
		String res = day + ":\n";
		for (Schedule sched : schedule) {
			if (sched.getMonday() && day == java.time.DayOfWeek.MONDAY)
				res += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
			else if (sched.getTuesday() && day == java.time.DayOfWeek.TUESDAY)
				res += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
			else if (sched.getWednesday() && day == java.time.DayOfWeek.WEDNESDAY)
				res += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
			else if (sched.getThursday() && day == java.time.DayOfWeek.THURSDAY)
				res += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
			else if (sched.getFriday() && day == java.time.DayOfWeek.FRIDAY)
				res += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
			else if (sched.getSaturday() && day == java.time.DayOfWeek.SATURDAY)
				res += sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor() + ", "
						+ sched.getFromTime() + "->" + sched.getToTime()+"\n";
		}
		System.out.println(res);
	}
	
	/**
	 * <b>requires:</b> <i>sched</i> not be null <p>
	 * <b>effects:</b> prints the course, instructor, and times of the given <i>Schedule</i>
	 * @param sched a <i>Schedule</i> whose information is to be printed
	 * @return <i>void</i>
	 */
	public void printThere(Schedule sched) {
		System.out.println(sched.getCourse() + ", " + sched.getInstructor()
			+ ", " + sched.getFromTime() + "->" + sched.getToTime());
	}
	
	/**
	 * <b>requires:</b> <i>sched</i> not be null <p>
	 * <b>effects:</b> prints the room, course, instructor, and times of the given <i>Schedule</i>
	 * @param sched a <i>Schedule</i> whose information is to be printed
	 * @return <i>void</i>
	 */
	public void printProfNow(Schedule sched) {
		System.out.println(sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor()
			+ ", " + sched.getFromTime() + "->" + sched.getToTime());
	}
	
	/**
	 * <b>requires:</b> <i>schedule</i> not be null <p>
	 * <b>effects:</b> prints all the schedules in the provided list
	 * @param schedule a List of type <i>Schedule</i> whose shcedules are to be printed
	 * @return <i>void</i>
	 */
	public void printProfWillBe(List<Schedule> schedule) {
		// prints the day of calling
		System.out.println(Instant.now().atZone(ZoneId.systemDefault()).getDayOfWeek() + "\n");
		for (Schedule sched : schedule)
			System.out.println(sched.getRoom() + ", " + sched.getCourse() + ", " + sched.getInstructor()
				+ ", " + sched.getFromTime() + "->" + sched.getToTime());
	}

	
}
