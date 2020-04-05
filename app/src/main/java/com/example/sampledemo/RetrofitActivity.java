package com.example.sampledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sampledemo.bean.AlbumsBean;
import com.example.sampledemo.bean.IAlbumsService;
import com.example.sampledemo.bean.PostsBean;

import java.util.List;

import com.example.sampledemo.bean.IPostsService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    private Button mBtnGetParam,mBtnGet;
    private TextView mTxtData;
    private static Retrofit retrofit;

    private View.OnClickListener mBtnGetParam_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            IPostsService request = retrofit.create(IPostsService.class);
            Call<List<PostsBean>> call = request.getDataBean(1);
            call.enqueue(new Callback<List<PostsBean>>() {
                @Override
                public void onResponse(Call<List<PostsBean>> call, retrofit2.Response<List<PostsBean>> response) {
                    final List<PostsBean> list = response.body();
                    mTxtData.post(new Runnable() {
                        @Override
                        public void run() {
                            mTxtData.setText(list.toString());
                        }
                    });
                }

                @Override
                public void onFailure(Call<List<PostsBean>> call, Throwable t) {

                }
            });
        }
    };

    private View.OnClickListener mBtnGet_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            IAlbumsService request = retrofit.create(IAlbumsService.class);
            Call<List<AlbumsBean>> call = request.getDataBean();
            call.enqueue(new Callback<List<AlbumsBean>>() {
                @Override
                public void onResponse(Call<List<AlbumsBean>> call, retrofit2.Response<List<AlbumsBean>> response) {
                    final List<AlbumsBean> list = response.body();
                    mTxtData.post(new Runnable() {
                        @Override
                        public void run() {
                            mTxtData.setText(list.toString());
                        }
                    });
                }

                @Override
                public void onFailure(Call<List<AlbumsBean>> call, Throwable t) {

                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        init();
    }

    private void init(){
        createRetrofit();

        mBtnGetParam = findViewById(R.id.mBtnGetParam);
        mBtnGetParam.setOnClickListener(mBtnGetParam_click);
        mBtnGet = findViewById(R.id.mBtnGet);
        mBtnGet.setOnClickListener(mBtnGet_click);
        mTxtData = findViewById(R.id.mTxtData);
    }

    private void createRetrofit(){
        retrofit =  new Retrofit.Builder()
                .baseUrl(PostsBean.DATA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
