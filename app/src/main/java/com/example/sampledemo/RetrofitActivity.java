package com.example.sampledemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sampledemo.bean.AlbumsBean;
import com.example.sampledemo.bean.IAlbumsService;
import com.example.sampledemo.bean.IPostsService;
import com.example.sampledemo.bean.PostsBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    private static Retrofit retrofit,rx_retrofit;
    private Button mBtnGetParam,mBtnGet,mBtnPost;
    private TextView mTxtData;
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

    private View.OnClickListener mBtnPost_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            postDataBean("hello world","happy working");
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
        mBtnPost = findViewById(R.id.mBtnPost);
        mBtnPost.setOnClickListener(mBtnPost_click);
        mTxtData = findViewById(R.id.mTxtData);
    }

    private void createRetrofit(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        retrofit =  new Retrofit.Builder()
                .baseUrl(PostsBean.DATA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        rx_retrofit =  new Retrofit.Builder()
                .baseUrl(PostsBean.DATA_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void postDataBean(String title, String body) {
        IPostsService request = rx_retrofit.create(IPostsService.class);
        request.postDataBean(title, body, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(final PostsBean postsBean) {
                        mTxtData.post(new Runnable() {
                            @Override
                            public void run() {
                                mTxtData.setText(postsBean.toString());
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
