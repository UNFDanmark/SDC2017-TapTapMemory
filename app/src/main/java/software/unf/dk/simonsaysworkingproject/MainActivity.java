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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private final int GREEN_ON = 0xFF00e600;
    private final int GREEN_OFF = 0xFF669900;
    private final int ORANGE_ON = 0xFFffbb33;
    private final int ORANGE_OFF = 0xFFff8800;
    private final int RED_ON = 0xFFff1a75;
    private final int RED_OFF = 0xFFcc0000;
    private final int BLUE_ON = 0xFF66d9ff;
    private final int BLUE_OFF = 0xFF0086b3;
    private Sequence sequence;
    private ArrayList<Bulb> bulbList;
    private ArrayList<Integer> clicked;
    private MediaPlayer green, orange, red, blue;
    private TextView points;
    private int count;
    private final int Toast_Color = 0xFFbfbfbf;


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

        bulbList.add(new Bulb((Button) findViewById(R.id.greenButton), GREEN_ON, GREEN_OFF, 0));
        bulbList.add(new Bulb((Button) findViewById(R.id.orangeButton), ORANGE_ON, ORANGE_OFF, 1));
        bulbList.add(new Bulb((Button) findViewById(R.id.redButton), RED_ON, RED_OFF, 2));
        bulbList.add(new Bulb((Button) findViewById(R.id.blueButton), BLUE_ON, BLUE_OFF, 3));

        sequence = new Sequence(0, 4);

        clicked = new ArrayList<>();

        points = (TextView) findViewById(R.id.points);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Button newActivity = (Button) findViewById(R.id.startActivity);


    }


    public void start(View view) {
        sequence.add(4);
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
                    count++;
                    points.setText("Points: " + count);

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

    public void menu(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));
    }
}
