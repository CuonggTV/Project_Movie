package core;

import utils.MyUtil;

import java.io.*;
import java.util.ArrayList;

public class Movie {
    private String movieName;
    private String author;
    private double price;
    private ArrayList<String> showTime = new ArrayList<>();
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

    public void setMovieName(MovieList movieList) {
        String movieName;
        do{
            movieName = MyUtil.inputString("Enter movie name: ");
            for (int i = 0; i < movieList.size(); i++) {
                if (movieName.equals(movieList.get(i).getMovieName())) {
                    break;
                }
            }
            break;
        }while(true);
        this.movieName = movieName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor() {
        String author;
        do{
            author = MyUtil.inputString("New author: ");
            if(!author.matches("[a-zA-Z]+")){
                System.out.println("Author just contains alphabet!");
                System.out.println("Please enter again.");
                continue;
            }
            break;
        }while(true);
        this.author =author;
    }

    public ArrayList<String> getShowTime() {
        return showTime;
    }

    public void setShowTime() {
        String date = MyUtil.inputDate();
        if(date == null) return;
        int slot = MyUtil.inputInterger("Enter slot: ", 1, 4);
        this.showTime.add(date+ "/" + Integer.toString(slot));
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void changeShowtime(){
        int timeChoice = MyUtil.inputInterger("Choose your time: ",0,this.getShowTime().size()-1);
        String date = MyUtil.inputDate();
        if(date ==null) return;

        //Check xem đã có date này chưa
        //Có thì tiếp tục
        //ko thì quay lại
        for (int i=0;i<showTime.size();i++){
            if(showTime.get(i).equals(date)){
                int slot = MyUtil.inputInterger("Enter slot: ", 1, 4);
                date += "/"+Integer.toString(slot);
                showTime.set(i,date);
                return;
            }
        }
        System.out.println("This time is unscheduled");
        changeShowtime();
    }
    public void removeShowTime(int pos){
        showTime.remove(pos);
    }
}
