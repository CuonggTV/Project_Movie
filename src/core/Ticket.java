package core;

import java.util.ArrayList;

public class Ticket {
    private String movieName;
    private String userName;
    private ArrayList<Integer> seatOrdered = new ArrayList<>();
    private String showTime;

    public Ticket() {
    }

    public Ticket(String movieName, String userName,String showTime,ArrayList<Integer> seatOrdered) {
        this.movieName = movieName;
        this.userName = userName;
        this.seatOrdered = seatOrdered;
        this.showTime = showTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Integer> getSeatOrdered() {
        return seatOrdered;
    }

    public void setSeatOrdered(ArrayList<Integer> seatOrdered) {
        this.seatOrdered = seatOrdered;
    }

    public void addSeatOrdered(){

    }
    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
