package com.example.remindme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonalRemindersPage extends AppCompatActivity {
    private Button buttonpassportrenewal;
    private Button buttonprcardrenewal;
    private Button buttonlicenserenewal;
    private Button buttonmedicalcardrenewal;
    private Button buttonimportantreminders;
    private Button buttonlegal;
    private Button buttonrefunds;
    private Button buttontravel;
    private Button buttonbirthday;
    private Button buttonanniversary;
    private Button buttonfestivalcelebration;
    private Button buttonotherappointments;
    private Button buttongoback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_reminders_page);

        buttonpassportrenewal = (Button) findViewById(R.id.Passportbtn);
        buttonpassportrenewal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonprcardrenewal = (Button) findViewById(R.id.PrCardbtn);
        buttonprcardrenewal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonlicenserenewal = (Button) findViewById(R.id.Licensebtn);
        buttonlicenserenewal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonmedicalcardrenewal = (Button) findViewById(R.id.MedicalCardbtn);
        buttonmedicalcardrenewal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonimportantreminders = (Button) findViewById(R.id.ImportantRemindersbtn);
        buttonimportantreminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonlegal = (Button) findViewById(R.id.Legalbtn);
        buttonlegal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonrefunds = (Button) findViewById(R.id.Refundsbtn);
        buttonrefunds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttontravel = (Button) findViewById(R.id.Travelbtn);
        buttontravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonbirthday = (Button) findViewById(R.id.Birthdaybtn);
        buttonbirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonanniversary = (Button) findViewById(R.id.Anniversarybtn);
        buttonanniversary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonfestivalcelebration = (Button) findViewById(R.id.FestivalCelebrationbtn);
        buttonfestivalcelebration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonotherappointments = (Button) findViewById(R.id.OtherAppointmentsbtn);
        buttonotherappointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttongoback = (Button) findViewById(R.id.GoBackbtn);
        buttongoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalRemindersPage.this, RemindersPage.class);
                startActivity(intent);
            }
        });
    }
}
