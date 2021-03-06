package Implementation;

import java.util.List;

import Sam.Ab.Application.MainActivity;

public class Printer {

	/**
	 * <b>requires:</b> <i>schedule</i> not be null <p>
	 * <b>effects:</b> prints all the schedules in the provided list in alphabetical and numerical room order
	 * @param schedule a List of type <i>Schedule</i> whose schedules are to be printed
	 */
	public String printSchedule(List<Schedule> schedule) {
		StringBuilder outputBuilder = new StringBuilder();

		if (MainActivity.byRoom || MainActivity.byThereLast || MainActivity.byThereNow) {
			for (Schedule sched : schedule)
				outputBuilder.append(sched.getCourse()).append(", ").append(sched.getInstructor())
						.append(", ").append(sched.getFromTime()).append(" -> ")
						.append(sched.getToTime()).append(", ").append(sched.getDays()).append("\n");
		}

		else if (MainActivity.byInstructor || MainActivity.byInstructorNow) {
			for (Schedule sched : schedule)
				outputBuilder.append(sched.getRoom()).append(", ").append(sched.getCourse()).append(", ")
						.append(", ").append(sched.getFromTime()).append(" -> ")
						.append(sched.getToTime()).append(", ").append(sched.getDays()).append("\n");
		}

		else if (MainActivity.byCourse) {
			for (Schedule sched : schedule)
				outputBuilder.append(sched.getRoom()).append(", ").append(sched.getSubject()).append(", ")
						.append(sched.getInstructor()).append(", ").append(", ").append(sched.getFromTime())
						.append(" -> ").append(sched.getToTime()).append(", ").append(sched.getDays()).append("\n");
		}

		return outputBuilder.toString();
	}
}
