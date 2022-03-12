package com.example.moviefinderapp.request;

import com.example.moviefinderapp.utils.Credentials;
import com.example.moviefinderapp.utils.MovieApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicey {

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    // Singleton pattern
    private static Retrofit retrofit = retrofitBuilder.build();

    // movieApi interface will be created
    private static MovieApi movieApi = retrofit.create(MovieApi.class);

    //constructor of movieApi
    public static MovieApi getMovieApi(){
        return movieApi;
    }
}
