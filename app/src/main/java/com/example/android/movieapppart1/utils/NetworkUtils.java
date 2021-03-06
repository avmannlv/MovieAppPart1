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

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * These utilities will be used to communicate with the MOVIE servers.
 */
public final class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();

    //constants
    private static final String base_url = "http://profile_sizes.tmdb.org/t/p/";
    private static final String secure_base_url = "https://profile_sizes.tmdb.org/t/p/";
    private static final String myAPIKEY = "78d11765bbeacbce8284a78e208558c6";
    private static final String defaultSize = "w185";
    private static final String popularMoviesString = "http://api.themoviedb.org/3/movie/popular?api_key=";

    /**
     * Builds the URL used to talk to the MOVIE server using a location. This location is based
     * on the query capabilities of the MOVIE provider that we are using.
     *
     //* @param locationQuery The location that will be queried for.
     * @return The URL to use to query the MOVIE server.
     */
    public static URL buildUrl(String MovieQuery) {

        //Uri builtUri = Uri.parse(MovieQuery).buildUpon()
        //        .build();

        URL url = null;
        try {
            url = new URL(MovieQuery);
            //url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);

        return url;
    }

    /**
     * Builds the URL used to talk to the MOVIE server using latitude and longitude of a
     * location.
     *
     * @param lat The latitude of the location
     * @param lon The longitude of the location
     * @return The Url to use to query the MOVIE server.
//     */
//    public static URL buildUrl(Double lat, Double lon) {
//        /** This will be implemented in a future lesson **/
//        return null;
//    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}