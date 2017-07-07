package software.unf.dk.simonsaysworkingproject;


import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by deltager on 06-07-17.
 */

public class Bulb {
    Button lightButton;
    int on;
    int off;

    public Bulb(Button square, int bunny, int star) {
        lightButton = square;
        on = bunny;
        off = star;

        lightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    lightButton.setBackgroundColor(on);
                    return true;
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    lightButton.setBackgroundColor(off);
                    return true;
                }
                return false;
            }
        });
    }

    public void blink () {
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
