package com.example.remindme;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RemindersPage extends AppCompatActivity {
    private Button buttonbillpayments;
    private Button buttonmedical;
    private Button buttoninsurancerenewal;
    private Button buttonserviceproviders;
    private Button buttonmembershiprenewals;
    private Button buttonpersonalreminders;
    private Button buttonotherreminders;
    private Button buttonworkoffice;
    private Button buttonschoolactivities;
    private Button buttongoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders_page);

        buttonbillpayments = (Button) findViewById(R.id.BillPaymentsbtn);
        buttonbillpayments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindersPage.this, BillPaymentsPage.class);
                startActivity(intent);
            }

        });

        buttonmedical = (Button) findViewById(R.id.Medicalbtn);
        buttonmedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindersPage.this, MedicalPage.class);
                startActivity(intent);
            }

        });

        buttoninsurancerenewal = (Button) findViewById(R.id.InsuranceRenewalbtn);
        buttoninsurancerenewal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindersPage.this, InsuranceRenewalPage.class);
                startActivity(intent);
            }

        });

        buttonserviceproviders = (Button) findViewById(R.id.ServiceProvidersbtn);
        buttonserviceproviders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindersPage.this, ServiceProviderPage.class);
                startActivity(intent);
            }

        });

        buttonmembershiprenewals = (Button) findViewById(R.id.MembershipRenewalbtn);
        buttonmembershiprenewals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindersPage.this, MembershipRenewalPage.class);
                startActivity(intent);
            }

        });

        buttonpersonalreminders = (Button) findViewById(R.id.PersonalRemindersbtn);
        buttonpersonalreminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindersPage.this, PersonalRemindersPage.class);
                startActivity(intent);
            }

        });

        buttonotherreminders = (Button) findViewById(R.id.OtherRemindersbtn);
        buttonotherreminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttonworkoffice = (Button) findViewById(R.id.WorkOfficebtn);
        buttonworkoffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttonschoolactivities = (Button) findViewById(R.id.SchoolActivitesbtn);
        buttonschoolactivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindersPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttongoback = (Button) findViewById(R.id.GoBackbtn);
        buttongoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemindersPage.this, HomePage.class);
                startActivity(intent);
            }

        });

    }
}
