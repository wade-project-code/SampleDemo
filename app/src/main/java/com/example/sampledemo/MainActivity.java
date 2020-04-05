package com.example.sampledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sampledemo.intent.ActMain1;

public class MainActivity extends AppCompatActivity {
    private Button mBtnIntent,mBtnFragment,mBtnCollapsing;

    private View.OnClickListener mBtnIntent_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ActMain1.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener mBtnFragment_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener mBtnCollapsing_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,CollapsingActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        mBtnIntent = findViewById(R.id.mBtnIntent);
        mBtnIntent.setOnClickListener(mBtnIntent_click);
        mBtnFragment = findViewById(R.id.mBtnFragment);
        mBtnFragment.setOnClickListener(mBtnFragment_click);
        mBtnCollapsing = findViewById(R.id.mBtnCollapsing);
        mBtnCollapsing.setOnClickListener(mBtnCollapsing_click);
    }
}
