package Sam.Ab.Application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Implementation.Course;
import Implementation.Printer;
import Implementation.Schedule;

public class MainActivity extends AppCompatActivity {
    public static boolean byRoom = true;
    public static boolean byInstructor = false;
    public static boolean byCourse = false;
    public static boolean byThereLast = false;
    public static boolean byThereNow = false;
    public static boolean byInstructorNow = false;
    public static String semester = "Fall";
    public static ArrayList<Course> courses = new ArrayList<>();
    Spinner  spinnerSearch;
    Spinner  spinnerSemester;
    EditText editText;
    TextView textView;
    Button   updateButton;
    Button   loadButton;
    Button   searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        textView = (TextView) findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        spinnerSearch = findViewById(R.id.spinnerSearchOptions);
        spinnerSearch.setOnItemSelectedListener(new SpinnerSearchSelection());

        spinnerSemester = findViewById(R.id.spinnerSemesterOptions);
        spinnerSemester.setOnItemSelectedListener(new SpinnerSemesterSelection());

        updateButton = findViewById(R.id.updateFilesButton);
        updateButton.setOnClickListener(v -> new UpdateFiles(getApplicationContext()).buttonUpdateFiles(v));

        loadButton = findViewById(R.id.loadCoursesButton);
        loadButton.setOnClickListener(v -> new LoadCourses(getApplicationContext()).buttonLoadCourses(v));

        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(v -> {
            List<Schedule> scheds = new CourseSearch(getApplicationContext(), semester).search(v, editText.getText().toString());
            textView.setText(new Printer().printSchedule(scheds));
        });
    }
}