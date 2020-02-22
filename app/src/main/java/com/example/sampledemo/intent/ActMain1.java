package com.example.sampledemo.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sampledemo.R;

public class ActMain1 extends AppCompatActivity {
    private Button mBtn01;
    private Button mBtn02;
    private Button mBtn03;

    private View.OnClickListener mBtn01_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ActMain1.this,ActMain2.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener mBtn02_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ActMain1.this,ActMain2.class);
            intent.putExtra("data","ActMain1帶來資料");
            startActivity(intent);
        }
    };

    private View.OnClickListener mBtn03_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ActMain1.this,ActMain2.class);
            intent.putExtra("data","ActMain1帶來資料並返回時回傳資料");
            startActivityForResult(intent,1111);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        init();
    }

    private void init(){
        mBtn01 = findViewById(R.id.mBtn01);
        mBtn01.setOnClickListener(mBtn01_click);
        mBtn02 = findViewById(R.id.mBtn02);
        mBtn02.setOnClickListener(mBtn02_click);
        mBtn03 = findViewById(R.id.mBtn03);
        mBtn03.setOnClickListener(mBtn03_click);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1111){
            if (resultCode == RESULT_OK){
                String msg = data.getStringExtra("return");
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
            }else{
                finish();
            }
        }
    }
}
