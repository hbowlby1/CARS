package com.example.projectcars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    //sets up the exit button
    Button btn_exit;
    Switch mSwitchNotifs;
    Switch mSwitchEmails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //sets up the notification channel
        //if the build version greater or equal to oreo (o = sdk version 26)
        //Create the assignment due channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Assignment Due",
                    "Assignment Reminder", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        //supposed to make button take us to the assignments screen. It's broken right now, coming back to it later.
        btn_exit = findViewById(R.id.bt_exit);
        btn_exit.setOnClickListener(v -> {
            Intent goToHome;
            goToHome = new Intent(Settings.this,
                    AssignmentsList.class);
            startActivity(goToHome);
        });

        //below is all of the code to make the switches work(turn off notifs or emails)

        mSwitchNotifs = (Switch) findViewById(R.id.sw_notif);
        mSwitchEmails = (Switch) findViewById(R.id.sw_email);
        //checks if the switch is being toggled for the notification switch
        mSwitchNotifs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if switch is checked
//                        keep notifications on
//                if switch is off
//                        turn off notifications

                if(isChecked == true){
                    //shows that it is on (on is set to 0 based on the toast length)
                    Toast.makeText(getBaseContext(), "On", Toast.LENGTH_SHORT).show();
                    //creates the notification below
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(
                            Settings.this, "Assignment Due");

                    builder.setContentTitle("Assignment");
                    builder.setContentText("Insert Assignment name here" + " is due on " +
                            "insert date of assignment here");
                    builder.setSmallIcon(R.drawable.ic_launcher_background);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat =
                            NotificationManagerCompat.from(Settings.this);
                    managerCompat.notify(1, builder.build());
                }else{
                    //checks that it is off and says off. It is set to 1
                    Toast.makeText(getBaseContext(), "Off", Toast.LENGTH_LONG).show();
                }
            }
        }); //end of notification switch

        //start of email switch
        mSwitchEmails.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if switch is checked
//                        keep emails on
//                if switch is off
//                        turn off emails

                if(isChecked == true){
                    //shows that it is on (on is set to 0)
                    Toast.makeText(getBaseContext(), "On", Toast.LENGTH_SHORT).show();
                }else{
                    //checks that it is off and says off. It is set to 1
                    Toast.makeText(getBaseContext(), "Off", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}