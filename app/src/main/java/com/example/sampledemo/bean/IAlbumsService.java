package com.example.sampledemo.bean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Wade on 2020/4/5.
 */
public interface IAlbumsService {
    @GET("/albums")
    Call<List<AlbumsBean>> getDataBean();
}
