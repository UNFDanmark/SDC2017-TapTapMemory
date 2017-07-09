package software.unf.dk.simonsaysworkingproject;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.time.Instant;
import java.util.ArrayList;

/**
 * Created by deltager on 06-07-17.
 */


public class Bulb extends Intent {
    public Button getLightButton() {
        return lightButton;
    }

    private Button lightButton;
    private int on;
    private int off;
    private MediaPlayer sound;

    public int getID() {
        return ID;
    }

    private int ID;

    public Bulb(Button square, int bunny, int star, int identity, MediaPlayer tone) {
        lightButton = square;
        on = bunny;
        off = star;
        ID = identity;
        sound = tone;

        lightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    lightButton.setBackgroundColor(on);

                    return false;
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    lightButton.setBackgroundColor(off);
                    return false;
                }
                return false;
            }
        });
    }

    public void blink(int k) {
        lightButton.setBackgroundColor(on);
        sound.start();
        CountDownTimer timer = new CountDownTimer(k, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                lightButton.setBackgroundColor(off);

            }
        };
        timer.start();

    }


}