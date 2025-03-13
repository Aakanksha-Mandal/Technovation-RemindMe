package com.example.remindme;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class CreateYourProfilePage extends AppCompatActivity {
    private Button buttonlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_your_profile_page);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.loginsound);

        buttonlogin = (Button) findViewById(R.id.Loginbtn);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                EditText user = (EditText) findViewById(R.id.Usernametxt2);
                EditText pass = (EditText) findViewById(R.id.Passwordtxt2);
                if(!(user.getText().toString().isEmpty()) && !(pass.getText().toString().isEmpty())) {
                    SharedPreferences sharedpreferences = getSharedPreferences("localDB", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("loginStatus", "true");
                    editor.commit();
                    Intent intent = new Intent(CreateYourProfilePage.this, HomePage.class);
                    startActivity(intent);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CreateYourProfilePage.this);
                    builder.setTitle("Username and Password cannot be empty!!");
                    builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }

        });
    }
}
