package com.example.remindme;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class SetRemindersPage extends AppCompatActivity implements View.OnClickListener {
    private Button buttongoback;
    private Button buttonmyreminders;
    private int notificationId = 1;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    List<ReminderClass> reminderList;
    List<PendingIntent> alarmList;
    List<Integer> requestList;
    AlarmManager alarm;
    ImageView vs1;
    EditText task;
    final int VOICE_RECOGNITION_REQUEST_CODE = 1234;

    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminders_page);
        sharedpreferences = getSharedPreferences("localDB", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        reminderList = new ArrayList<>();
        alarmList = new ArrayList<>();
        requestList = new ArrayList<>();
        vs1 = (ImageView) findViewById(R.id.vs1);
        task = (EditText) findViewById(R.id.EditText);
//        gson = new Gson();
//        String json = sharedpreferences.getString("reminderList", "");
//        Type type = new TypeToken<List<ReminderClass>>(){}.getType();
//        reminderList.add(new ReminderClass("Doctor's Appointment","2019-02-03 2:13"));
//        reminderList = gson.fromJson(json, type);
        alarm = (AlarmManager) getSystemService(ALARM_SERVICE);


        findViewById(R.id.SetReminderbtn).setOnClickListener(this);
        findViewById(R.id.Cancelbtn).setOnClickListener(this);

        vs1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                        "Speech recognition demo");
                startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
            }

        });
        buttonmyreminders = (Button) findViewById(R.id.MyRemindersbtn);
        buttonmyreminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetRemindersPage.this, MyReminders.class);
                startActivity(intent);
            }
        });
        buttongoback = (Button) findViewById(R.id.GoBackbtn);
        buttongoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SetRemindersPage.this, RemindersPage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        final MediaPlayer mp = MediaPlayer.create(SetRemindersPage.this, R.raw.loginsound);
        TimePicker timePicker = findViewById(R.id.TimePicker);
        DatePicker datePicker = findViewById(R.id.DatePicker);
        EditText editText = findViewById(R.id.EditText);

        final int random = new Random().nextInt(100) + 1;

        Intent intent = new Intent(SetRemindersPage.this, AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        intent.putExtra("todo", editText.getText().toString());


        PendingIntent alarmIntent = PendingIntent.getBroadcast(SetRemindersPage.this, random,
                intent, PendingIntent.FLAG_CANCEL_CURRENT);


        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();

        Calendar startTime = Calendar.getInstance();
//        int month = 0;
//        if(datePicker.getMonth() == 12) {
//            month = 1;
//        } else {
//            month = datePicker.getMonth();
//        }
        startTime.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        startTime.set(Calendar.HOUR_OF_DAY, hour);
        startTime.set(Calendar.MINUTE, minute);
        startTime.set(Calendar.SECOND, 0);
        long alarmStartTime = startTime.getTimeInMillis();

        alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);

        alarmList.add(alarmIntent);
        requestList.add(random);

//        String json2 = gson.toJson(requestList);
//        editor.putString("requestList", json2);
//        editor.commit();

        switch (view.getId()) {
            case R.id.SetReminderbtn:
                int month = 0;
                if(datePicker.getMonth() == 11) {
                    month = 1;
                } else {
                    month = datePicker.getMonth() + 1;
                }
                mp.start();
                this.setReminder(editText.getText().toString(), (String.valueOf(datePicker.getYear()) + "-" + String.valueOf(month) + "-" + String.valueOf(datePicker.getDayOfMonth()) + " " + String.valueOf(timePicker.getCurrentHour()) + ":" + String.valueOf(timePicker.getCurrentMinute())).toString());
                break;

            case R.id.Cancelbtn:
                mp.start();
                alarm.cancel(alarmIntent);
                Toast t = Toast.makeText(getApplicationContext(),"Cancelled!",Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER,0,0);
                TextView tv = new TextView(SetRemindersPage.this);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(22);
                tv.setBackgroundColor(Color.parseColor("#0071FF"));
                tv.setText("Cancelled!");
                t.setView(tv);
                t.show();
                break;
        }

    }

    private void setReminder(String title,String date) {
        Gson gson = new Gson();
        String json = sharedpreferences.getString("reminderList", "");
        Type type = new TypeToken<List<ReminderClass>>(){}.getType();
        if(!json.isEmpty()) {
            reminderList = gson.fromJson(json, type);
        }
        ReminderClass reminderClass = new ReminderClass(title, date);
        reminderList.add(reminderClass);
        String json2 = gson.toJson(reminderList);
        editor.remove("reminderList");
        editor.putString("reminderList", json2);
        editor.commit();

        Toast t = Toast.makeText(getApplicationContext(),"Done!",Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER,0,0);
        TextView tv = new TextView(SetRemindersPage.this);
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(22);
        tv.setBackgroundColor(Color.parseColor("#0071FF"));
        tv.setText("Done!");
        t.setView(tv);
        t.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            task.setText(matches.get(0));
        }
    }

//    public void unsetReminder(int index) {
//        PendingIntent alarmIntent = alarmList.get(index);
//        alarm.cancel(alarmIntent);
//    }

}