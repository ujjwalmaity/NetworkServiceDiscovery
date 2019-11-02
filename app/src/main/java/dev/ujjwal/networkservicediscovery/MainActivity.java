package dev.ujjwal.networkservicediscovery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NSDHelperRegister nsdHelperRegister;
    NSDHelperDisccover nsdHelperDisccover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nsdHelperRegister == null)
                    nsdHelperRegister = new NSDHelperRegister(getApplicationContext());
                else
                    Toast.makeText(getApplicationContext(), "Already Registered", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.discover).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nsdHelperDisccover = new NSDHelperDisccover(getApplicationContext());
            }
        });
    }

    @Override
    protected void onPause() {
        if (nsdHelperRegister != null) {
            nsdHelperRegister.tearDown();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (nsdHelperRegister != null) {
            nsdHelperRegister.registerService(nsdHelperRegister.getLocalPort());
        }
    }

    @Override
    protected void onDestroy() {
        if (nsdHelperRegister != null) {
            nsdHelperRegister.tearDown();
        }
        if (nsdHelperDisccover != null) {
            nsdHelperDisccover.tearDown();
        }
        super.onDestroy();
    }
}
