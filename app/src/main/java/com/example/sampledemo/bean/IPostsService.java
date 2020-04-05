package com.example.sampledemo.bean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Wade on 2020/4/5.
 */
public interface IPostsService {
    @GET("/posts")
    Call<List<PostsBean>> getDataBean(@Query("userId") int userId);
}
