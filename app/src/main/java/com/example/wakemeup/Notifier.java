package com.example.wakemeup;

import android.media.MediaPlayer;
import android.media.audiofx.NoiseSuppressor;

public class Notifier extends Thread{

    Choice choice;
    long time;

    public Notifier(Choice choice, long time) {
        this.choice = choice;
        this.time = time;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(time);
            choice.player = MediaPlayer.create(choice, R.raw.temple);
            choice.player.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
