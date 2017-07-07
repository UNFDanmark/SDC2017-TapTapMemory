package software.unf.dk.simonsaysworkingproject;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

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
    private final int RED_ON = Color.BLACK;
    private final int RED_OFF = 0xFFcc0000;
    private final int BLUE_ON = 0xFF66d9ff;
    private final int BLUE_OFF = 0xFF0086b3;
    private Sequence sequence;
    private ArrayList<Bulb> bulbList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.startButton);
        bulbList = new ArrayList<>();

        bulbList.add(new Bulb((Button) findViewById(R.id.greenButton), GREEN_ON, GREEN_OFF));
        bulbList.add(new Bulb((Button) findViewById(R.id.orangeButton), ORANGE_ON, ORANGE_OFF));
        bulbList.add(new Bulb((Button) findViewById(R.id.redButton), RED_ON, RED_OFF));
        bulbList.add(new Bulb((Button) findViewById(R.id.blueButton), BLUE_ON, BLUE_OFF));

        sequence = new Sequence(0);

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
            }, i*1200);
        }

    }


}
