package org.example.Serialization.model;
import org.example.Serialization.model.Movie;
import org.example.Serialization.model.Theater;

import java.io.Serializable;

public class Session implements Serializable {
    private int hour;

    private Movie movie;

    private Theater theater;

    public Session(int hour, Movie movie, Theater theater) {
        this.hour = hour;
        this.movie = movie;
        this.theater = theater;
    }

    public int getHour() {
        return hour;
    }
}
