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

public class SecondActivity extends AppCompatActivity {
    private Button start;
    private final int GREEN_ON = 0xFF00e600;
    private final int GREEN_OFF = 0xFF669900;
    private final int ORANGE_ON = 0xFFffbb33;
    private final int ORANGE_OFF = 0xFFe06500;
    private final int RED_ON = 0xFFff1a75;
    private final int RED_OFF = 0xFFcc0000;
    private final int BLUE_ON = 0xFF66d9ff;
    private final int BLUE_OFF = 0xFF0086b3;
    private final int PURPLE_ON = 0xFFff4081;
    private final int PURPLE_OFF = 0xFFaa66cc;
    private final int YELLOW_ON = 0xFFffff80;
    private final int YELLOW_OFF = 0xFFf0c000;
    private Sequence sequence2;
    private ArrayList<Bulb> bulbList2;
    private ArrayList<Integer> clicked2;
    private MediaPlayer green, orange, red, blue, purple, yellow;
    private TextView points;
    private long count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        start = (Button) findViewById(R.id.startButton);
        bulbList2 = new ArrayList<>();
        green = MediaPlayer.create(this, R.raw.green);
        orange = MediaPlayer.create(this, R.raw.orange);
        red = MediaPlayer.create(this, R.raw.red);
        blue = MediaPlayer.create(this, R.raw.blue);
        purple = MediaPlayer.create(this, R.raw.alarm_beep);
        yellow = MediaPlayer.create(this, R.raw.alarm_beep);

        bulbList2.add(new Bulb((Button) findViewById(R.id.greenButton), GREEN_ON, GREEN_OFF, 0));
        bulbList2.add(new Bulb((Button) findViewById(R.id.orangeButton), ORANGE_ON, ORANGE_OFF, 1));
        bulbList2.add(new Bulb((Button) findViewById(R.id.redButton), RED_ON, RED_OFF, 2));
        bulbList2.add(new Bulb((Button) findViewById(R.id.blueButton), BLUE_ON, BLUE_OFF, 3));
        bulbList2.add(new Bulb((Button) findViewById(R.id.purpleButton), PURPLE_ON, PURPLE_OFF, 4));
        bulbList2.add(new Bulb((Button) findViewById(R.id.yellowButton), YELLOW_ON, YELLOW_OFF,5));

        sequence2 = new Sequence(0, 6);

        clicked2 = new ArrayList<>();

        points = (TextView) findViewById(R.id.points);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void start(View view) {
        sequence2.add(6);
        for (int i = 0; i < sequence2.length(); i++) {
            final int sequenceCount = sequence2.get(i);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bulbList2.get(sequenceCount).blink(900);
                }
            }, i * 1300);
        }
        clicked2 = new ArrayList<>();
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
        if (clicked2.size() > sequence2.length()) {
            alarmBeepMP.start();
        }
        if (clicked2.size() < sequence2.length()) {
            clicked2.add(bulbList2.get(j).ID);
            for (int i = 0; i < clicked2.size(); i++) {
                if (sequence2.get(i) == clicked2.get(i)) {
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
                    sequence2.restart();
                }
            }
        } else {
            Toast t = Toast.makeText(this, "NOPE.", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.LEFT, 385, 730);
            t.show();
            alarmBeepMP.start();
            sequence2.restart();
        }

    }

    public void onResume() {
        super.onResume();
        count = Save.load(getApplicationContext());
        points.setText(String.valueOf("Points: " + count));
    }

    public void back(View view) {
        startActivity(new Intent(SecondActivity.this, StoreActivity.class));
    }

}
