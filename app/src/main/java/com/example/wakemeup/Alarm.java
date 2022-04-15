package com.example.wakemeup;

import android.media.MediaPlayer;

import java.util.Calendar;

public class Alarm extends Thread{

    Choice choice;
    String name;
    int sound;
    long time;

    public Alarm(Choice choice, String name, int sound, long time) {
        this.choice = choice;
        this.name = name;
        this.sound = sound;
        this.time = time;
    }

    public void run() {
        try {
            Calendar now = Calendar.getInstance();
            Thread.sleep(time - now.getTimeInMillis());
            choice.player = MediaPlayer.create(choice, sound);
            choice.player.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
