package com.example.remindme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button buttonsignin;
    private Button buttoncall911;
    private Button buttonphonecall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.loginsound);
        final SharedPreferences sharedpreferences = getSharedPreferences("localDB", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        // Set OnclickListener;
//        findViewById(R.id.SignInbtn).setOnClickListener((View.OnClickListener) this);

        buttonsignin = findViewById(R.id.SignInbtn);
        buttonsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
//                buttonsignin.playSoundEffect(SoundEffectConstants.CLICK);
                if (sharedpreferences.getString("loginStatus", null) == "false" || sharedpreferences.getString("loginStatus", null) == null) {
                    Intent intent = new Intent(MainActivity.this, CreateYourProfilePage.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, HomePage.class);
                    startActivity(intent);
                }
            }
        });
//

        buttoncall911 = findViewById(R.id.Emergencybtn);
        buttoncall911.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        buttonphonecall = findViewById(R.id.PhoneCallbtn);
        buttonphonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}




