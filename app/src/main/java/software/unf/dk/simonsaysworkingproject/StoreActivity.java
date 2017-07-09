package software.unf.dk.simonsaysworkingproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    private long count;
    private TextView points, pris, pris2;
    private Button level2, level3;
    private int level2pris, level3pris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        points = (TextView) findViewById(R.id.points2);
        pris = (TextView) findViewById(R.id.pris);
        pris2 = (TextView) findViewById(R.id.pris2);
        level2 = (Button) findViewById(R.id.level2);
        level3 = (Button) findViewById(R.id.level3);
        level2pris = 1;
        level3pris = 2;

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void back(View view) {
        startActivity(new Intent(StoreActivity.this, MainActivity.class));
    }

    public void newLevel(View view) {
        if (count >= level2pris) {
            startActivity(new Intent(StoreActivity.this, SecondActivity.class));
            count -= level2pris;
            Save.savePoints(count, getApplicationContext());
            Save.saveLevel2(true, this);
        } else {
            Toast.makeText(getApplicationContext(), "Not enough points", Toast.LENGTH_SHORT).show();
        }
    }

    public void onResume() {
        super.onResume();
        count = Save.load(getApplicationContext());
        points.setText(String.valueOf("Points: " + count));
        boolean level2Bought = Save.loadLevel2(this);
        if (level2Bought) {
            level2pris = 0;
        }
    }

    public void newLevel2(View view) {
        if (count >= 0) {
            startActivity(new Intent(StoreActivity.this, ThirdActivity.class));
            //count -= 50;
            Save.savePoints(count, getApplicationContext());
        } else {
            Toast.makeText(getApplicationContext(), "Not enough points", Toast.LENGTH_SHORT).show();
        }
    }

}
