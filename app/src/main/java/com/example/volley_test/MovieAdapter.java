package com.example.volley_test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    Context context;
    List<Movie> list;

    public MovieAdapter(Context context, List<Movie> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_row,parent,false);
        MovieHolder holder = new MovieHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        Movie movie = list.get(position);
        holder.popularity.setText(movie.getPopularity());
        holder.overview.setText(movie.getOverview());
        holder.title.setText(movie.getTitle());
        holder.vote_average.setText(movie.getVote_average());
        Glide.with(context).load("https://www.themoviedb.org/t/p/w1280"+movie.getPoster_path()).into(holder.poster_path);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MoviedetailsActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("title",movie.getTitle());
                bundle.putString("overview",movie.getOverview());
                bundle.putString("vote_average",movie.getVote_average());
                bundle.putString("popularity",movie.getPopularity());
                bundle.putString("poster_path",movie.getPoster_path());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {
        TextView popularity,vote_average,overview,title;
        ImageView poster_path;
        CardView card;
        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            popularity=itemView.findViewById(R.id.popularity);
            vote_average=itemView.findViewById(R.id.vote_average);
            overview=itemView.findViewById(R.id.overview);
            poster_path=itemView.findViewById(R.id.poster_path);
            title=itemView.findViewById(R.id.title);
            card=itemView.findViewById(R.id.card);

        }
    }
}
