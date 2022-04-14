package com.example.wakemeup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import java.time.LocalDate;
import java.util.Calendar;


public class Choice extends AppCompatActivity {

    public MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void save(View view) {


        TimePicker picker = findViewById(R.id.datePicker1);

        Calendar alarmTime = Calendar.getInstance();
        Calendar now = Calendar.getInstance();

        LocalDate currentDate = null;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            currentDate = LocalDate.now();
        }

        alarmTime.set(Calendar.HOUR_OF_DAY, picker.getHour());
        alarmTime.set(Calendar.MINUTE, picker.getMinute());
        alarmTime.set(Calendar.SECOND, 0);

        if(now.getTimeInMillis() >= alarmTime.getTimeInMillis()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                alarmTime.set(Calendar.DAY_OF_MONTH, currentDate.getDayOfMonth() + 1);
            }
        }

        Notifier notifier = new Notifier(this, alarmTime.getTimeInMillis() - now.getTimeInMillis());
        notifier.start();
    }
}