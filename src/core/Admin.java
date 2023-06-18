package core;

import utils.MyUtil;

public class Admin extends User {
    public Admin(String username, String password, String fullName, String phoneNumber, String email) {
        super(username, password, fullName, phoneNumber, email);
    }

    public void createMovie(MovieList mv){
        boolean loop = false;
        String movieName,author,showTime;
        double price;

        do{
            loop = false;
            System.out.flush();
            movieName = MyUtil.inputString("Enter movie name: ");
            author = MyUtil.inputString("Enter author: ");
            showTime = MyUtil.inputString("Enter show time: ");
            price = MyUtil.inputDouble("Enter ticket price: ");

            //Check movie
            for(Movie mvt : mv){
                if(mvt.getMovieName().equals(movieName)) {
                    loop = true;
                    System.out.println("This movie is already on air!");
                    break;
                }
            }
            //Check author
            if(!author.matches("[a-zA-Z]+")){
                loop = true;
                System.out.println("Author just contains alphabet");
            }
        }while(loop);
        Movie newMovie = new Movie(movieName,author,showTime,price);
        mv.add(newMovie);
    }
}
