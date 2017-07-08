package software.unf.dk.simonsaysworkingproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);


    }

    public void back(View view) {
        startActivity(new Intent(StoreActivity.this, MainActivity.class));
    }

    public void newLevel(View view) {
        startActivity(new Intent(StoreActivity.this, SecondActivity.class));
    }

}
