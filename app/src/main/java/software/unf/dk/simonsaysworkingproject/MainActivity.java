package software.unf.dk.simonsaysworkingproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button greenButton, orangeButton, redButton, blueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greenButton = (Button) findViewById(R.id.greenButton);
        greenButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("tagtag0", "ontouch");
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("tagtag1", "action button press");
                        greenButton.setBackgroundColor(Color.GREEN);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        greenButton.setBackgroundColor(0xFF669900);
                        return true;
                }
                return false;
            }
        });
        orangeButton = (Button) findViewById(R.id.orangeButton);
        orangeButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("tagtag0", "ontouch");
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("tagtag1", "action button press");
                        orangeButton.setBackgroundColor(0xFFffbb33);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        orangeButton.setBackgroundColor(0xFFff8800);
                        return true;
                }
                return false;
            }
        });
        redButton = (Button) findViewById(R.id.redButton);
        redButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("tagtag0", "ontouch");
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("tagtag1", "action button press");
                        redButton.setBackgroundColor(0xFFff3333);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        redButton.setBackgroundColor(0xFFcc0000);
                        return true;
                }
                return false;
            }
        });
        blueButton = (Button) findViewById(R.id.blueButton);
        blueButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("tagtag0", "ontouch");
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("tagtag1", "action button press");
                        blueButton.setBackgroundColor(Color.CYAN);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        blueButton.setBackgroundColor(0xFF0099cc);
                        return true;
                }
                return false;
            }
        });
        greenButton.setBackgroundColor(0xFF669900);
        orangeButton.setBackgroundColor(0xFFff8800);
        redButton.setBackgroundColor(0xFFcc0000);
        blueButton.setBackgroundColor(0xFF0099cc);
    }

   /* public void green(View view) {
        greenButton.setBackgroundColor(Color.GREEN);
    }

    public void orange(View view) {
        orangeButton.setBackgroundColor(Color.YELLOW);
    }

    public void blue(View view) {
        blueButton.setBackgroundColor(Color.CYAN);
    }
    public void red(View view) {
        redButton.setBackgroundColor(Color.RED);
    }*/

}
