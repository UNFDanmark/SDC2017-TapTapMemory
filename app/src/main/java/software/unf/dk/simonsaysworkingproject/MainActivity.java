package software.unf.dk.simonsaysworkingproject;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private int rnr;
    private final int GREEN_ON = 0xFF00e600;
    private final int GREEN_OFF = 0xFF669900;
    private final int ORANGE_ON = 0xFFffbb33;
    private final int ORANGE_OFF = 0xFFff8800;
    private final int RED_ON = Color.GRAY;
    private final int RED_OFF = 0xFFcc0000;
    private final int BLUE_ON = 0xFF66d9ff;
    private final int BLUE_OFF = 0xFF0086b3;
    private Sequence sequence;
    private ArrayList<Bulb> bulbList;
    private ArrayList<Integer> clicked;
    private MediaPlayer green, orange, red, blue;
    private TextView points;
    private int count;

    Button playGreenButton;
    Button playOrangeButton;
    Button playRedButton;
    Button playBlueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.startButton);
        bulbList = new ArrayList<>();
        green = MediaPlayer.create(this, R.raw.green);
        orange = MediaPlayer.create(this, R.raw.orange);
        red = MediaPlayer.create(this, R.raw.red);
        blue = MediaPlayer.create(this, R.raw.blue);

        bulbList.add(new Bulb((Button) findViewById(R.id.greenButton), GREEN_ON, GREEN_OFF, 0, this));
        bulbList.add(new Bulb((Button) findViewById(R.id.orangeButton), ORANGE_ON, ORANGE_OFF, 1, this));
        bulbList.add(new Bulb((Button) findViewById(R.id.redButton), RED_ON, RED_OFF, 2, this));
        bulbList.add(new Bulb((Button) findViewById(R.id.blueButton), BLUE_ON, BLUE_OFF, 3, this));

        sequence = new Sequence(0);

        clicked = new ArrayList<>();

        points = (TextView) findViewById(R.id.points);


    }


    public void start(View view) {
        sequence.add();
        for (int i = 0; i < sequence.length(); i++) {
            final int sequenceCount = sequence.get(i);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bulbList.get(sequenceCount).blink();

                }
            }, i * 1500);
        }
        clicked = new ArrayList<>();


    }

    public void save1(View view) {
        save(0);
    }

    public void save2(View view) {
        save(1);
    }

    public void save3(View view) {
        save(2);
    }

    public void save4(View view) {
        save(3);
    }

    //
    private void save(int j) {
        Log.i("", "Hey");
        final MediaPlayer alarmBeepMP = MediaPlayer.create(this, R.raw.alarm_beep);
        if (clicked.size() > sequence.length()) {
            alarmBeepMP.start();
        }
        if (clicked.size() < sequence.length()) {
            clicked.add(bulbList.get(j).ID);
            for (int i = 0; i < clicked.size(); i++) {
                if (sequence.get(i) == clicked.get(i)) {

                    if (j == 0) {
                        green.start();
                    }
                    if (j == 1) {
                        orange.start();
                    }
                    if (j == 2) {
                        red.start();
                    }
                    if (j == 3) {
                        blue.start();
                    }
                    count ++;
                    //crash points.setText(count);



                } else {
                    Toast.makeText(getApplicationContext(), "NOPE", Toast.LENGTH_SHORT).show();
                    alarmBeepMP.start();
                    sequence.restart();
                }
            }
        } else {
            Toast.makeText(getApplicationContext(), "NOPE", Toast.LENGTH_SHORT).show();
            alarmBeepMP.start();
            sequence.restart();
        }
    }

}
