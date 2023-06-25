package core;

import java.io.*;
import java.util.ArrayList;

public class Movie {
    private String movieName;
    private String author;
    private double price;
    private ArrayList<String> showTime;


    public Movie() {
    }

    public Movie(String movieName, String author, double price) {
        this.movieName = movieName;
        this.author = author;
        this.price = price;
    }

    public Movie(String movieName, String author, double price, ArrayList<String> showTime) {
        this.movieName = movieName;
        this.author = author;
        this.price = price;
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

    public ArrayList<String> getShowTime() {
        return showTime;
    }

    public void setShowTime(ArrayList<String> showTime) {
        this.showTime = showTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addShowTime(String st){
        showTime.add(st);
    }
}
