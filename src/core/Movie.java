package core;

import utils.MyUtil;

import java.util.ArrayList;
import java.util.Calendar;

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
        do{
            author = MyUtil.inputString("New author: ");
            if(!author.matches("[a-zA-Z\\t]+")){
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
        String result;
        do{
            String date = MyUtil.inputDate();
            if(date == null) return;
            int slot = MyUtil.inputInteger("Enter slot: ", 1, 5);
            result = date+ "/" + slot;
            if (!checkTimeAgainstCurrentTime(result)){
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

    public boolean checkTimeAgainstCurrentTime(String time){
        String []elements = time.split("/");
        int day = Integer.parseInt(elements[0]);
        int month = Integer.parseInt(elements[1]);
        int slot = Integer.parseInt(elements[2]);

        Calendar calendar = Calendar.getInstance();
        int curDay = calendar.get(Calendar.DATE);
        int curMonth = calendar.get(Calendar.MONTH);
        int curHour = calendar.get(Calendar.HOUR_OF_DAY);

        if(day < curDay || month < curMonth) return false;
        else if(day>curDay) return true;


        if(slot == 1 && curHour < 7) return true;
        else if(slot == 2 && curHour < 10) return true;
        else if(slot == 3 && curHour < 13) return true;
        else if(slot == 4 && curHour < 16) return true;
        else return slot == 5 && curHour < 19;
    }
}
