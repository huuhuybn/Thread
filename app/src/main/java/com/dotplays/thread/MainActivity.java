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

        MyThread myThread = new MyThread();
        myThread.execute(0, 9999999);


    }

    class MyThread extends AsyncTask<Integer, Long, String> {

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
        }

        // phuong thuc xy ly du lieu trong thread
        @Override
        protected String doInBackground(Integer... integers) {
            int a = integers[0];
            int b = integers[1];

            for (int i = 0; i < b; i++) {
                publishProgress(Long.valueOf(a));
                a++;
            }
            return "Da Dem Xong tu " + a + " Den " + b;
        }

        // sau khi ket thuc thread va cap nhat du lieu len Main UI
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvKQ.setText(s);
        }

    }
}
