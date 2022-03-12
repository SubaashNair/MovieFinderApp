package com.example.moviefinderapp.response;

import com.example.moviefinderapp.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//This class is for getting multiple movies or movies list based on popular movie
public class MovieSearchResponse {

    @SerializedName("total_results")
    @Expose()
    private int total_count;//getting the page result which is in int

    @SerializedName("results")
    @Expose()
    private List<MovieModel> movies; //getting the movies in results list added in the MovieModel class

    //singleton method for total count created in line14
    public int getTotal_count(){
        return total_count;
    }

    public List<MovieModel> getMovies(){
        return movies;
    }


    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", movies=" + movies +
                '}';
    }
}
