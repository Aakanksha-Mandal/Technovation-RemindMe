package com.example.remindme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EmergencyContactNumbersPage extends AppCompatActivity {
    private Button buttongoback;
    private Button buttonsave1;
    private Button buttoncall1;
    private Button buttonsave2;
    private Button buttoncall2;
    EditText ContactName1;
    EditText ContactNumber1;
    EditText ContactName2;
    EditText ContactNumber2;
    ImageView vs1;
    ImageView vs2;
    ImageView vs3;
    ImageView vs4;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    final int VOICE_RECOGNITION_REQUEST_CODE_1 = 1234;
    final int VOICE_RECOGNITION_REQUEST_CODE_2 = 2345;
    final int VOICE_RECOGNITION_REQUEST_CODE_3 = 3456;
    final int VOICE_RECOGNITION_REQUEST_CODE_4 = 4567;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contact_numbers_page);
        ContactName1 = (EditText) findViewById(R.id.Nametxt);
        ContactNumber1 = (EditText) findViewById(R.id.PhoneNumbertxt);
        ContactName2 = (EditText) findViewById(R.id.Nametxt2);
        ContactNumber2 = (EditText) findViewById(R.id.PhoneNumbertxt2);
        vs1 = (ImageView) findViewById(R.id.voicesearch1);
        vs2 = (ImageView) findViewById(R.id.voicesearch2);
        vs3 = (ImageView) findViewById(R.id.voicesearch3);
        vs4 = (ImageView) findViewById(R.id.voicesearch4);

        sharedpreferences = getSharedPreferences("localDB", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

        ContactName1.setText(sharedpreferences.getString("contactName1",""));
        ContactNumber1.setText(sharedpreferences.getString("contactNumber1",""));
        ContactName2.setText(sharedpreferences.getString("contactName2",""));
        ContactNumber2.setText(sharedpreferences.getString("contactNumber2",""));

//        vs1 = (ImageView) findViewById(R.id.GoBackbtn);
        vs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                        "Speech recognition demo");
                startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE_1);
            }

        });

        vs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                        "Speech recognition demo");
                startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE_2);
            }

        });

        vs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                        "Speech recognition demo");
                startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE_3);
            }

        });

        vs4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                        "Speech recognition demo");
                startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE_4);
            }

        });

        buttongoback = (Button) findViewById(R.id.GoBackbtn);
        buttongoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmergencyContactNumbersPage.this, HomePage.class);
                startActivity(intent);
            }

        });

        buttonsave1 = (Button) findViewById(R.id.Savebtn2);
        buttonsave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("contactName1");
                editor.remove("contactNumber1");
                editor.putString("contactName1", ContactName1.getText().toString());
                editor.putString("contactNumber1", ContactNumber1.getText().toString());
                editor.commit();
                Toast t = Toast.makeText(getApplicationContext(),"Contact-1 Saved!!",Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER,0,0);
                TextView tv = new TextView(EmergencyContactNumbersPage.this);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(22);
                tv.setBackgroundColor(Color.parseColor("#0071FF"));
                tv.setText("Contact-1 saved!!");
                t.setView(tv);
                t.show();
            }

        });

        buttoncall1 = (Button) findViewById(R.id.Callbtn2);
        buttoncall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + sharedpreferences.getString("contactNumber1","")));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        });

        buttonsave2 = (Button) findViewById(R.id.savebtn);
        buttonsave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.remove("contactName2");
                editor.remove("contactNumber2");
                editor.putString("contactName2", ContactName2.getText().toString());
                editor.putString("contactNumber2", ContactNumber2.getText().toString());
                editor.commit();
                Toast t = Toast.makeText(getApplicationContext(),"Contact-2 Saved!!",Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER,0,0);
                TextView tv = new TextView(EmergencyContactNumbersPage.this);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(22);
                tv.setBackgroundColor(Color.parseColor("#0071FF"));
                tv.setText("Contact-2 saved!!");
                t.setView(tv);
                t.show();
            }

        });

        buttoncall2 = (Button) findViewById(R.id.callbtn);
        buttoncall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = sharedpreferences.getString("contactNumber2","");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE_1 && resultCode == RESULT_OK) {
            List<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            ContactName1.setText(matches.get(0));
        }
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE_2 && resultCode == RESULT_OK) {
            List<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            ContactNumber1.setText(matches.get(0));
        }
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE_3 && resultCode == RESULT_OK) {
            List<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            ContactName2.setText(matches.get(0));
        }
        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE_4 && resultCode == RESULT_OK) {
            List<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            ContactNumber2.setText(matches.get(0));
        }
    }
}
