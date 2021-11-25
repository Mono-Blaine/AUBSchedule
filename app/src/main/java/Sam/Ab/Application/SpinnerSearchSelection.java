package Sam.Ab.Application;

import android.view.View;
import android.widget.AdapterView;

public class SpinnerSearchSelection implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getItemAtPosition(position).toString()) {
            case "By instructor":
                MainActivity.byRoom = false;
                MainActivity.byInstructor = true;
                MainActivity.byCourse = false;
                MainActivity.byThereLast = false;
                MainActivity.byThereNow = false;
                MainActivity.byInstructorNow = false;
                break;

            case "By course":
                MainActivity.byRoom = false;
                MainActivity.byInstructor = false;
                MainActivity.byCourse = true;
                MainActivity.byThereLast = false;
                MainActivity.byThereNow = false;
                MainActivity.byInstructorNow = false;
                break;

            case "Who was there last":
                MainActivity.byRoom = false;
                MainActivity.byInstructor = false;
                MainActivity.byCourse = false;
                MainActivity.byThereLast = true;
                MainActivity.byThereNow = false;
                MainActivity.byInstructorNow = false;
                break;

            case "Who is there now":
                MainActivity.byRoom = false;
                MainActivity.byInstructor = false;
                MainActivity.byCourse = false;
                MainActivity.byThereLast = false;
                MainActivity.byThereNow = true;
                MainActivity.byInstructorNow = false;
                break;

            case "Where is instructor now":
                MainActivity.byRoom = false;
                MainActivity.byInstructor = false;
                MainActivity.byCourse = false;
                MainActivity.byThereLast = false;
                MainActivity.byThereNow = false;
                MainActivity.byInstructorNow = true;
                break;

            default:
                MainActivity.byRoom = true;
                MainActivity.byInstructor = false;
                MainActivity.byThereLast = false;
                MainActivity.byThereNow = false;
                MainActivity.byInstructorNow = false;
                MainActivity.byCourse = false;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        MainActivity.byRoom = true;
        MainActivity.byInstructor = false;
    }
}
