package com.example.moviefinderapp.utils;

import com.example.moviefinderapp.models.MovieModel;
import com.example.moviefinderapp.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    //search for movies
    /*
    https://api.themoviedb.org/3/search/movie?api_key=7e197fed41ae6c61f69c639e9ce85aa4&query=Jack+Reacher
     */

    /*
    allowing retrofit to understand what are the items to be accessed based on the API call
    Search movie using title in this case query
     */
    @GET("4/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") String page
    );

    /*
    search for movie using movie id

     */
    @GET("3/movie/{movie_id}?")
    Call<MovieModel> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );


}
