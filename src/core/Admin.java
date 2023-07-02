package core;

import utils.MyUtil;

import java.util.Scanner;

public class Admin  {
    public static String PASSWORD = "12345";
    public Admin() {
    }

    public void createMovie(MovieList mv){
        boolean loop = false;
        String movieName,author;
        String[] showtime = new String[0];
        double price;
        Movie newMovie = new Movie();
        newMovie.setMovieName(mv);
        newMovie.setAuthor();
        newMovie.setPrice(MyUtil.inputDouble("Enter price: ",0));
        mv.add(newMovie);
    }

    public void addShowTime(MovieList movieList) {
        int mvPostion = movieList.findMoviePosition();
        if(mvPostion==-1) return;
        movieList.get(mvPostion).setShowTime();
    }

    public void updateMovie(MovieList movieList){
        //Find film
        int mvPostion = movieList.findMoviePosition();
        if(mvPostion==-1) return;
        //Tim
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.flush();
            movieList.showMovieInfo(mvPostion);

            System.out.println("1. Update movie name");
            System.out.println("2. Update author");
            System.out.println("3. Update price");
            System.out.println("4. Update showtime");
            System.out.println("5. Delete showtime");
            System.out.println("6. Delete movie");
            System.out.println("7. Never mind");
            choice = MyUtil.inputInterger("Your choice: ",1,6);

            System.out.flush();
            switch (choice) {
                case 1 -> movieList.get(mvPostion).setMovieName(movieList);
                case 2 -> movieList.get(mvPostion).setAuthor();
                case 3 -> movieList.get(mvPostion).setPrice(MyUtil.inputDouble("New price: ", 0));
                case 4 -> movieList.get(mvPostion).changeShowtime();
                case 5 -> {
                    int slotToRemove = MyUtil.inputInterger("Choose movie slot to remove: ",
                            0, movieList.get(mvPostion).getShowTime().size() - 1);
                    movieList.get(mvPostion).getShowTime().remove(slotToRemove);
                }
            }
        }while (choice!=6);
    }

    public void deleteMovie(MovieList movieList){
        int mvPostion = movieList.findMoviePosition();
        movieList.remove(mvPostion);
    }
}
