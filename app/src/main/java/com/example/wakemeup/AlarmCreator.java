package com.example.wakemeup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.time.LocalDate;
import java.util.Calendar;


public class AlarmCreator extends AppCompatActivity {

    public MediaPlayer player;
    static int SOUND;

    Themes alarmTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Themes.initalize();
        setContentView(R.layout.activity_alarmcreator);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void save(View view) {

        TimePicker picker = findViewById(R.id.datePicker1);
        EditText name = findViewById(R.id.Name);

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


        new Alarm(this, name.getText().toString(), SOUND, alarmTime.getTimeInMillis()).start();

        startActivity(new Intent(this, MainActivity.class));
    }

    public void goBack(View view) {
        onBackPressed();
    }

    public void changeTheme(View view) {
        Button button = findViewById(R.id.theme);

        String theme = Themes.themesValues.getFirst();
        Themes.themesValues.offerLast(Themes.themesValues.getFirst());
        Themes.themesValues.removeFirst();

        alarmTheme = Themes.valueOf(theme);
        button.setText(theme);

        switch (alarmTheme) {
            case Temple: SOUND = R.raw.temple;
        }
    }
}