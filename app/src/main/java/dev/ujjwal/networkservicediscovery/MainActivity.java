package dev.ujjwal.networkservicediscovery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.nsd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NSDHelper(getApplicationContext());
            }
        });
    }
}
