package Implementation;

import java.util.List;

public class CourSeeraFactory {

	public CourSeera createInstance(List<Course> courses, String semester) {
		CourSeera.SEMESTER = semester;
		CourSeera.courses = courses;
		return new CourSeera();
	}

}
