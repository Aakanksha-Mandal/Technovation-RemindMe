package com.example.remindme;

import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BillPaymentsPage extends AppCompatActivity {
private Button buttonhydro;
private Button buttonelectricity;
private Button buttonwater;
private Button buttoncreditcards;
private Button buttongoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_payments_page);

        buttonhydro = (Button) findViewById(R.id.Hydrobtn);
        buttonhydro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BillPaymentsPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttonelectricity = (Button) findViewById(R.id.Electricitybtn);
        buttonelectricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BillPaymentsPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttonwater = (Button) findViewById(R.id.Waterbtn);
        buttonwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BillPaymentsPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttoncreditcards = (Button) findViewById(R.id.CreditCardsbtn);
        buttoncreditcards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BillPaymentsPage.this, SetRemindersPage.class);
                startActivity(intent);
            }

        });

        buttongoback = (Button) findViewById(R.id.GoBackbtn);
        buttongoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BillPaymentsPage.this, RemindersPage.class);
                startActivity(intent);
            }

        });
    }
}
