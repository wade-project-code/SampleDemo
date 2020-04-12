package com.example.sampledemo;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HandlerActivity extends AppCompatActivity {
    private Handler mHandler;
    private TextView mTextView;
    private Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        init();

        mThread = new Thread(mRunnable);
        mThread.start();
    }

    private void init() {
        mTextView = findViewById(R.id.mTextView);

        mHandler = new Handler(message -> {
            mTextView.setText(message.obj.toString());
            return false;
        });
    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    SimpleDateFormat mSimpleDateFormat =
                            new SimpleDateFormat("YYYY/MM/dd\nEEEE\naa HH:mm:ss");
                    String str = mSimpleDateFormat.format(new Date());
                    mHandler.sendMessage(mHandler.obtainMessage(100, str));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mThread.interrupt();
        mThread = null;
    }
}
