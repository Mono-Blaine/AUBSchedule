package Implementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CourSeera {
	
	public static String SEMESTER;
	public static List<Course> courses;
	
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


}
