package software.unf.dk.simonsaysworkingproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    private Button transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        transition = (Button) findViewById(R.id.transition);
    }

    public void transition(View view) {
        startActivity(new Intent(StartActivity.this, MainActivity.class));
    }
}
