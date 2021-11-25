package Sam.Ab.Application;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import Implementation.CsvToDb;

public class LoadCourses {
    Context context;
    CsvToDb toDb;

    public LoadCourses(Context context) {
        this.context = context;
    }

    public void buttonLoadCourses(View view) {
        if (MainActivity.coursesLoaded) {
            Toast.makeText(context, MainActivity.courses.size() + " courses loaded", Toast.LENGTH_LONG).show();
            return;
        }
        
        toDb = new CsvToDb(context);

        for (int i = 0; i < 26; i++) {
            String csvFile = (char) (i + 65) + "csv.txt";
            toDb.csvToDb(MainActivity.courses, csvFile);
        }

        MainActivity.coursesLoaded = true;

        Toast.makeText(context, MainActivity.courses.size() + " courses loaded", Toast.LENGTH_LONG).show();
    }
}
