package com.example.projectcars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    //sets up the exit button
    Button btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //supposed to make button take us to the assignments screen. It's broken right now, coming back to it later.
        btn_exit = findViewById(R.id.bt_exit);
        btn_exit.setOnClickListener(v -> {
            Intent goToHome;
            goToHome = new Intent(Settings.this,
                    Assignments.class);
            startActivity(goToHome);
        });

    }
}