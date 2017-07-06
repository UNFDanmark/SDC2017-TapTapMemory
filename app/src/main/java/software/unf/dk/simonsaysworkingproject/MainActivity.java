package software.unf.dk.simonsaysworkingproject;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity {

    private Button greenButton, orangeButton, redButton, blueButton, start;
    private int rnr;
    private final int GREEN_ON = 0xFF00e600;
    private final int GREEN_OFF = 0xFF669900;
    private final int ORANGE_ON = 0xFFffbb33;
    private final int ORANGE_OFF = 0xFFff8800;
    private final int RED_ON = 0xFFff3333;
    private final int RED_OFF = 0xFFcc0000;
    private final int BLUE_ON = 0xFF66d9ff;
    private final int BLUE_OFF = 0xFF0086b3;
    private Sequence sequence;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.startButton);

        sequence = new Sequence(0);


        greenButton = (Button) findViewById(R.id.greenButton);
        greenButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("tagtag0", "ontouch");
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("tagtag1", "action button press");
                        greenButton.setBackgroundColor(GREEN_ON);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        greenButton.setBackgroundColor(GREEN_OFF);
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
                        orangeButton.setBackgroundColor(ORANGE_ON);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        orangeButton.setBackgroundColor(ORANGE_OFF);
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
                        redButton.setBackgroundColor(RED_ON);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        redButton.setBackgroundColor(RED_OFF);
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
                        blueButton.setBackgroundColor(BLUE_ON);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        blueButton.setBackgroundColor(BLUE_OFF);
                        return true;
                }
                return false;
            }
        });
        greenButton.setBackgroundColor(GREEN_OFF);
        orangeButton.setBackgroundColor(ORANGE_OFF);
        redButton.setBackgroundColor(RED_OFF);
        blueButton.setBackgroundColor(BLUE_OFF);
    }

    public void start(View view) {
        sequence.add();

        Random generator = new Random();
        rnr = (generator.nextInt(4));
        if (rnr == 1) {
            greenButton.setBackgroundColor(GREEN_ON);
            new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    greenButton.setBackgroundColor(GREEN_OFF);

                }
            }.start();
        } else if (rnr == 2) {
            orangeButton.setBackgroundColor(ORANGE_ON);
            new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    orangeButton.setBackgroundColor(ORANGE_OFF);

                }
            }.start();
        } else if (rnr == 3) {
            blueButton.setBackgroundColor(BLUE_ON);
            new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    blueButton.setBackgroundColor(BLUE_OFF);

                }
            }.start();
        } else if (rnr == 0) {
            redButton.setBackgroundColor(RED_ON);
            new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    redButton.setBackgroundColor(RED_OFF);

                }
            }.start();
        }
    }




    /*public void green(View view) {
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
