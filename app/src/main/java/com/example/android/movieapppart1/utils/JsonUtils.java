package com.example.android.movieapppart1.utils;

//import com.example.manneth.movieapprev6.model.movie;
//import com.udacity.movieclub.model.movie;

//import org.json.JSONArray;
import com.example.android.movieapppart1.model.movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import com.google.gson.Gson;

public class JsonUtils {

    public void compileMovies(String returnResults) throws JSONException {

        final String FD_PAGE_NUM = "page";
        final String FD_RECORD_COUNT = "total_results";
        final String FD_PAGES = "total_pages";
        final String FD_RESULTS = "results";
        final String OWM_MESSAGE_CODE = "cod";

        JSONObject JsonFullResponse = new JSONObject(returnResults);
        JSONArray movieJson = JsonFullResponse.getJSONArray(FD_RESULTS);

        //loop through return to collect all the movie information
        for(int x = 0; x < movieJson.length() ; x++) {
            try {parsemovieJson(movieJson.getJSONObject(x)); } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public static movie parsemovieJson(JSONObject currMovie) throws JSONException {

//        final String FD_PAGE_NUM = "page";
//        final String FD_RESULTS_COUNT = "total_results";
//        final String FD_PAGES = "total_pages";
//        final String FD_RESULTS = "results";

        //Field text labels
//        final String FD_VOTE_COUNT = "vote_count";
//        final String FD_ID = "id";
//        final String FD_IS_VIDEO = "video";
        final String FD_RATING = "vote_average";
        final String FD_TITLE = "title";
//        final String FD_POPULARITY = "popularity";
        final String FD_POSTER_PATH = "poster_path";
//        final String FD_LANGUAGE = "original_language";
//        final String FD_ORIG_TITLE = "original_title";
//        final String FD_GENRE_IDS = "genre_ids";
//        final String FD_BACKDROP_PATH = "backdrop_path";
//        final String FD_IS_ADULT = "adult";
        final String FD_SYNOPSIS = "overview";
        final String FD_RELEASE_DATE = "release_date";

        // Error code
        final String OWM_MESSAGE_CODE = "cod";
        //create object from Json
        //JSONObject JsonFullString = new JSONObject(movieString);
        //JSONObject movieJson = JsonFullString.getJSONObject(FD_RESULTS);

        //movie currmovie = new Gson().fromJson(movieString,movie.class);

        /* Is there an error? */
        if (currMovie.has(OWM_MESSAGE_CODE)) {
            int errorCode = currMovie.getInt(OWM_MESSAGE_CODE);
            switch (errorCode) {
                case HttpURLConnection.HTTP_OK:
                    break;
                case HttpURLConnection.HTTP_NOT_FOUND:
                    /* Location invalid */
                    return null;
                default:
                    /* Server probably down */
                    return null;
            }
        }

        //JSONArray movieArray = movieJson.getJSONArray(FD_HEAD_MAIN_ARRAY);

        //parsedmovieData = new String[movieArray.length()];

        //create movie instance
        movie currmovie = new movie();
        currmovie.setImage(currMovie.getString(FD_POSTER_PATH));
        currmovie.setrating(currMovie.getInt(FD_RATING));
        currmovie.setreleaseDate(currMovie.getString(FD_RELEASE_DATE));
        currmovie.setsynopsis(currMovie.getString(FD_SYNOPSIS));
        currmovie.settitle(currMovie.getString(FD_TITLE));
//        JSONArray ingredients = movieJson.getJSONArray(FD_HEAD_INGREDIENTS);
//        ArrayList ingredientsList = new ArrayList();
//        for(int x=0;x< ingredients.length();x++){
//            ingredientsList.add(ingredients.getString(x));
//        }
//        currmovie.setIngredients(ingredientsList);
//        JSONArray AKAs = movieJson.getJSONArray(FD_HEAD_AKA);
//        ArrayList AKAList = new ArrayList();
//        for(int x=0;x< AKAs.length();x++){
//            AKAList.add(AKAs.getString(x));
//        }
//        currmovie.setAlsoKnownAs(AKAList);
        return currmovie;
    }
}
