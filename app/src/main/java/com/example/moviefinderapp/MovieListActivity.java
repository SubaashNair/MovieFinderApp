package com.example.moviefinderapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviefinderapp.models.MovieModel;
import com.example.moviefinderapp.request.Servicey;
import com.example.moviefinderapp.response.MovieSearchResponse;
import com.example.moviefinderapp.utils.Credentials;
import com.example.moviefinderapp.utils.MovieApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity {


    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetRetrofitResponseAccordingToID();
            }
        });

    }

    private void GetRetrofitResponse() {
        //gets retrofit response from the server
        MovieApi movieApi = Servicey.getMovieApi();

        Call<MovieSearchResponse> responseCall = movieApi
                .searchMovie(
                        Credentials.API_KEY,
                        "Avengers",
                        "1");

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if(response.code()==200){
                    Log.v("Tag","The response: "+response.body().toString());
                    // Making a moviemodel list which will be listed as results
                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());

                    for(MovieModel movie: movies){
                        Log.v("Tag","The release date: "+ movie.getRelease_date());
                    }
                }
                else{
                    try{
                        Log.v("Tag","Error" +response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });


    }

    private void GetRetrofitResponseAccordingToID(){
        MovieApi movieApi = Servicey.getMovieApi();
        Call<MovieModel> respondCall = movieApi
                .getMovie(
                        550,
                        Credentials.API_KEY); //to test the if the movie id response

        respondCall.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if(response.code()==200){
                    MovieModel movie = response.body();
                    Log.v("Tag","The response: " +movie.getTitle());
                }
                else{
                    try{
                        Log.v("Tag","Error" +response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
    }
}

//Making search with ID