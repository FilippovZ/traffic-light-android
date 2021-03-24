package com.example.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout bulb_1;
    private LinearLayout bulb_2;
    private LinearLayout bulb_3;
    private Button buttonStartStop;
    private boolean startAndStop = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bulb_1 = findViewById(R.id.bulb_1);
        bulb_2 = findViewById(R.id.bulb_2);
        bulb_3 = findViewById(R.id.bulb_3);
        buttonStartStop = findViewById(R.id.buttonStartStop);
    }

    @SuppressLint("SetTextI18n")
    public void onClickStart(View view) {
        if (!startAndStop) {
            buttonStartStop.setText("Stop");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    startAndStop = true;
                    while (startAndStop) {
                        try {
                            bulb_1.setBackgroundColor(getResources().getColor(R.color.red));
                            Thread.sleep(2000);
                            bulb_1.setBackgroundColor(getResources().getColor(R.color.grey));
                            bulb_2.setBackgroundColor(getResources().getColor(R.color.yellow));
                            Thread.sleep(2000);
                            bulb_2.setBackgroundColor(getResources().getColor(R.color.grey));
                            bulb_3.setBackgroundColor(getResources().getColor(R.color.green));
                            Thread.sleep(2000);
                            bulb_3.setBackgroundColor(getResources().getColor(R.color.grey));
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        } else {
            startAndStop = false;
            buttonStartStop.setText("Start");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startAndStop = false;
    }
}