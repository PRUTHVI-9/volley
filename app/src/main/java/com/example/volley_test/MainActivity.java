package com.example.volley_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movie=findViewById(R.id.movie);
        movie.setLayoutManager(new LinearLayoutManager(MainActivity.this));



        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.themoviedb.org/3/movie/popular?api_key=fd606e08be09c37b963ebf8fdeebbf86", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("TAG", "onResponse: " + response );
                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    List<Movie> list = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject object=jsonArray.getJSONObject(i);
                        Log.e("TAG", "onResponse: " +object);

                        String title = object.getString("title");
                        String popularity = object.getString("vote_average");
                        String vote_average = object.getString("popularity");
                        String overview = object.getString("overview");
                        String poster_path = object.getString("poster_path");
                        list.add(new Movie(title,vote_average,popularity,overview,poster_path));
                    }
                    movie.setAdapter(new MovieAdapter(MainActivity.this,list));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "onErrorResponse: "+error.getMessage());
            }
        });
        queue.add(objectRequest);
    }
}