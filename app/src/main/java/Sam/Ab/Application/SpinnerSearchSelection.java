package Sam.Ab.Application;

import android.view.View;
import android.widget.AdapterView;

public class SpinnerSearchSelection implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position).toString().compareTo("By room") == 0) {
            MainActivity.byRoom = true;
            MainActivity.byInstructor = false;
        }
        else if (parent.getItemAtPosition(position).toString().compareTo("By instructor") == 0) {
            MainActivity.byRoom = false;
            MainActivity.byInstructor = true;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        MainActivity.byRoom = true;
        MainActivity.byInstructor = false;
    }
}
