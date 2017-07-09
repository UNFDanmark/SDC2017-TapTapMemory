package software.unf.dk.simonsaysworkingproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class StoreActivity extends AppCompatActivity {

    private long count;
    private TextView points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        points = (TextView) findViewById(R.id.points2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void back(View view) {
        startActivity(new Intent(StoreActivity.this, MainActivity.class));
    }

    public void newLevel(View view) {
        if (count >= 30) {
            startActivity(new Intent(StoreActivity.this, SecondActivity.class));
            /*count -= 20;
            System.out.println(count);
            Log.i("Find mig", "Find mig"); */
        } else {
            Toast.makeText(getApplicationContext(), "Not enough points", Toast.LENGTH_SHORT).show();
        }
    }

    public void onResume() {
        super.onResume();
        count = Save.load(getApplicationContext());
        points.setText(String.valueOf("Points: " + count));
    }
// New skin
    public void newLevel2(View view) {
        if (count >= 50) {
            startActivity(new Intent(StoreActivity.this, ThirdActivity.class));
            count -= 50;
        } else {
            Toast.makeText(getApplicationContext(), "Not enough points", Toast.LENGTH_SHORT).show();
        }
    }

}
