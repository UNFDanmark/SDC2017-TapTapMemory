package software.unf.dk.simonsaysworkingproject;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static software.unf.dk.simonsaysworkingproject.R.raw.tone1;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private final int GREEN_ON = 0xFF17bd05;
    private final int GREEN_OFF = 0xFF107505;
    private final int ORANGE_ON = 0xFFfca41f;
    private final int ORANGE_OFF = 0xFFed8e00;
    private final int RED_ON = 0xFFff1a75;
    private final int RED_OFF = 0xFFcc0000;
    private final int BLUE_ON = 0xFF66d9ff;
    private final int BLUE_OFF = 0xFF0086b3;
    private Sequence sequence;
    private ArrayList<Bulb> bulbList;
    private ArrayList<Integer> clicked;
    private MediaPlayer green, orange, red, blue;
    private TextView points, highScore;
    private long count;
    private RelativeLayout relativeLay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.startButton);
        bulbList = new ArrayList<>();
        green = MediaPlayer.create(this, R.raw.tone1);
        orange = MediaPlayer.create(this, R.raw.tone2);
        red = MediaPlayer.create(this, R.raw.tone3);
        blue = MediaPlayer.create(this, R.raw.tone4);

        bulbList.add(new Bulb((Button) findViewById(R.id.greenButton), GREEN_ON, GREEN_OFF, 0));
        bulbList.add(new Bulb((Button) findViewById(R.id.orangeButton), ORANGE_ON, ORANGE_OFF, 1));
        bulbList.add(new Bulb((Button) findViewById(R.id.redButton), RED_ON, RED_OFF, 2));
        bulbList.add(new Bulb((Button) findViewById(R.id.blueButton), BLUE_ON, BLUE_OFF, 3));
        relativeLay = (RelativeLayout) findViewById(R.id.relativeLay);
        highScore = (TextView) findViewById(R.id.highScore);
        highScore.setText("High Score: " + Save.loadHighScore(this) + "");


        sequence = new Sequence(0, 4);

        clicked = new ArrayList<>();

        points = (TextView) findViewById(R.id.points);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    public void start(View view) {
        sequence.add(4);
        start.setEnabled(false);
        for (Bulb b : bulbList) {
            b.getLightButton().setEnabled(false);
        }
        for (int i = 0; i < sequence.length(); i++) {
            final int sequenceCount = sequence.get(i);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bulbList.get(sequenceCount).blink(1000);

                }
            }, i * 1500);

        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (Bulb b : bulbList) {
                    b.getLightButton().setEnabled(true);
                }

            }
        }, sequence.length() * 1500);

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

    private void save(int j) {
        Log.i("", "Hey");
        final MediaPlayer alarmBeepMP = MediaPlayer.create(this, R.raw.alarm_beep);
        if (clicked.size() > sequence.length()) {
            alarmBeepMP.start();
        }
        if (clicked.size() < sequence.length()) {
            clicked.add(bulbList.get(j).getID());
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
                    count++;
                    points.setText("Points: " + count);
                    Save.savePoints(count, getApplicationContext());
                } else {
                    Toast t = Toast.makeText(this, "NOPE.", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.LEFT, relativeLay.getWidth() / 2, relativeLay.getHeight() / 3);
                    t.show();
                    alarmBeepMP.start();
                    sequence.restart();
                }
            }
        } else {
            Toast t = Toast.makeText(this, "NOPE.", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.LEFT, relativeLay.getWidth() / 2, relativeLay.getHeight() / 3);
            t.show();
            alarmBeepMP.start();
            sequence.restart();
        }
        if (sequence.length() <= clicked.size()) {
            start.setEnabled(true);
        }
        int currentHighScore = Save.loadHighScore(this);
        long countScore = Save.loadHighScore(getApplicationContext());
        if (currentHighScore < sequence.length()) {
            Save.saveHighScore(sequence.length(), this);
        }
        highScore.setText(String.valueOf("High Score: " + countScore));

    }

    public void menu(View view) {
        startActivity(new Intent(MainActivity.this, StoreActivity.class));
    }

    public void onPause() {
        super.onPause();
        Save.savePoints(count, getApplicationContext());
    }

    public void onResume() {
        super.onResume();
        count = Save.load(getApplicationContext());
        points.setText(String.valueOf("Points: " + count));
    }

}
