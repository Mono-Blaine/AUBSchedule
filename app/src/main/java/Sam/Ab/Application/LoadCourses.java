package Sam.Ab.Application;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import Implementation.CsvToDb;

public class LoadCourses {
    CsvToDb toDb;

    public void buttonLoadCourses(View view, Context context) {
        toDb = new CsvToDb(context);

        for (int i = 0; i < 1; i++) {
            String csvFile = (char) (i + 65) + "csv.txt";
            toDb.csvToDb(MainActivity.courses, csvFile);
        }

        Toast.makeText(context, "Courses updated", Toast.LENGTH_LONG).show();
    }
}
