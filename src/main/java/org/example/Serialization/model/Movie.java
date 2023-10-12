package org.example.Serialization.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private String name;
    private double duration;
    private String director;

    public Movie(String name, double duration, String director) {
        this.name = name;
        this.duration = duration;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    public String getDirector() {
        return director;
    }
}
