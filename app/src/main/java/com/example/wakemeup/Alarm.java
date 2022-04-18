package com.example.wakemeup;

import android.app.NotificationManager;
import android.media.MediaPlayer;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;

import static android.content.Context.NOTIFICATION_SERVICE;

public class Alarm extends Thread{

    static MainActivity mainActivity;
    AlarmCreator alarmCreator;
    String name;
    int sound;
    long time;

    public Alarm(AlarmCreator alarmCreator, String name, int sound, long time) {
        this.alarmCreator = alarmCreator;
        this.name = name;
        this.sound = sound;
        this.time = time;
    }

    public void run() {
        try {
            Calendar now = Calendar.getInstance();
            Thread.sleep(time - now.getTimeInMillis());
            alarmCreator.player = MediaPlayer.create(alarmCreator, sound);
            alarmCreator.player.start();
            createNotification();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(mainActivity.getApplicationContext(), MainActivity.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_alarm)
                .setContentTitle("Alarm" + name)
                .setContentText("It's time to wake up!");

        NotificationManager manager = (NotificationManager) mainActivity.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}
