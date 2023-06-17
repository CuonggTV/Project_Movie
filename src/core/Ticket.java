package core;

public class Ticket {
    private String movieName;
    private String userName;
    private String seatNumber;
    private String showTime;

    public Ticket() {
    }

    public Ticket(String movieName, String userName, String seatNumber, String showTime) {
        this.movieName = movieName;
        this.userName = userName;
        this.seatNumber = seatNumber;
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

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
