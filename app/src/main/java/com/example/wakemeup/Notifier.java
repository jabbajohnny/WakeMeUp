package com.example.wakemeup;

import android.media.MediaPlayer;

public class Notifier extends Thread{

    AlarmCreator alarmCreator;
    long time;

    public Notifier(AlarmCreator alarmCreator, long time) {
        this.alarmCreator = alarmCreator;
        this.time = time;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(time);
            alarmCreator.player = MediaPlayer.create(alarmCreator, R.raw.temple);
            alarmCreator.player.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
