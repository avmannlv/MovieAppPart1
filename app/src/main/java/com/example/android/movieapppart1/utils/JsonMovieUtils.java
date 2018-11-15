/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.movieapppart1.utils;

import android.content.Context;

import com.example.android.movieapppart1.model.movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

/**
 * Utility functions to handle OpenMovieMap JSON data.
 */
public final class JsonMovieUtils {

    /**
     * This method parses JSON from a web response and returns an array of Strings
     * describing the Movie over various days from the forecast.
     * <p/>
     * Later on, we'll be parsing the JSON into structured data within the
     * getFullMovieDataFromJson function, leveraging the data we have stored in the JSON. For
     * now, we just convert the JSON into human-readable strings.
     *
     * @param MovieListJsonStr JSON response from server
     *
     * @return Array of Strings describing Movie data
     *
     * @throws JSONException If JSON data cannot be properly parsed
     */
    public static movie[] getSimpleMovieStringsFromJson(Context context, String MovieListJsonStr)
            throws JSONException {

        final String OWM_LIST = "results";
        final String FD_PAGE_NUM = "page";
        final String FD_RECORD_COUNT = "total_results";
        final String FD_PAGES = "total_pages";

        final String FD_RATING = "vote_average";
        final String FD_TITLE = "title";
        final String FD_POSTER_PATH = "poster_path";
        final String FD_SYNOPSIS = "overview";
        final String FD_RELEASE_DATE = "release_date";
//        final String FD_POPULARITY = "popularity";
//        final String FD_LANGUAGE = "original_language";
//        final String FD_ORIG_TITLE = "original_title";
//        final String FD_GENRE_IDS = "genre_ids";
//        final String FD_BACKDROP_PATH = "backdrop_path";
//        final String FD_IS_ADULT = "adult";

        final String OWM_MESSAGE_CODE = "cod";

        /* String array to hold each day's Movie String */
        movie[] parsedMovieData = null;

        JSONObject movieJson = new JSONObject(MovieListJsonStr);

        /* Is there an error? */
        if (movieJson.has(OWM_MESSAGE_CODE)) {
            int errorCode = movieJson.getInt(OWM_MESSAGE_CODE);

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

        JSONArray MovieArray = movieJson.getJSONArray(OWM_LIST);

//        parsedMovieData = new String[MovieArray.length()];
        parsedMovieData = new movie[MovieArray.length()];

//        long localDate = System.currentTimeMillis();
//        long utcDate = SunshineDateUtils.getUTCDateFromLocal(localDate);
//        long startDay = SunshineDateUtils.normalizeDate(utcDate);

        for (int i = 0; i < MovieArray.length(); i++) {

//            String date;
//            String highAndLow;

            /* These are the values that will be collected */
//            long dateTimeMillis;
//            double high;
//            double low;
//            String description;

            /* Get the JSON object representing the day */
            JSONObject currMovie = MovieArray.getJSONObject(i);
            parsedMovieData[i].settitle(currMovie.getString(FD_TITLE));
            parsedMovieData[i].setsynopsis(currMovie.getString(FD_SYNOPSIS));
            parsedMovieData[i].setreleaseDate(currMovie.getString(FD_RELEASE_DATE));
            parsedMovieData[i].setImage(currMovie.getString(FD_POSTER_PATH));
            parsedMovieData[i].setrating(currMovie.getInt(FD_RATING));


//
//            /*
//             * We ignore all the datetime values embedded in the JSON and assume that
//             * the values are returned in-order by day (which is not guaranteed to be correct).
//             */
//            dateTimeMillis = startDay + SunshineDateUtils.DAY_IN_MILLIS * i;
//            date = SunshineDateUtils.getFriendlyDateString(context, dateTimeMillis, false);
//
//            /*
//             * Description is in a child array called "Movie", which is 1 element long.
//             * That element also contains a Movie code.
//             */
//            JSONObject MovieObject =
//                    currMovie.getJSONArray(OWM_Movie).getJSONObject(0);
//            description = MovieObject.getString(OWM_DESCRIPTION);
//
//            /*
//             * Temperatures are sent by Open Movie Map in a child object called "temp".
//             *
//             * Editor's Note: Try not to name variables "temp" when working with temperature.
//             * It confuses everybody. Temp could easily mean any number of things, including
//             * temperature, temporary and is just a bad variable name.
//             */
//            JSONObject temperatureObject = currMovie.getJSONObject(FD_PAGE_NUM);
//            high = temperatureObject.getDouble(FD_RECORD_COUNT);
//            low = temperatureObject.getDouble(FD_PAGES);
//            highAndLow = SunshineMovieUtils.formatHighLows(context, high, low);
//
//            parsedMovieData[i] = date + " - " + description + " - " + highAndLow;
        }
        return parsedMovieData;
    }

    /**
     * Parse the JSON and convert it into ContentValues that can be inserted into our database.
     *
     * @param context         An application context, such as a service or activity context.
     * @param MovieListJsonStr The JSON to parse into ContentValues.
     *
     * @return An array of ContentValues parsed from the JSON.
     */
//    public static ContentValues[] getFullMovieDataFromJson(Context context, String MovieListJsonStr) {
//        /** This will be implemented in a future lesson **/
//        return null;
//    }
}