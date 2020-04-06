package com.example.sampledemo.bean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Wade on 2020/4/5.
 */
public interface IPostsService {
    @GET("/posts")
    Call<List<PostsBean>> getDataBean(@Query("userId") int userId);

    @POST("/posts")
    @FormUrlEncoded
    Observable<PostsBean> postDataBean(@Field("title") String title,
                                       @Field("body") String body,
                                       @Field("userId") long userId);
}
