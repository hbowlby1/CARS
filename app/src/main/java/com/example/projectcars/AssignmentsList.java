package com.example.projectcars;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class AssignmentsList extends AppCompatActivity {

    Button btn_setting;
    Button btn_createAssignment;

    RecyclerView content;
    ArrayList<String> assignmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments_list);


        //Getting the input from Main
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        content = findViewById(R.id.rv_content);
        content.setLayoutManager(new LinearLayoutManager(this));
        assignmentList = new ArrayList<String>();

        assignmentList.add(name);

        AdapterData adapter = new AdapterData(assignmentList);
        content.setAdapter(adapter);



        //Setting the buttons
        btn_setting = findViewById(R.id.btn_setting);
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSetting = new Intent(AssignmentsList.this, Settings.class);
                AssignmentsList.this.startActivity(intentSetting);
            }
        });

        btn_createAssignment = findViewById(R.id.createAssignment);
        btn_createAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreateAssignment = new Intent(AssignmentsList.this, MainActivity.class);
                AssignmentsList.this.startActivity(intentCreateAssignment);
            }
        });
    }
}