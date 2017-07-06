package software.unf.dk.simonsaysworkingproject;

import android.graphics.Color;
import android.os.CountDownTimer;
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
    private final int RED_ON = 0xFFff3333;
    private final int RED_OFF = 0xFFcc0000;
    private final int BLUE_ON = 0xFF66d9ff;
    private final int BLUE_OFF = 0xFF0086b3;
    private Sequence sequence;
    private ArrayList<Button> buttonList;
    private ArrayList<Bulb> bulbList;
    private ArrayList<Integer> colorOffList;
    private ArrayList<Integer> colorOnList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.startButton);

        sequence = new Sequence(0);

        bulbList = new ArrayList<>();

        bulbList.add(new Bulb((Button) findViewById(R.id.greenButton), GREEN_ON, GREEN_OFF));
        bulbList.add(new Bulb((Button) findViewById(R.id.orangeButton), ORANGE_ON, ORANGE_OFF));
        bulbList.add(new Bulb((Button) findViewById(R.id.redButton), RED_ON, RED_OFF));
        bulbList.add(new Bulb((Button) findViewById(R.id.blueButton), BLUE_ON, BLUE_OFF));
        
        buttonList = new ArrayList<>();
        buttonList.add((Button) findViewById(R.id.greenButton));
        buttonList.add((Button) findViewById(R.id.orangeButton));
        buttonList.add((Button) findViewById(R.id.redButton));
        buttonList.add((Button) findViewById(R.id.blueButton));

        colorOffList = new ArrayList<>();
        colorOffList.add(GREEN_OFF);
        colorOffList.add(ORANGE_OFF);
        colorOffList.add(RED_OFF);
        colorOffList.add(BLUE_OFF);

        colorOnList = new ArrayList<>();
        colorOnList.add(GREEN_ON);
        colorOnList.add(ORANGE_ON);
        colorOnList.add(RED_ON);
        colorOnList.add(BLUE_ON);


        buttonList.get(0).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("tagtag0", "ontouch");
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("tagtag1", "action button press");
                        buttonList.get(0).setBackgroundColor(GREEN_ON);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        buttonList.get(0).setBackgroundColor(GREEN_OFF);
                        return true;
                }
                return false;
            }
        });
        buttonList.get(1).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("tagtag0", "ontouch");
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("tagtag1", "action button press");
                        buttonList.get(1).setBackgroundColor(ORANGE_ON);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        buttonList.get(1).setBackgroundColor(ORANGE_OFF);
                        return true;
                }
                return false;
            }
        });
        buttonList.get(2).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("tagtag0", "ontouch");
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("tagtag1", "action button press");
                        buttonList.get(2).setBackgroundColor(RED_ON);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        buttonList.get(2).setBackgroundColor(RED_OFF);
                        return true;
                }
                return false;
            }
        });
        buttonList.get(3).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.i("tagtag0", "ontouch");
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i("tagtag1", "action button press");
                        buttonList.get(3).setBackgroundColor(BLUE_ON);
                        return true;
                    case MotionEvent.ACTION_UP:
                        Log.i("tagtag2", "action button release");
                        buttonList.get(3).setBackgroundColor(BLUE_OFF);
                        return true;
                }
                return false;
            }
        });
        buttonList.get(0).setBackgroundColor(GREEN_OFF);
        buttonList.get(1).setBackgroundColor(ORANGE_OFF);
        buttonList.get(2).setBackgroundColor(RED_OFF);
        buttonList.get(3).setBackgroundColor(BLUE_OFF);
    }

    public void start(View view) {
        sequence.add();
        for (int i = 0; i < sequence.length(); i++) {
            int x = sequence.get(i);
            bulbList.get(x).blink();
        }
//        light(sequence.get(0));
        /*
        for (int i = 0; i < sequence.length(); i++) {
            rnr = sequence.get(i);
            if (rnr == 1) {
                buttonList.get(0).setBackgroundColor(GREEN_ON);
                new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        buttonList.get(0).setBackgroundColor(GREEN_OFF);

                    }
                }.start();
            } else if (rnr == 2) {
                buttonList.get(1).setBackgroundColor(ORANGE_ON);
                new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        buttonList.get(1).setBackgroundColor(ORANGE_OFF);

                    }
                }.start();
            } else if (rnr == 3) {
                buttonList.get(3).setBackgroundColor(BLUE_ON);
                new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        buttonList.get(3).setBackgroundColor(BLUE_OFF);

                    }
                }.start();
            } else if (rnr == 0) {
                buttonList.get(2).setBackgroundColor(RED_ON);
                new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        buttonList.get(2).setBackgroundColor(RED_OFF);

                    }
                }.start();
            }
        }*/
    }
    public void light(final int buttonIndex) {
        buttonList.get(buttonIndex).setBackgroundColor(colorOnList.get(buttonIndex));
        CountDownTimer timer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                buttonList.get(buttonIndex).setBackgroundColor(colorOffList.get(buttonIndex));
                if (buttonIndex < sequence.length()) {
                    light(buttonIndex+1);
                }
            }
        };
        timer.start();
    }

        /*if (rnr == 1) {
            buttonList.get(0).setBackgroundColor(GREEN_ON);
            new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    buttonList.get(0).setBackgroundColor(GREEN_OFF);

                }
            }.start();
        } else if (rnr == 2) {
            buttonList.get(1).setBackgroundColor(ORANGE_ON);
            new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    buttonList.get(1).setBackgroundColor(ORANGE_OFF);

                }
            }.start();
        } else if (rnr == 3) {
            buttonList.get(3).setBackgroundColor(BLUE_ON);
            new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    buttonList.get(3).setBackgroundColor(BLUE_OFF);

                }
            }.start();
        } else if (rnr == 0) {
            buttonList.get(2).setBackgroundColor(RED_ON);
            new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    buttonList.get(2).setBackgroundColor(RED_OFF);

                }
            }.start();
        }
    }*/




    /*public void green(View view) {
        buttonList.get(0).setBackgroundColor(Color.GREEN);
    }

    public void orange(View view) {
        buttonList.get(1).setBackgroundColor(Color.YELLOW);
    }

    public void blue(View view) {
        buttonList.get(3).setBackgroundColor(Color.CYAN);
    }
    public void red(View view) {
        buttonList.get(2).setBackgroundColor(Color.RED);
    }*/

}
