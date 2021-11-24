package Sam.Ab.Application;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Implementation.CourSeera;
import Implementation.CourSeeraFactory;
import Implementation.Instructor;
import Implementation.Room;
import Implementation.Schedule;

public class CourseSearch {
    Context context;
    String semester;

    public CourseSearch(Context context, String semester) {
        this.context = context;
        this.semester = semester;
    }

    private String parseLastName(String[] command) {
        StringBuilder lastNameBuilder = new StringBuilder();
        for (int i = 1; i < command.length; i++)
            lastNameBuilder.append(command[i]).append(" ");
        return lastNameBuilder.toString().trim();
    }

    public List<Schedule> search(View v, String input) {
        if (MainActivity.courses.size() == 0) {
            Toast.makeText(context, "No courses loaded", Toast.LENGTH_LONG).show();
            return new ArrayList<>();
        }

        String[] command = input.split(" ");
        if (command.length < 2) {
            Toast.makeText(context, "Invalid input", Toast.LENGTH_LONG).show();
            return new ArrayList<>();
        }
        CourSeera seer = new CourSeeraFactory().createInstance(MainActivity.courses, MainActivity.semester);

        if (MainActivity.byRoom)
            return seer.roomSchedule(new Room(command[0], command[1]));

        else if (MainActivity.byInstructor) {
            String lastName = parseLastName(command);
            return seer.profSchedule(new Instructor(command[0], lastName));
        }

        Toast.makeText(context, "Invalid input", Toast.LENGTH_LONG).show();
        return new ArrayList<>();
    }
}
