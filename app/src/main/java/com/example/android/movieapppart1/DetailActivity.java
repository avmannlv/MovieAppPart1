package com.example.android.movieapppart1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.movieapppart1.model.movie;
import com.example.android.movieapppart1.model.tmdb;
import com.example.android.movieapppart1.utils.JsonUtils;
import com.example.android.movieapppart1.utils.NetworkUtils;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

public class DetailActivity extends AppCompatActivity {

    public static final String MOVIE_ID_EXTRA = "MOVIE_ID";
    public String movieIDValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);




        //find thumb variable
//        ImageView movieThumb = (ImageView) findViewById(R.id.iv_detail_thumbnail);

//        Intent intent = getIntent();
//        if (intent == null) {
//            closeOnError();
        }
        //get movie information from MainActivity
//        String movieTitle = intent.getStringExtra(MOVIE_ID_EXTRA, movieIDValue);
//        if (!movieTitle) {
//            // no movie title passed
//            closeOnError();
//            return;
//        }

//        String[] movie = getResources().getStringArray(R.array.movie_details);
//        String json = movie[position];
//        movie movie = null;
//        try {
//            movie = JsonUtils.parsemovieJson(json);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        if (movie == null) {
//            // movie data unavailable
//            closeOnError();
//            return;
//        }

//        populateUI(movie);
//        Picasso.with(this)
//                .load(movie.getImage())
//                .placeholder(R.drawable.placeholderimage)
//                .error(R.drawable.placeholderimage)
//                .into(ingredientsIv);
//
//        setTitle(movie.getMainName());
    }

//    private void closeOnError() {
//        finish();
//        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
//    }

//    private void populateUI(movie currmovie) {
//        ImageView iv_thumb = (ImageView) findViewById(R.id.iv_detail_thumbnail);
//        TextView tv_synopsis = (TextView) findViewById(R.id.tv_synopsis);
//        TextView tv_ReleaseDate = (TextView) findViewById(R.id.tv_release_date);
//        TextView tv_Rating = (TextView) findViewById(R.id.tv_rating);
//        StringBuilder sb = new StringBuilder();
//        String ingredientList = "";
//        if(!currmovie.getImage().isEmpty()){
//            Picasso.with(this).load(currmovie.getImage()).into(iv_thumb);
//        }
//        StringBuilder sb2 = new StringBuilder();
//        String AKAList = "";
//        if(!currmovie.getAlsoKnownAs().isEmpty()) {
//            for (String AKA : currmovie.getAlsoKnownAs()) {
//                sb2.append(AKA).append(", ");
//                //AKAList += AKA + " ";
//            }
//            AKAList = sb2.deleteCharAt(sb2.length() - 2).toString();
//        }
//        descText.setText(currmovie.getDescription());
//        AKAText.setText(AKAList);
//        OriginText.setText(currmovie.getPlaceOfOrigin());
//        IngredientsText.setText(ingredientList);
//    }
//}
