package com.example.sampledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sampledemo.intent.ActMain1;

public class MainActivity extends AppCompatActivity {
    private Button mBtnIntent,mBtnFragment,mBtnCollapsing,mBtnRetrofit,
                    mBtnDialog,mBtnHandler;

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

    private View.OnClickListener mBtnRetrofit_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,RetrofitActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener mBtnDialog_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,DialogActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener mBtnHandler_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,HandlerActivity.class);
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
        mBtnRetrofit = findViewById(R.id.mBtnRetrofit);
        mBtnRetrofit.setOnClickListener(mBtnRetrofit_click);
        mBtnDialog = findViewById(R.id.mBtnDialog);
        mBtnDialog.setOnClickListener(mBtnDialog_click);
        mBtnHandler = findViewById(R.id.mBtnHandler);
        mBtnHandler.setOnClickListener(mBtnHandler_click);
    }
}
