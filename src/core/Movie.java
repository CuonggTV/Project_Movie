package core;

import utils.MyUtil;

import java.util.ArrayList;
import java.util.Calendar;

public class Movie {
    private String movieName;
    private String author;
    private double price;
    private ArrayList<String> showTime = new ArrayList<String>();
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
        boolean loop;
        do{
            loop = false;
            movieName = MyUtil.inputString("Enter movie name: ");
            for (Movie movie : movieList) {
                if (movieName.equals(movie.getMovieName())) {
                    System.out.println("This movie is already on air!");
                    loop = true;
                }
            }
        }while(loop);
        this.movieName = movieName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor() {
        String author;
        boolean loop;
        do{
            loop = false;
            author = MyUtil.inputString("New author: ");
            String []letters = author.split(" ");
            for (String letter : letters) {
                if (!letter.matches("^[A-Z]{1}[a-z]+")) {
                    System.out.println("Author just contains alphabet and has a capital at the start letter!");
                    System.out.println("Please enter again.");
                    loop = true;
                    break;
                }
            }
        }while(loop);
        this.author =author;
    }

    public ArrayList<String> getShowTime() {
        return showTime;
    }

    public void setShowTime() {
        String result;
        do{
            String date = MyUtil.inputDate();
            if(date == null) return;
            int slot = MyUtil.inputInteger("Enter slot: ", 1, 5);
            result = date+ "/" + slot;
            if (MyUtil.checkTimeAgainstCurrentTime(result)){
                System.out.println("This time is outdated!");
                continue;
            }
            break;
        }while (true);
        this.showTime.add(result);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void changeShowtime(){
        int timeChoice = MyUtil.inputInteger("Choose your time: ",1,this.getShowTime().size());
        String date = this.getShowTime().get(timeChoice-1);
        if(date ==null) return;

        //Check xem đã có date này chưa
        //Có thì tiếp tục
        //ko thì quay lại
        for (int i=0;i<showTime.size();i++){
            if(showTime.get(i).equals(date)){
                int slot = MyUtil.inputInteger("Enter new slot: ", 1, 4);
                date += "/"+slot;
                showTime.set(i,date);
                return;
            }
        }
        System.out.println("This time is unscheduled");
        changeShowtime();
    }


}
