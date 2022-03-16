package com.example.volley_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MoviedetailsActivity extends AppCompatActivity {
    ImageView movie_image;
    TextView movie_name,movie_votes,movie_popularities,movie_overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviedetails);
        movie_image=findViewById(R.id.movie_image);
        movie_name=findViewById(R.id.movie_name);
        movie_popularities=findViewById(R.id.movie_popularities);
        movie_votes=findViewById(R.id.movie_votes);
        movie_overview=findViewById(R.id.movie_overview);

        Bundle bundle = getIntent().getExtras();

        String title = bundle.getString("title");
        String vote_average = bundle.getString("vote_average");
        String popularity = bundle.getString("popularity");
        String overview = bundle.getString("overview");
        String poster_path = bundle.getString("poster_path");

        Glide.with(this).load("https://www.themoviedb.org/t/p/w1280"+poster_path).into(movie_image);
        movie_name.setText(title);
        movie_votes.setText(vote_average);
        movie_popularities.setText(popularity);
        movie_overview.setText(overview);

    }
}