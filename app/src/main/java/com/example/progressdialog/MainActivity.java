package com.example.progressdialog;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    Handler handler;
    Timer timer;
    Runnable runnable;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        //progressDialog.setIndeterminate(true);

        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Progress Box");
        progressDialog.setMessage("Please wait");
        progressDialog.show();


        progressDialog.setProgress(0);
        progressDialog.setMax(100);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {

                i=i+5;
                if (i<=100)
                {
                    progressDialog.setProgress(i);
                }else
                {
                    timer.cancel();
                    progressDialog.cancel();
                    i=0;

                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(runnable);
            }
        },8000,500);

       // progressDialog.cancel();
    }
}
