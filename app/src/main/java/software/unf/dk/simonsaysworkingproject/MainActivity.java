package software.unf.dk.simonsaysworkingproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button greenButton, orangeButton, redButton, blueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greenButton = (Button) findViewById(R.id.greenButton);
        orangeButton = (Button) findViewById(R.id.orangeButton);
        redButton = (Button) findViewById(R.id.redButton);
        blueButton = (Button) findViewById(R.id.blueButton);

    }

    public void green(View view) {
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
    }

}
