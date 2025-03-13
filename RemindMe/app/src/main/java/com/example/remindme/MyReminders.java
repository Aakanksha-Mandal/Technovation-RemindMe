package com.example.remindme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyReminders extends AppCompatActivity {

    ListView listView;
    List<ReminderClass> reminderList;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    private FloatingActionButton addreminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reminders);

        sharedpreferences = getSharedPreferences("localDB", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

        addreminder = (FloatingActionButton) findViewById(R.id.addreminder);
        addreminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyReminders.this, SetRemindersPage.class);
                startActivity(intent);
            }
        });

        reminderList = new ArrayList<>();


        Gson gson = new Gson();
        String json = sharedpreferences.getString("reminderList", "");
        Type type = new TypeToken<List<ReminderClass>>(){}.getType();
        if(!json.isEmpty()) {
            reminderList = gson.fromJson(json, type);
        }



        if(reminderList.isEmpty()) {
            reminderList.add(new ReminderClass("Doctor's Appointment","2019-02-03"));
            reminderList.add(new ReminderClass("Mom's Appointment","2019-05-03"));
        }

//        reminderList.add(new ReminderClass("Doctor's Appointment","2019-02-03"));
//        reminderList.add(new ReminderClass("Mom's Appointment","2019-05-03"));
//        reminderList.add(new ReminderClass("Shaan Meeting","2019-07-03"));
//        reminderList.add(new ReminderClass("Pick up Sam","2019-10-20"));
//        reminderList.add(new ReminderClass("Eat dinner","2019-12-13"));

        listView = (ListView) findViewById(R.id.reminders_list);

        ReminderAdapter arrayAdapter = new ReminderAdapter(this,R.layout.reminder_list_item,reminderList);

        listView.setAdapter(arrayAdapter);
    }
}
