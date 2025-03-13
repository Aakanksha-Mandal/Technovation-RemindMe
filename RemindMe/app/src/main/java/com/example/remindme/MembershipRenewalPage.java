package com.example.remindme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MembershipRenewalPage extends AppCompatActivity {
private Button buttoncostco;
private Button buttoncaa;
private Button buttonclubs;
private Button buttonothermemberships;
private Button buttongoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership_renewal_page);

        buttoncostco = (Button) findViewById(R.id.Costcobtn);
        buttoncostco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MembershipRenewalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttoncaa = (Button) findViewById(R.id.Caabtn);
        buttoncaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MembershipRenewalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonclubs = (Button) findViewById(R.id.Clubsbtn);
        buttonclubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MembershipRenewalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonothermemberships = (Button) findViewById(R.id.OtherMembershipsbtn);
        buttonothermemberships.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MembershipRenewalPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttongoback = (Button) findViewById(R.id.GoBackbtn);
        buttongoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MembershipRenewalPage.this, RemindersPage.class);
                startActivity(intent);
            }
        });
    }
}
