package com.example.remindme;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class ReminderAdapter extends ArrayAdapter<ReminderClass> {

    Context context;
    int resource;

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(resource,null);
        TextView t1 = v.findViewById(R.id.reminder_title);
        TextView t2 = v.findViewById(R.id.reminder_date);
        ImageView delete = v.findViewById(R.id.reminder_delete);

        ReminderClass reminder = reminderList.get(position);

        t1.setText(reminder.getTitle());
        t2.setText(reminder.getDate());

        v.findViewById(R.id.reminder_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
            }
        });

        return v;
    }

    List<ReminderClass> reminderList;
    List<PendingIntent> alarmList;
    List<Integer> requestList;

    public ReminderAdapter(Context context, int resource, List<ReminderClass> reminderList) {
        super(context, resource, reminderList);
        this.context = context;
        this.resource = resource;
        this.reminderList = reminderList;
    }

    private void removeItem(final int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are you sure you want to delete the reminder?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences sharedpreferences = context.getSharedPreferences("localDB", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                reminderList.remove(index);
                SetRemindersPage srp = new SetRemindersPage();
//                srp.unsetReminder(index);
//                Gson gson2 = new Gson();
//                String json2 = sharedpreferences.getString("requestList", "");
//                Type type2 = new TypeToken<List<Integer>>(){}.getType();
//                requestList = gson2.fromJson(json2, type2);
//                Intent intent = new Intent(context, AlarmReceiver.class);
//                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, requestList.get(index),
//                                intent, PendingIntent.FLAG_CANCEL_CURRENT);
//                AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
//                alarmManager.cancel(pendingIntent);
                notifyDataSetChanged();
                editor.remove("reminderList");
                Gson gson = new Gson();
                String json = gson.toJson(reminderList);
                editor.putString("reminderList", json);
                editor.commit();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
