package com.dotplays.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvKQ;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvKQ = findViewById(R.id.tvKq);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(9999999);


    }

    public void openThread(View view) {

        OnCountFinished onCountFinished = new OnCountFinished() {
            @Override
            public void onFinished(String kq) {
                tvKQ.setText(kq);
            }
        };
        MyThread myThread = new MyThread(progressBar,onCountFinished);
        myThread.execute(0, 9999999);


    }

}
