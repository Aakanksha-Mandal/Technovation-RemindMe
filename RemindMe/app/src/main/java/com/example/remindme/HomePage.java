package com.example.remindme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage<publicvoid> extends AppCompatActivity {
    private Button buttonemergency;
    private Button buttonsetreminders;
    private Button buttonmyreminders;
    private Button buttonlogout;
    private Button buttonmessage;
    private Button buttoncamera;
    private Button buttonmaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.loginsound);

        buttonemergency = findViewById(R.id.EmergencyContatcNumbersbtn);
        buttonemergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, EmergencyContactNumbersPage.class);
                startActivity(intent);
            }
        });

        buttonsetreminders = findViewById(R.id.SetRemindersbtn);
        buttonsetreminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, RemindersPage.class);
                startActivity(intent);
            }
        });

        buttonmyreminders = findViewById(R.id.MyRemindersbtn);
        buttonmyreminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, MyReminders.class);
                startActivity(intent);
            }
        });

        buttonlogout = findViewById(R.id.LogOutbtn);
        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                SharedPreferences sharedpreferences = getSharedPreferences("localDB", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.remove("loginStatus");
                editor.commit();
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonmessage = findViewById(R.id.MessageEmailbtn);
        buttonmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Create the Intent */
                final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                /* Fill it with Data */
                emailIntent.setType("text/plain");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Type your text here");

                /* Send it off to the Activity-Chooser */
                startActivity(Intent.createChooser(emailIntent, "Complete Your Action Using:"));
            }
        });

        buttoncamera = findViewById(R.id.Camerabtn);
        buttoncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String timeStamp =
                        new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String imageFileName = "test" + timeStamp + "_";
                File image = null;
                try {
                    image = File.createTempFile(
                            imageFileName,
                            "test"
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String mCurrentPhotoPath = image.getAbsolutePath();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, image);
                startActivity(intent);
            }
        });

        buttonmaps = findViewById(R.id.GoogleMapsbtn);
        buttonmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}