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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
    private Button start;
    private final int GREEN_ON = 0xFF17bd05;
    private final int GREEN_OFF = 0xFF107505;
    private final int ORANGE_ON = 0xFFfca41f;
    private final int ORANGE_OFF = 0xFFff8800;
    private final int RED_ON = 0xFFff1a75;
    private final int RED_OFF = 0xFFcc0000;
    private final int BLUE_ON = 0xFF66d9ff;
    private final int BLUE_OFF = 0xFF0086b3;
    private final int PURPLE_ON = 0xFFb829f5;
    private final int PURPLE_OFF = 0xFF8f29d4;
    private final int YELLOW_ON = 0xFFffff80;
    private final int YELLOW_OFF = 0xFFe8d208;
    private final int DARKBLUE_ON = 0xFF2952f7;
    private final int DARKBLUT_OFF = 0xFF2929ab;
    private final int PINK_ON = 0xFFc92999;
    private final int PINK_OFF = 0xFFdf05f7;
    private final int LIGHTGREEN_ON= 0xFF80ff00;
    private final int LIGHTGREEN_OFF = 0xFF51c205;
    private RelativeLayout relativeLay;
    private Sequence sequence3;
    private ArrayList<Bulb> bulbList3;
    private ArrayList<Integer> clicked3;
    private MediaPlayer green, orange, red, blue, purple, yellow, darkblue, pink, lightgreen;
    private TextView points, highScore;
    private long count, countscore3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        start = (Button) findViewById(R.id.startButton);
        bulbList3 = new ArrayList<>();
        green = MediaPlayer.create(this, R.raw.tone1);
        orange = MediaPlayer.create(this, R.raw.tone2);
        red = MediaPlayer.create(this, R.raw.tone3);
        blue = MediaPlayer.create(this, R.raw.tone4);
        purple = MediaPlayer.create(this, R.raw.tone5);
        yellow = MediaPlayer.create(this, R.raw.tone6);
        darkblue = MediaPlayer.create(this, R.raw.tone7);
        pink = MediaPlayer.create(this, R.raw.tone8);
        lightgreen = MediaPlayer.create(this, R.raw.tone9);

        bulbList3.add(new Bulb((Button) findViewById(R.id.greenButton), GREEN_ON, GREEN_OFF, 0, green));
        bulbList3.add(new Bulb((Button) findViewById(R.id.orangeButton), ORANGE_ON, ORANGE_OFF, 1, orange));
        bulbList3.add(new Bulb((Button) findViewById(R.id.redButton), RED_ON, RED_OFF, 2, red));
        bulbList3.add(new Bulb((Button) findViewById(R.id.blueButton), BLUE_ON, BLUE_OFF, 3, blue));
        bulbList3.add(new Bulb((Button) findViewById(R.id.purpleButton), PURPLE_ON, PURPLE_OFF, 4, purple));
        bulbList3.add(new Bulb((Button) findViewById(R.id.yellowButton), YELLOW_ON, YELLOW_OFF, 5, yellow));
        bulbList3.add(new Bulb((Button) findViewById(R.id.darkblueButton), DARKBLUE_ON, DARKBLUT_OFF, 6, darkblue));
        bulbList3.add(new Bulb((Button) findViewById(R.id.pinkButton), PINK_ON, PINK_OFF, 7, pink));
        bulbList3.add(new Bulb((Button) findViewById(R.id.lightgreenButton), LIGHTGREEN_ON, LIGHTGREEN_OFF, 8, lightgreen));
        relativeLay = (RelativeLayout) findViewById(R.id.relativeLay3);
        highScore = (TextView) findViewById(R.id.highScore3);
        highScore.setText("High Score: " + Save.loadHighScore3(this) + "");


        sequence3 = new Sequence(0, 9);

        clicked3 = new ArrayList<>();

        points = (TextView) findViewById(R.id.points);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void start(View view) {
        sequence3.add(9);
        start.setEnabled(false);
        start.setEnabled(false);
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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (Bulb b:bulbList3) {
                    b.getLightButton().setEnabled(true);
                }

            }
        }, sequence3.length() * 1500);
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

    public void save7(View view) {
        save(6);
    }

    public void save8(View view) {
        save(7);
    }

    public void save9(View view) {
        save(8);
    }

    private void save(int j) {
        Log.i("", "Hey");
        final MediaPlayer alarmBeepMP = MediaPlayer.create(this, R.raw.alarm_beep);
        if (clicked3.size() > sequence3.length()) {
            alarmBeepMP.start();
        }
        if (clicked3.size() < sequence3.length()) {
            clicked3.add(bulbList3.get(j).getID());
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
                    if (j == 6) {
                        darkblue.start();
                    }
                    if (j == 7) {
                        pink.start();
                    }
                    if (j == 8) {
                        lightgreen.start();
                    }
                    count ++;
                    points.setText("Points: " + count);
                    Save.savePoints(count, getApplicationContext());
                } else {
                    Toast t = Toast.makeText(this, "NOPE.", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.LEFT, relativeLay.getWidth() / 2, relativeLay.getHeight() / 3);
                    t.show();
                    alarmBeepMP.start();
                    sequence3.restart();
                }
            }
        } else {
            Toast t = Toast.makeText(this, "NOPE.", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.LEFT, relativeLay.getWidth() / 2, relativeLay.getHeight() / 3);
            t.show();
            alarmBeepMP.start();
            sequence3.restart();
        }
        if(sequence3.length() <= clicked3.size()){
            start.setEnabled(true);
        }
        int currentHighScore3 = Save.loadHighScore3(this);
        long countScore3 = Save.loadHighScore3(getApplicationContext());
        if (currentHighScore3 < sequence3.length()) {
            Save.saveHighScore3(sequence3.length(), this);
        }
        highScore.setText(String.valueOf("High Score: " + countScore3));

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
