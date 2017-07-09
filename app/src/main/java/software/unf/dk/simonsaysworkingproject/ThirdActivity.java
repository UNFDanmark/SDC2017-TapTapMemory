package software.unf.dk.simonsaysworkingproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    private Button start;
    private final int GREEN_ON = 0xFF00e600;
    private final int GREEN_OFF = 0xFF669900;
    private final int ORANGE_ON = 0xFFffbb33;
    private final int ORANGE_OFF = 0xFFeda808;
    private final int RED_ON = 0xFFff1a75;
    private final int RED_OFF = 0xFFcc0000;
    private final int BLUE_ON = 0xFF66d9ff;
    private final int BLUE_OFF = 0xFF0086b3;
    private final int PURPLE_ON = 0xFFa829fc;
    private final int PURPLE_OFF = 0xFF8108d1;
    private final int YELLOW_ON = 0xFFffff80;
    private final int YELLOW_OFF = 0xFFe8d208;
    private Sequence sequence3;
    private ArrayList<Bulb> bulbList3;
    private ArrayList<Integer> clicked3;
    private MediaPlayer green, orange, red, blue, purple, yellow, darkblue, pink, lightgreen;
    private TextView points;
    private long count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        start = (Button) findViewById(R.id.startButton);
        bulbList3 = new ArrayList<>();
        green = MediaPlayer.create(this, R.raw.green);
        orange = MediaPlayer.create(this, R.raw.orange);
        red = MediaPlayer.create(this, R.raw.red);
        blue = MediaPlayer.create(this, R.raw.blue);
        purple = MediaPlayer.create(this, R.raw.alarm_beep);
        yellow = MediaPlayer.create(this, R.raw.alarm_beep);
        darkblue = MediaPlayer.create(this, R.raw.alarm_beep);
        pink = MediaPlayer.create(this, R.raw.alarm_beep);
        lightgreen = MediaPlayer.create(this, R.raw.alarm_beep);

        bulbList3.add(new Bulb((Button) findViewById(R.id.greenButton), GREEN_ON, GREEN_OFF, 0));
        bulbList3.add(new Bulb((Button) findViewById(R.id.orangeButton), ORANGE_ON, ORANGE_OFF, 1));
        bulbList3.add(new Bulb((Button) findViewById(R.id.redButton), RED_ON, RED_OFF, 2));
        bulbList3.add(new Bulb((Button) findViewById(R.id.blueButton), BLUE_ON, BLUE_OFF, 3));
        bulbList3.add(new Bulb((Button) findViewById(R.id.purpleButton), PURPLE_ON, PURPLE_OFF, 4));
        bulbList3.add(new Bulb((Button) findViewById(R.id.yellowButton), YELLOW_ON, YELLOW_OFF,5));
        bulbList3.add(new Bulb((Button) findViewById(R.id.yellowButton), YELLOW_ON, YELLOW_OFF,5));
        bulbList3.add(new Bulb((Button) findViewById(R.id.yellowButton), YELLOW_ON, YELLOW_OFF,5));
        bulbList3.add(new Bulb((Button) findViewById(R.id.yellowButton), YELLOW_ON, YELLOW_OFF,5));

        sequence3 = new Sequence(0, 6);

        clicked3 = new ArrayList<>();

        points = (TextView) findViewById(R.id.points);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void start(View view) {
        sequence3.add(9);
        for (int i = 0; i < sequence3.length(); i++) {
            final int sequenceCount = sequence3.get(i);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bulbList3.get(sequenceCount).blink(800);
                }
            }, i * 1100);
        }
        clicked3 = new ArrayList<>();
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

    public void save5(View view) {
        save(4);
    }

    public void save6(View view) {
        save(5);
    }

    private void save(int j) {
        Log.i("", "Hey");
        final MediaPlayer alarmBeepMP = MediaPlayer.create(this, R.raw.alarm_beep);
        if (clicked3.size() > sequence3.length()) {
            alarmBeepMP.start();
        }
        if (clicked3.size() < sequence3.length()) {
            clicked3.add(bulbList3.get(j).ID);
            for (int i = 0; i < clicked3.size(); i++) {
                if (sequence3.get(i) == clicked3.get(i)) {
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
                    if (j == 4) {
                        purple.start();
                    }
                    if (j == 5) {
                        yellow.start();
                    }
                    count ++;
                    points.setText("Points: " + count);
                    Save.savePoints(count, getApplicationContext());
                } else {
                    Toast t = Toast.makeText(this, "NOPE.", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.LEFT, 385, 730);
                    t.show();
                    alarmBeepMP.start();
                    sequence3.restart();
                }
            }
        } else {
            Toast t = Toast.makeText(this, "NOPE.", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.LEFT, 385, 730);
            t.show();
            alarmBeepMP.start();
            sequence3.restart();
        }

    }

    public void onResume() {
        super.onResume();
        count = Save.load(getApplicationContext());
        points.setText(String.valueOf("Points: " + count));
    }

    public void back(View view) {
        startActivity(new Intent(ThirdActivity.this, StoreActivity.class));
    }

}
