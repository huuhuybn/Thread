package com.dotplays.thread;


import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyThread extends AsyncTask<Integer, Long, String> {


    private ProgressBar progressBar;
    private TextView tvKQ;

    private OnCountFinished onCountFinished;

    public MyThread(ProgressBar progressBar, OnCountFinished onCountFinished) {
        this.progressBar = progressBar;
        this.onCountFinished = onCountFinished;
    }

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
        onCountFinished.onFinished(s);
    }

}
