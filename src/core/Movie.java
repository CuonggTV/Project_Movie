package core;

import java.io.*;

public class Movie {
    private String movieName;
    private String author;
    private String showTime;

    public Movie() {
    }

    public Movie(String movieName, String author, String showTime) {
        this.movieName = movieName;
        this.author = author;
        this.showTime = showTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
