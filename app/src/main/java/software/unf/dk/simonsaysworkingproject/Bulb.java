package software.unf.dk.simonsaysworkingproject;


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
    Button lightButton;
    int on;
    int off;
    int ID;
    MainActivity mA;

    public Bulb(Button square, int bunny, int star, int identity, MainActivity x) {
        lightButton = square;
        on = bunny;
        off = star;
        ID = identity;
        mA = x;

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

    public void blink() {
        lightButton.setBackgroundColor(on);
        CountDownTimer timer = new CountDownTimer(1000, 1000) {
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