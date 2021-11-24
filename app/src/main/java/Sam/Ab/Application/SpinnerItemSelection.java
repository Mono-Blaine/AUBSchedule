package Sam.Ab.Application;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class SpinnerItemSelection implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position).toString().compareTo("By room") == 0) {
            MainActivity.byRoom = true;
            MainActivity.byInstructor = false;
            //Toast.makeText(parent.getContext(), "by room", Toast.LENGTH_SHORT).show();
        }
        else if (parent.getItemAtPosition(position).toString().compareTo("By instructor") == 0) {
            MainActivity.byRoom = false;
            MainActivity.byInstructor = true;
            //Toast.makeText(parent.getContext(), "by instructor", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
