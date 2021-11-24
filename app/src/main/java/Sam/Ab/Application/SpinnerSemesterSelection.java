package Sam.Ab.Application;

import android.view.View;
import android.widget.AdapterView;

public class SpinnerSemesterSelection implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position).toString().compareTo("Fall") == 0)
            MainActivity.semester = "Fall";

        else if (parent.getItemAtPosition(position).toString().compareTo("Spring") == 0)
            MainActivity.semester = "Spring";
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        MainActivity.semester = "Fall";
    }
}
