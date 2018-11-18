package com.example.android.movieapppart1.model;
//this is a test
import java.net.URL;

public class tmdb {
    //constants
    private static final String base_url = "http://profile_sizes.tmdb.org/t/p/";
    private static final String secure_base_url = "https://profile_sizes.tmdb.org/t/p/";
    private static final String defaultSize = "w185";
    private static final String myAPIKEY = "78d11765bbeacbce8284a78e208558c6";
    private static final String popularMoviesURL = "http://api.themoviedb.org/3/movie/popular?api_key=";
    private static final String TopRatedMoviesURL = "http://api.themoviedb.org/3/movie/top_rated?api_key=";

    //variables for pages
    private int page;
    private int total_results;
    private int total_pages;

    private String MovieFilePath;
    //create objects

    //CONSTRUCTOR
    public tmdb() { };  //*** No args constructor for use in serialization */

//    public tmdb(Integer currpage, Integer total_results, Integer total_pages) {
//        this.page = currpage;
//        this.total_results = total_results;
//        this.total_pages = total_pages;
//    }

    public int getpage() {
        return page;
    }
    public int gettotal_results() {
        return total_results;
    }
    public int gettotal_pages() {
        return total_pages;
    }
    public void setpage(Integer page) {
        this.page = page;
    }
    public void settotal_results(Integer total_results) {
        this.total_results = total_results;
    }
    public void settotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public String BuildDefaultQuery() {
        this.MovieFilePath = popularMoviesURL + myAPIKEY;

        return this.MovieFilePath;
    }

    public String GetPopularMoviesURL() {
        this.MovieFilePath = popularMoviesURL + myAPIKEY;
        return this.MovieFilePath;
    }
    public String GetTopRatedMoviesURL() {
        this.MovieFilePath = TopRatedMoviesURL + myAPIKEY;
        return this.MovieFilePath;
    }

}
