package com.example.sampledemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogActivity extends AppCompatActivity {
    private Button mBtnShow1,mBtnShow2;
    private final String[] item = {"item1","item2","item3","item4"};
    private final boolean[] isStatue = new boolean[item.length];

    private View.OnClickListener mBtnSho_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new AlertDialog.Builder(DialogActivity.this)
                    .setTitle(R.string.app_name)
                    .setMultiChoiceItems(item, isStatue, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                        }
                    })
                    .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .show();
        }
    };

    private View.OnClickListener mBtnShow2_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new AlertDialog.Builder(DialogActivity.this)
                    .setTitle(R.string.app_name)
                    .setIcon(R.drawable.ic_login)
                    .setView(R.layout.dialog_view)
                    .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        init();
    }

    private void init(){
        mBtnShow1 = findViewById(R.id.mBtnShow1);
        mBtnShow1.setOnClickListener(mBtnSho_click);
        mBtnShow2 = findViewById(R.id.mBtnShow2);
        mBtnShow2.setOnClickListener(mBtnShow2_click);
    }
}
