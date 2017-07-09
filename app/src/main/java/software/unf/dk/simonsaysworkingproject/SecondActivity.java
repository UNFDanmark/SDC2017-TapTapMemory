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

public class SecondActivity extends AppCompatActivity {
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
    private RelativeLayout relativeLay;
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
        green = MediaPlayer.create(this, R.raw.tone1);
        orange = MediaPlayer.create(this, R.raw.tone2);
        red = MediaPlayer.create(this, R.raw.tone3);
        blue = MediaPlayer.create(this, R.raw.tone4);
        purple = MediaPlayer.create(this, R.raw.tone5);
        yellow = MediaPlayer.create(this, R.raw.tone6);

        bulbList2.add(new Bulb((Button) findViewById(R.id.greenButton), GREEN_ON, GREEN_OFF, 0));
        bulbList2.add(new Bulb((Button) findViewById(R.id.orangeButton), ORANGE_ON, ORANGE_OFF, 1));
        bulbList2.add(new Bulb((Button) findViewById(R.id.redButton), RED_ON, RED_OFF, 2));
        bulbList2.add(new Bulb((Button) findViewById(R.id.blueButton), BLUE_ON, BLUE_OFF, 3));
        bulbList2.add(new Bulb((Button) findViewById(R.id.purpleButton), PURPLE_ON, PURPLE_OFF, 4));
        bulbList2.add(new Bulb((Button) findViewById(R.id.yellowButton), YELLOW_ON, YELLOW_OFF,5));
        relativeLay = (RelativeLayout) findViewById(R.id.relativeLay2);

        sequence2 = new Sequence(0, 6);

        clicked2 = new ArrayList<>();

        points = (TextView) findViewById(R.id.points);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        points.setText(String.valueOf("Points: " + count));

    }

    public void start(View view) {
        sequence2.add(6);
        start.setEnabled(false);
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
                    t.setGravity(Gravity.LEFT, relativeLay.getWidth() / 2, relativeLay.getHeight() / 3);

                    t.show();
                    alarmBeepMP.start();
                    sequence2.restart();
                }
            }
        } else {
            Toast t = Toast.makeText(this, "NOPE.", Toast.LENGTH_SHORT);
            t.setGravity(Gravity.LEFT, relativeLay.getWidth() / 2, relativeLay.getHeight() / 3);
            t.show();
            alarmBeepMP.start();
            sequence2.restart();
        }
        if(sequence2.length() <= clicked2.size()){
            start.setEnabled(true);
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
