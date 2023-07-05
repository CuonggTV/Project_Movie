package core;

import utils.MyUtil;

public class Admin  {
    public static String PASSWORD = "12345";
    public Admin() {
    }

    public void createMovie(MovieList mv){
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
        int choice;
        do{
            System.out.flush();
            movieList.showMovieInfo(mvPostion);

            System.out.println("1. Update movie name");
            System.out.println("2. Update author");
            System.out.println("3. Update price");
            System.out.println("4. Update showtime");
            System.out.println("5. Delete showtime");
            System.out.println("6. Never mind");
            choice = MyUtil.inputInteger("Your choice: ",1,6);

            System.out.flush();
            switch (choice) {
                case 1 -> movieList.get(mvPostion).setMovieName(movieList);
                case 2 -> movieList.get(mvPostion).setAuthor();
                case 3 -> movieList.get(mvPostion).setPrice(MyUtil.inputDouble("New price: ", 0));
                case 4 -> movieList.get(mvPostion).changeShowtime();
                case 5 -> {
                    int slotToRemove = MyUtil.inputInteger("Choose movie slot to remove: ",
                            0, movieList.get(mvPostion).getShowTime().size() - 1);
                    movieList.get(mvPostion).getShowTime().remove(slotToRemove);
                }
            }
        }while (choice!=6);
    }
    public void deleteMovie(MovieList movieList, TicketList ticketList,UserList userList){
        int mvPosition = movieList.findMoviePosition();
        if (mvPosition==-1) return;
        //Refund cho ng dung

        //Xoa ticket
        for(int i=0;i<ticketList.size();i++){
            if(ticketList.get(i).getMovieName().equals(movieList.get(mvPosition).getMovieName())){
                //Refund cho ng dung
                for(int j=0;i<userList.size();i++){
                    if(ticketList.get(i).getUserName().equals(userList.get(j).getUsername())){
                        double pricePerTicket = movieList.get(mvPosition).getPrice();
                        double seatOrdered = ticketList.get(mvPosition).getSeatOrdered().size();
                        userList.get(j).setWallet(userList.get(j).getWallet() + pricePerTicket * seatOrdered);
                        break;
                    }
                }
                ticketList.remove(i);
                i--;
            }
        }
        movieList.remove(mvPosition);
    }
}
