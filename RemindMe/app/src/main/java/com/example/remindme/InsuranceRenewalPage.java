package com.example.remindme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InsuranceRenewalPage extends AppCompatActivity {
    private Button buttonhome;
    private Button buttonauto;
    private Button buttonlife;
    private Button buttonaccident;
    private Button buttonpersonal;
    private Button buttonother;
    private Button buttongoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_renewal_page);

        buttonhome = (Button) findViewById(R.id.Homebtn);
        buttonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsuranceRenewalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttonauto = (Button) findViewById(R.id.Autobtn);
        buttonauto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsuranceRenewalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttonlife = (Button) findViewById(R.id.Lifebtn);
        buttonlife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsuranceRenewalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttonaccident = (Button) findViewById(R.id.Accidentbtn);
        buttonaccident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsuranceRenewalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttonpersonal = (Button) findViewById(R.id.Personalbtn);
        buttonpersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsuranceRenewalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttonother = (Button) findViewById(R.id.OtherInsurancebtn);
        buttonother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsuranceRenewalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttongoback = (Button) findViewById(R.id.GoBackbtn);
        buttongoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsuranceRenewalPage.this, RemindersPage.class);
                startActivity(intent);
            }

        });













    }
}
