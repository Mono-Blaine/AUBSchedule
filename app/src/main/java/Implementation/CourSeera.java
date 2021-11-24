package Implementation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CourSeera {
	
	public static String SEMESTER;
	
	// to be assigned a right-hand value upon callin CourSeeraFactory.createInstance() in Main
	public static List<Course> courses;
	
	/**
	 * Allows the comparison of Collections of type <i>Room</i> alphabetically and numerically
	 * @author Samer Abdul Baki
	 */
	public static class BuildingComparator implements Comparator<Room> {
		@Override
		public int compare(Room o1, Room o2) {
			try {
				return o1.getBuilding().compareTo(o2.getBuilding());
			}
			catch (Exception e) {
				return -1;
			}
		}
	}
	
	/**
	 * Allows the comparison of Collections of type <i>Schedule</i> according to their rooms: alphabetically and numerically
	 * @author Samer Abdul Baki
	 */
	public static class RoomComparator implements Comparator<Schedule> {
		@Override
		public int compare(Schedule o1, Schedule o2) {
			try {
				return o1.getRoom().compareTo(o2.getRoom());
			}
			catch (Exception e) {
				return -1;
			}
		}
	}
	
	/**
	 * Allows the comparison of Collections of type <i>Schedule</i> according to their courses: alphabetically and numerically
	 * @author Samer Abdul Baki
	 */
	public static class CourseComparator implements Comparator<Schedule> {
		@Override
		public int compare(Schedule o1, Schedule o2) {
			try {
				return o1.getCourse().compareTo(o2.getCourse());
			}
			catch (Exception e) {
				return -1;
			}
		}
	}
	
	TreeMap<Room, List<Schedule>> resultMap = new TreeMap<>(new BuildingComparator());
	
	/**
	 * <b>requires:</b> the list of courses not be <b>null</b> <p>
	 * <b>effects:</b> a TreeMap of key <i>Room</i> and value List of <i>Schedule</i>s for every room in alphabetical and numerical order
	 * @return TreeMap of key <i>Room</i>, value List of <i>Schedules</i>
	 */
	public TreeMap<Room, List<Schedule>> roomSchedule() {
		Room tempRoom;
		Schedule tempSched;
		
		for (Course c : courses) {
			tempRoom = new Room(c.getBldg(), c.getRoom());
			tempSched = new Schedule(c.getBldg() + " " + c.getRoom(), c.getBegin_time(), c.getEnd_time(), c.getFirstName() + " "
					+c.getLastName(), c.getSubject() + " " + c.getCourse_num(), c.getMonday(), c.getTuesday(), c.getWednesday(),
					c.getThursday(), c.getFriday(), c.getSaturday());
			
			if (resultMap.containsKey(tempRoom))
				resultMap.get(tempRoom).add(tempSched);
			
			else
				resultMap.put(tempRoom, new ArrayList<>(Collections.singletonList(tempSched)));
		}
		
		// in case no schedule was added to the list in the part above, and empty schedule (N/A) is added
		if (resultMap.keySet().size() == 0)
			resultMap.put(new Room("N/A", "N/A"), new ArrayList<>(Collections.singletonList(new Schedule())));
		
		for (Room r : resultMap.keySet()) {
			resultMap.get(r).sort(new RoomComparator());
		}
		
		return resultMap;
	}
	
// -------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <b>requires:</b> the list of courses and <i>room</i> not be <b>null</b> <p>
	 * <b>effects:</b> a List of <i>Schedule</i>s for the given room
	 * @param room a <i>Room</i> whose schedule is to be returned
	 * @return List of <i>Schedule</i>
	 */
	public List<Schedule> roomSchedule(Room room) {
		List<Schedule> result = new ArrayList<>();
		
		List<Course> s = courses.stream().filter((c) -> c.getSemester().compareTo(SEMESTER) == 0
				&& c.getBldg().toLowerCase().compareTo(room.getBuilding().toLowerCase()) == 0
				&& c.getRoom().compareTo(room.getRoomNumber()) == 0).collect(Collectors.toList());
		
		for (Course c : s)
			result.add(new Schedule(c.getBldg() + " " + c.getRoom(), c.getBegin_time(), c.getEnd_time(), c.getFirstName() + " "
					+c.getLastName(), c.getSubject() + " " + c.getCourse_num(), c.getMonday(), c.getTuesday(), c.getWednesday(),
					c.getThursday(), c.getFriday(), c.getSaturday()));
		
		// in case no schedule was added to the list in the part above, and empty schedule (N/A) is added
		if (result.size() == 0)
			result.add(new Schedule());
		
		result.sort(new CourseComparator());
		
		return result;
	}

// -------------------------------------------------------------------------------------------------------------------------	
	
	/**
	 * <b>requires:</b> the list of courses, <i>room</i>, and the <i>date</i> not be <b>null</b> <p>
	 * <b>effects:</b> a List of <i>Schedule</i>s for the given room at the day of the given date
	 * @param room a <i>Room</i> whose schedule is to be returned
	 * @param date a <i>LocalDate</i> which will specify the day of the returned schedule
	 * @return List of <i>Schedule</i>
	 */
	public List<Schedule> roomSchedule(Room room, LocalDate date) {
		java.time.DayOfWeek day = date.getDayOfWeek();
		
		return roomSchedule(room, day);
	}

// -------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <b>requires:</b> the list of courses, <i>room</i>, and the <i>day</i> not be <b>null</b> <p>
	 * <b>effects:</b> a List of <i>Schedule</i>s for the given room at the specified day
	 * @param room a <i>Room</i> whose schedule is to be returned
	 * @param day a <i>java.time,DayOfWeek</i> which will specify the day of the returned schedule
	 * @return List of <i>Schedule</i>
	 */
	public List<Schedule> roomSchedule(Room room, java.time.DayOfWeek day) {
		List<Schedule> result = new ArrayList<>();
		Schedule temp;
		
		List<Course> s = courses.stream().filter((c) -> c.getSemester().compareTo(SEMESTER) == 0
				&& c.getBldg().toLowerCase().compareTo(room.getBuilding().toLowerCase()) == 0
				&& c.getRoom().compareTo(room.getRoomNumber()) == 0).collect(Collectors.toList());
		
		for (Course c : s) {
				temp = new Schedule(c.getBldg() + " " + c.getRoom(), c.getBegin_time(), c.getEnd_time(), c.getFirstName() + " "
						+c.getLastName(), c.getSubject() + " " + c.getCourse_num(), c.getMonday(), c.getTuesday(), c.getWednesday(),
						c.getThursday(), c.getFriday(), c.getSaturday());
				if (c.getMonday() && day == java.time.DayOfWeek.MONDAY)
					result.add(temp);
				else if (c.getTuesday() && day == java.time.DayOfWeek.TUESDAY)
					result.add(temp);
				else if (c.getWednesday() && day == java.time.DayOfWeek.WEDNESDAY)
					result.add(temp);
				else if (c.getThursday() && day == java.time.DayOfWeek.THURSDAY)
					result.add(temp);
				else if (c.getFriday() && day == java.time.DayOfWeek.FRIDAY)
					result.add(temp);
				else if (c.getSaturday() && day == java.time.DayOfWeek.SATURDAY)
					result.add(temp);
		}
		
		// in case no schedule was added to the list in the part above, and empty schedule (N/A) is added
		if (result.size() == 0)
			result.add(new Schedule());
		
		result.sort(new CourseComparator());
		
		return result;
	}

// -------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <b>requires:</b> the list of courses and <i>room</i> not be <b>null</b> <p>
	 * <b>effects:</b> a <i>Schedule</i> for the last time the given room was used; if none, empty values (N/A) are returned
	 * @param room a <i>Room</i> whose last time of use is to be returned
	 * @return <i>Schedule</i>
	 */
	public Schedule whoWasThereLast(Room room) {
		Course closest = null;
		LocalTime now = LocalTime.now();
		LocalTime max = LocalTime.of(0, 0);
		
		List<Course> s = courses.stream().filter((c) -> c.getSemester().compareTo(SEMESTER) == 0
				&& c.getBldg().toLowerCase().compareTo(room.getBuilding().toLowerCase()) == 0
				&& c.getRoom().compareTo(room.getRoomNumber()) == 0).collect(Collectors.toList());
		
		for (Course c : s) {
			if (now.compareTo(c.getEnd_time()) > 0 && c.getEnd_time().compareTo(max) > 0) {
				closest = c;
				max = c.getEnd_time();
			}
		}
		
		// in case no schedule was returned in the part above, and empty schedule (N/A) is returned
		if (closest == null)
			return new Schedule();
		
		return new Schedule(closest.getBldg() + " " + closest.getRoom(), closest.getBegin_time(), closest.getEnd_time(),
				closest.getFirstName() + " " + closest.getLastName(), closest.getSubject() + " " + closest.getCourse_num(),
				closest.getMonday(), closest.getTuesday(), closest.getWednesday(), closest.getThursday(),
				closest.getFriday(), closest.getSaturday());
	}

// -------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <b>requires:</b> the list of courses and <i>room</i> not be <b>null</b> <p>
	 * <b>effects:</b> a <i>Schedule</i> for room currently in use; if none, empty values (N/A) are returned
	 * @param room a <i>Room</i> whose current use  is to be checked
	 * @return <i>Schedule</i>
	 */
	public Schedule whoIsThereNow(Room room) {
		LocalTime now = LocalTime.now();
		
		List<Course> s = courses.stream().filter((c) -> c.getSemester().compareTo(SEMESTER) == 0
				&& c.getBldg().toLowerCase().compareTo(room.getBuilding().toLowerCase()) == 0
				&& c.getRoom().compareTo(room.getRoomNumber()) == 0
				&& now.compareTo(c.getEnd_time()) <= 0
				&& now.compareTo(c.getBegin_time()) >= 0).collect(Collectors.toList());
		
		if (s.size() != 0)
			return new Schedule(s.get(0).getBldg() + " " + s.get(0).getRoom(), s.get(0).getBegin_time(), s.get(0).getEnd_time(),
					s.get(0).getFirstName() + " " + s.get(0).getLastName(), s.get(0).getSubject() + " " + s.get(0).getCourse_num(),
					s.get(0).getMonday(), s.get(0).getTuesday(), s.get(0).getWednesday(), s.get(0).getThursday(),
					s.get(0).getFriday(), s.get(0).getSaturday());
		
		// in case no schedule was returned in the part above, and empty schedule (N/A) is returned
		return new Schedule();
	}

// -------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <b>requires:</b> the list of courses and <i>instructor</i> not be <b>null</b> <p>
	 * <b>effects:</b> a List of <i>Schedule</i> for rooms the instructor teaches in every week; if none, empty values (N/A) are returned
	 * @param instructor an <i>Instructor</i> whose schedules are to be returned
	 * @return List of <i>Schedule</i>
	 */
	public List<Schedule> profSchedule(Instructor instructor) {
		List<Schedule> result = new ArrayList<>();
		
		List<Course> s = courses.stream().filter((c) -> c.getSemester().compareTo(SEMESTER) == 0
				&& c.getFirstName().toLowerCase().compareTo(instructor.getFirstName().toLowerCase()) == 0
				&& c.getLastName().toLowerCase().compareTo(instructor.getLastName().toLowerCase()) == 0).collect(Collectors.toList());
		
		for (Course c : s)
			result.add(new Schedule(c.getBldg() + " " + c.getRoom(), c.getBegin_time(), c.getEnd_time(), c.getFirstName() + " "
					+c.getLastName(), c.getSubject() + " " + c.getCourse_num(), c.getMonday(), c.getTuesday(), c.getWednesday(),
					c.getThursday(), c.getFriday(), c.getSaturday()));
		
		// in case no schedule was added to the list in the part above, and empty schedule (N/A) is added
		if(result.size() == 0)
			result.add(new Schedule());
		
		result.sort(new RoomComparator());
		
		return result;
	}

// -------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <b>requires:</b> the list of courses and <i>instructor</i> not be <b>null</b> <p>
	 * <b>effects:</b> a <i>Schedule</i> for the room the instructor is currently in; if none, empty values (N/A) are returned
	 * @param instructor an <i>Instructor</i> whose current schedule is to be returned
	 * @return <i>Schedule</i>
	 */
	public Schedule whereIsProf(Instructor instructor) {
		LocalTime now = LocalTime.now();
		
		List<Course> s = courses.stream().filter((c) -> c.getSemester().compareTo(SEMESTER) == 0
				&& c.getFirstName().toLowerCase().compareTo(instructor.getFirstName().toLowerCase()) == 0
				&& c.getLastName().toLowerCase().compareTo(instructor.getLastName().toLowerCase()) == 0
				&& now.compareTo(c.getEnd_time()) <= 0 && now.compareTo(c.getBegin_time()) >= 0).collect(Collectors.toList());
		
		if (s.size() != 0)
			return new Schedule(s.get(0).getBldg() + " " + s.get(0).getRoom(), s.get(0).getBegin_time(), s.get(0).getEnd_time(),
					s.get(0).getFirstName() + " " +s.get(0).getLastName(), s.get(0).getSubject() + " " + s.get(0).getCourse_num(),
					s.get(0).getMonday(), s.get(0).getTuesday(), s.get(0).getWednesday(), s.get(0).getThursday(),
					s.get(0).getFriday(), s.get(0).getSaturday());
		
		// in case no schedule was returned in the part above, and empty schedule (N/A) is returned
		return new Schedule();
	}

// -------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <b>requires:</b> the list of courses and <i>instructor</i> not be <b>null</b> <p>
	 * <b>effects:</b> a <i>Schedule</i> for the rooms the instructor will visit at the day of calling;
	 * if none, empty values (N/A) are returned
	 * @param instructor an <i>Instructor</i> whose schedule at the day of calling is to be returned
	 * @return List of <i>Schedule</i>
	 */
	public List<Schedule> whereWillProfBe(Instructor instructor) {
		List<Schedule> result = new ArrayList<>();
		java.time.DayOfWeek day = LocalDate.now().getDayOfWeek();
		Schedule temp;
		
		List<Course> s = courses.stream().filter((c) -> c.getSemester().compareTo(SEMESTER) == 0
				&& c.getFirstName().toLowerCase().compareTo(instructor.getFirstName().toLowerCase()) == 0
				&& c.getLastName().toLowerCase().compareTo(instructor.getLastName().toLowerCase()) == 0).collect(Collectors.toList());
		
		for (Course c : s) {
				temp = new Schedule(c.getBldg() + " " + c.getRoom(), c.getBegin_time(), c.getEnd_time(), c.getFirstName() + " "
						+c.getLastName(), c.getSubject() + " " + c.getCourse_num(), c.getMonday(), c.getTuesday(), c.getWednesday(),
						c.getThursday(), c.getFriday(), c.getSaturday());
				if (c.getMonday() && day == java.time.DayOfWeek.MONDAY)
					result.add(temp);
				else if (c.getTuesday() && day == java.time.DayOfWeek.TUESDAY)
					result.add(temp);
				else if (c.getWednesday() && day == java.time.DayOfWeek.WEDNESDAY)
					result.add(temp);
				else if (c.getThursday() && day == java.time.DayOfWeek.THURSDAY)
					result.add(temp);
				else if (c.getFriday() && day == java.time.DayOfWeek.FRIDAY)
					result.add(temp);
				else if (c.getSaturday() && day == java.time.DayOfWeek.SATURDAY)
					result.add(temp);
		}
		
		// in case no schedule was added to the list in the part above, and empty schedule (N/A) is added
		if (result.size() == 0)
			result.add(new Schedule());
		
		result.sort(new RoomComparator());
		
		return result;
	}
}
