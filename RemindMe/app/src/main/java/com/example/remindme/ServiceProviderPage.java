package com.example.remindme;

import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceProviderPage extends AppCompatActivity {
    private Button buttonmobile;
    private Button buttoninternet;
    private Button buttonsettopbox;
    private Button buttonlandline;
    private Button buttonother;
    private Button buttongoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_page);

        buttonmobile = (Button) findViewById(R.id.Mobilebtn);
        buttonmobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceProviderPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttoninternet = (Button) findViewById(R.id.Internetbtn);
        buttoninternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceProviderPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonsettopbox = (Button) findViewById(R.id.SettopBoxbt);
        buttonsettopbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceProviderPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonlandline = (Button) findViewById(R.id.Landlinebtn);
        buttonlandline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceProviderPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttonother = (Button) findViewById(R.id.Otherbtn);
        buttonother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceProviderPage.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        buttongoback = (Button) findViewById(R.id.GoBackbtn);
        buttongoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceProviderPage.this, RemindersPage.class);
                startActivity(intent);
            }
        });























    }
}
