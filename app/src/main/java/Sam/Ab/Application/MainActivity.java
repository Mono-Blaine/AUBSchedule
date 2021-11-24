package Sam.Ab.Application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Implementation.Course;

public class MainActivity extends AppCompatActivity {
    public static boolean byRoom = true;
    public static boolean byInstructor = false;
    public static ArrayList<Course> courses = new ArrayList<>();
    Spinner spinner;
    EditText editText;
    TextView textView;
    Button updateButton;
    Button loadButton;
    public static String sssss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new SpinnerItemSelection());

        textView = (TextView) findViewById(R.id.textView);
        updateButton = findViewById(R.id.updateFilesButton);
        updateButton.setOnClickListener(v -> new UpdateFiles().buttonUpdateFiles(v, getApplicationContext()));

        loadButton = findViewById(R.id.loadCoursesButton);
        loadButton.setOnClickListener(v -> {
            new LoadCourses().buttonLoadCourses(v, getApplicationContext());
            textView.setText(sssss);
            System.out.println("Number of courses: " + courses.size());
            Toast.makeText(getApplicationContext(), "Number of courses: " + courses.size(), Toast.LENGTH_LONG).show();
        });

        editText = findViewById(R.id.editText);


    }
}