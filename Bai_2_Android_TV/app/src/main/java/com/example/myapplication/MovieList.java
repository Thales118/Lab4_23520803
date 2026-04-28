package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public final class MovieList {
    public static final String MOVIE_CATEGORY[] = {"Phim Yêu Thích", "Series Mới"};
    private static List<Movie> list;
    public static List<Movie> getList() {
        if (list == null) list = setupMovies();
        return list;
    }
    public static List<Movie> setupMovies() {
        list = new ArrayList<>();
        String title[] = {"Sherlock Holmes", "Stranger Things", "Inception"};
        String studio[] = {"BBC One", "Netflix", "Warner Bros"};
        String cardUrl = "https://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review/card.jpg";

        for (int i = 0; i < title.length; i++) {
            Movie movie = new Movie();
            movie.setId(i);
            movie.setTitle(title[i]);
            movie.setStudio(studio[i]);
            movie.setCardImageUrl(cardUrl);
            movie.setBackgroundImageUrl(cardUrl);
            list.add(movie);
        }
        return list;
    }
}