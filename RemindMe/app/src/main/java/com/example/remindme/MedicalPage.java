package com.example.remindme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MedicalPage extends AppCompatActivity {
    private Button buttondoctorappointments;
    private Button buttonlabtestappointments;
    private Button buttonmedicinerefill;
    private Button buttondailymedicine;
    private Button buttongoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_page);

        buttondoctorappointments = (Button) findViewById(R.id.DoctorAppointmentsbtn);
        buttondoctorappointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonlabtestappointments = (Button) findViewById(R.id.LabTestAppointmentsbtn);
        buttonlabtestappointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonmedicinerefill = (Button) findViewById(R.id.MedicineRefillbtn);
        buttonmedicinerefill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttondailymedicine = (Button) findViewById(R.id.DailyMedicinebtn);
        buttondailymedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttongoback = (Button) findViewById(R.id.GoBackbtn);
        buttongoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalPage.this, RemindersPage.class);
                startActivity(intent);
            }
        });
    }
}