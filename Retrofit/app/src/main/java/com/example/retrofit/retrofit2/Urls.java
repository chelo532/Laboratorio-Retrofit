package com.example.retrofit.retrofit2;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Urls {

    @GET("/api/news")
    Call<JsonObject> getNoticias();

}
