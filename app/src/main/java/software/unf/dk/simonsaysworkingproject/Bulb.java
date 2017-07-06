package software.unf.dk.simonsaysworkingproject;

import android.util.Log;
import android.widget.Button;

/**
 * Created by deltager on 06-07-17.
 */

public class Bulb {
    private Button button;
    private int colorOn;
    private int colorOff;
    private static int sleepTime = 1000;
    public Bulb (Button b, int on, int off) {
        button = b;
        colorOff = off;
        colorOn = on;
        button.setBackgroundColor(off);

    }

    public void blink() {
        button.setBackgroundColor(colorOn);
        try {
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            Log.e("Sleep", "Sleep had exception");
        }
        button.setBackgroundColor(colorOff);

    }
}
