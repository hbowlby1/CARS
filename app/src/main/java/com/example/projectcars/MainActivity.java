package com.example.projectcars;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView mDisplayDate;
    //EditText name;
    //Button addAssignment;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*** --- Seems like these lines should be inside onClick function ---
        EditText name = findViewById(R.id.et_name);
        String assignment_name = name.getText().toString();
         ***/



        // sets up the display date in the main activity
        mDisplayDate = (TextView) findViewById(R.id.getDate);

        // gets the current date in the format yyyy/mm/dd
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                //using day of month since there are different amount of days in a month
                int day = cal.get(Calendar.DAY_OF_MONTH);

                //creates the date picker with a theme
                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                //sets the background color to be transparent
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //shows the datepicker
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                //datepicker only goes from 0-11 (0 = january and 11 = december) Adding 1 sets it
                // like normal 1-12
                month = month + 1;
                //sets the date to the text view (should reset each time accessing the activity
                String date = month + "/" + dayOfMonth + "/" + year;
                mDisplayDate.setText(date);
                //shows the date in log cat (for debugging purposes)
                Log.d(TAG, "onDateSet: date; " + month + "/" + dayOfMonth + "/" + year);
            }
        };



        Button addAssignment = findViewById(R.id.btn_add);
        addAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //And here they are
                EditText name = findViewById(R.id.et_name);
                String assignment_name = name.getText().toString();
                String date = mDisplayDate.getText().toString();

                Intent intentListAssignments = new Intent(MainActivity.this, AssignmentsList.class);
                intentListAssignments.putExtra("name", assignment_name);
                intentListAssignments.putExtra("date", date);
                startActivity(intentListAssignments);

            }
        });
    }
}