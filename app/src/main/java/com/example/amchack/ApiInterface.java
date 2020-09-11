package com.example.amchack;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("GetAllBirds")
    Call<List<String>> getAllBirds();

    @GET("{color}&{size}")
    Call<List<Bird>> getFilteredBirds(@Path("color") String color, @Path("size") String size);
}

