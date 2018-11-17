package com.example.android.movieapppart1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
//import android.content.Context;
//import android.widget.ImageView;
import android.widget.TextView;
//import android.widget.Toast;

import com.example.android.movieapppart1.model.movie;
import com.example.android.movieapppart1.model.tmdb;
import com.example.android.movieapppart1.utils.JsonMovieUtils;
//import com.example.android.movieapppart1.utils.JsonUtils;
import com.example.android.movieapppart1.utils.NetworkUtils;
//import com.example.android.movieapppart1.utils.OpenMovieJsonUtils;

//import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity { // implements GreenAdapter.ListItemClickListener

    //total list of items
    private static final int NUM_LIST_ITEMS = 100;

    //constants
//    private static String base_url = "http://profile_sizes.tmdb.org/t/p/";
//    private static String secure_base_url = "https://profile_sizes.tmdb.org/t/p/";
//    private static String myAPIKEY = "78d11765bbeacbce8284a78e208558c6";
//    private static String defaultSize = "w185";
//    private static String popularMoviesURL = "http://api.themoviedb.org/3/movie/popular?api_key=";

//    private GreenAdapter mAdapter;
//    private RecyclerView mMovielist;


//    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Assigns this activity with the layout
        setContentView(R.layout.activity_main);


        //ASYNC TASK FOR CONTINUING TO BUILD MOVIE ARRAY
        class FetchMovieTask extends AsyncTask<String, Void, String> {

            public FetchMovieTask(String URLFetchString) {
                //make sure we have something
                if (URLFetchString.isEmpty()) {

                    //return "";
                }

                /******* Step 1: get json data.  Create URL for retreival of json data  ********/
                tmdb connectTMDB = new tmdb();
                String queryString = connectTMDB.BuildDefaultQuery();
                URL urlstring = NetworkUtils.buildUrl(queryString);
                String jsonReturnValue = "";
                try {
                    jsonReturnValue = NetworkUtils.getResponseFromHttpUrl(urlstring);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


//                URL MovieRequestUrl = NetworkUtils.buildUrl(URLFetchString);
//                //URL MovieRequestUrl = NetworkUtils.buildUrl(MovieRequestUrl);
//                try {
//                    String jsonMovieResponse = NetworkUtils.getResponseFromHttpUrl(MovieRequestUrl);
//
//                    movie[] simpleJsonMovieData = JsonMovieUtils
//                            .getSimpleMovieStringsFromJson(MainActivity.this, jsonMovieResponse);
//                    return simpleJsonMovieData;
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    return null;
//                }

            @Override
            protected String doInBackground(String... searchQuery) {
                //make sure we have something
                if (searchQuery.length == 0) {
                    return null;
                }

                String location = searchQuery[0];
                URL MovieRequestUrl = NetworkUtils.buildUrl(location);

                try {
                    String simpleJsonMovieData = NetworkUtils.getResponseFromHttpUrl(MovieRequestUrl);

//                    String simpleJsonMovieData = JsonMovieUtils
//                            .getSimpleMovieStringsFromJson(MainActivity.this, jsonMovieResponse);

                    return simpleJsonMovieData;

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }


//            @Override
//            protected movie[] doInBackground(String... searchQuery) {
//                //make sure we have something
//                if (searchQuery.length == 0) { return null; }
//
//                String location = searchQuery[0];
//                URL MovieRequestUrl = NetworkUtils.buildUrl(location);
//
//                try {
//                    String jsonMovieResponse = NetworkUtils
//                            .getResponseFromHttpUrl(MovieRequestUrl);
//
//                    movie[] simpleJsonMovieData = JsonMovieUtils
//                            .getSimpleMovieStringsFromJson(MainActivity.this, jsonMovieResponse);
//
//                    return simpleJsonMovieData;
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    return null;
//                }
//            }

            // COMPLETED (7) Override the onPostExecute method to display the results of the network request
            @Override
            protected void onPostExecute(String MovieData) {
                if (MovieData != null) {

                    /******* Step 1a: Test json data return.  ******/

                    //Grab textview
                    TextView tvTestView = (TextView) findViewById(R.id.TestView);
                    tvTestView.setText(MovieData);


//                    for (Integer x = 0; x <= MovieData.length; x++) {
//                        Picasso.with(context).load(MovieData[x].getImage().toString()).into(mMovieThumb);
//                    }
                }
            }
        }


//        //Grabs the imageview
//        ImageView mMovieThumb = (ImageView) findViewById(R.id.iv_movie_thumb);
//        //defines Grid layout
//        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
//        mMovielist.setLayoutManager(layoutManager);
//        mMovielist.setHasFixedSize(true);

        /******* Step 2: Parse json data to retreive Movie info  ******/


//        /** vvv Movie values and variables vvv **/
//        tmdb MoviesObject = new tmdb();
//        movie[] MOVIES = new movie[NUM_LIST_ITEMS];
//        /** ^^^ Movie values and variables ^^^ **/

        //creates variable for this context
        //Context context = MainActivity.this;

//        MOVIES = JsonMovieUtils.getSimpleMovieStringsFromJson(MainActivity.this, R.string.json_response);
//        //reference recycler view
//        mMovielist = (RecyclerView) findViewById(R.id.rv_movies);

//        //assigns the recycler adapter to listen to input coming from this context
//        mAdapter = new GreenAdapter(NUM_LIST_ITEMS,this);
//        mMovielist.setAdapter(mAdapter);

        //loop and add images to views.
//        for(String ToyName : toyNames){
//            Picasso.with(context).load("http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg").into(mMovieThumb);
//        }


//        URL MovieRequestUrl = NetworkUtils.buildUrl(popularMoviesURL + myAPIKEY);
        //URL MovieRequestUrl = new URL(URLFetchString);
//        try {
//            String jsonMovieResponse = NetworkUtils.getResponseFromHttpUrl(MovieRequestUrl);
//            MOVIES = JsonMovieUtils.getSimpleMovieStringsFromJson(MainActivity.this, jsonMovieResponse);
//            if(MOVIES[0].getImage().toString().length() > 0){
//                Picasso.with(context).load(MOVIES[0].getImage()).into(mMovieThumb);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}




//        movie[] MoviesList = FetchMovieTask(MoviesObject.CreateURL());
//        //tmdb tmdbResults = new tmdb();
//        if(MoviesList.length > 0){
//            //for(Integer x=0 ; x<=MoviesList.length;x++){
//                Picasso.with(context).load(MoviesList[0].getImage().toString()).into(mMovieThumb);
//            }
        //}
    //}

//    @Override
//    public void onListItemClick(int clickedItemIndex) {
//        Intent intent = new Intent(this, DetailActivity.class);
//        intent.putExtra(DetailActivity.MOVIE_ID_EXTRA, clickedItemIndex);
//        startActivity(intent);
//    }

//    public movie[] FetchMovieTask(String URLFetchString) {
//        //make sure we have something
//        if (URLFetchString.isEmpty()) { return null; }
//
//        URL MovieRequestUrl = NetworkUtils.buildUrl(URLFetchString);
//        //URL MovieRequestUrl = new URL(URLFetchString);
//        try {
//            String jsonMovieResponse = NetworkUtils.getResponseFromHttpUrl(MovieRequestUrl);
//
//            movie[] simpleJsonMovieData = JsonMovieUtils.getSimpleMovieStringsFromJson(MainActivity.this, jsonMovieResponse);
//
//            return simpleJsonMovieData;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
