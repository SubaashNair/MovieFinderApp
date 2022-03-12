package com.example.moviefinderapp.response;

import com.example.moviefinderapp.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// This class is for single movie request by the user
public class MovieResponse {
    // 1st - Finding the movie object
    //using serialising name serialise and deserialized an array
    @SerializedName("results")
    @Expose
    private MovieModel movie;

    //singleton pattern
    public MovieModel getMovie(){
        return movie;
    }


}
