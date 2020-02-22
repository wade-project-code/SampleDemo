package com.example.sampledemo.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.sampledemo.R;

public class ActMain2 extends AppCompatActivity {
    private TextView mTextView;
    private String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
    }

    private void init(){
        Intent intent = getIntent();
        data = intent.getStringExtra("data");

        mTextView = findViewById(R.id.mTextView);
        mTextView.setText("取得資料為 : " + data);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent intent = new Intent();
            intent.putExtra("return","ActMain2回傳資料");
            setResult(RESULT_OK,intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
