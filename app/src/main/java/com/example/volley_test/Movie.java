package com.example.volley_test;

public class Movie {
    String title;
    String vote_average;
    String popularity;
    String overview;
    String poster_path;


    public Movie(String title, String vote_average, String popularity, String overview, String poster_path) {
        this.title = title;
        this.vote_average = vote_average;
        this.popularity = popularity;
        this.overview = overview;
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
