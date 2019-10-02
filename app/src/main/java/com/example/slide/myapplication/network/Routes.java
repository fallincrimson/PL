package com.example.slide.myapplication.network;

import com.example.slide.myapplication.model.DataBuku;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * * Written by @JoeFachrizal 02/10/2019.
 **/
public interface Routes {
    @GET("{fild}.json")
    Call<DataBuku> getFild(@Path("fild") String fild);
}
