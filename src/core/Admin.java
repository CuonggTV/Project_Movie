package core;

import utils.MyUtil;

public class Admin extends User {
    public Admin(String username, String password, String fullName, String phoneNumber, String email) {
        super(username, password, fullName, phoneNumber, email);
    }

    public void createMovie(MovieList mv){
        boolean loop = false;
        String movieName,author;
        String[] showtime = new String[0];
        double price;

        do{
            loop = false;
            System.out.flush();
            movieName = MyUtil.inputString("Enter movie name: ");
            author = MyUtil.inputString("Enter author: ");
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
            //
        }while(loop);
        Movie newMovie = new Movie(movieName,author,price,null);
        mv.add(newMovie);
    }

    public void setShowTime(MovieList mv){
        int month = MyUtil.inputInterger("Enter month: ",1,12);
        int day = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> MyUtil.inputInterger("Enter day: ", 1, 31);
            case 4, 6, 9, 11 -> MyUtil.inputInterger("Enter day: ", 1, 30);
            case 2 -> MyUtil.inputInterger("Enter day: ", 1, 28);
            default -> throw new IllegalStateException("Unexpected value: " + month);
        };

        int slot=MyUtil.inputInterger("Enter slot: ",1,4);

        String st = Integer.toString(month)+"/"+Integer.toString(day)+"/"+Integer.toString(slot);

    }
}
