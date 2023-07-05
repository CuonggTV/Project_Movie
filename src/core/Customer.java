package core;

import utils.MyUtil;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Customer extends User{
    public Customer(String username, String password, String fullName, String phoneNumber, String email,double wallet) {
        super(username, password, fullName, phoneNumber, email,wallet);
    }

    public void showInfo(UserList userList)
    {
        int pos = userList.findUserPosition(getUsername());
        System.out.println("Username: " + userList.get(pos).getUsername());
        System.out.println("Full Name: " + userList.get(pos).getFullName());
        System.out.println("Phone Number: " + userList.get(pos).getPhoneNumber());
        System.out.println("Email: " + userList.get(pos).getEmail());
        System.out.println("Wallet: " + userList.get(pos).getWallet() +"$");
    }

    private int chooseMovieAndSlot(MovieList movieList){
        int mvPosition =movieList.findMoviePosition();
        if(mvPosition==-1) return mvPosition;
        if(movieList.get(mvPosition).getShowTime()!=null){
            movieList.showMovieInfo(mvPosition);
        }
        else {
            System.out.println("This film hasn't had showtime yet!");
            return -1;
        }
        return mvPosition;
    }

    public void updateCustomer(UserList userList){
        int pos = userList.findUserPosition(getUsername());
        int choice;
        do{
            System.out.flush();
            System.out.println("1. Update username");
            System.out.println("2. Update password");
            System.out.println("3. Update full name");
            System.out.println("4. Update phone number");
            System.out.println("5. Update email");
            System.out.println("6. Add money");
            System.out.println("7. Never mind");
            choice = MyUtil.inputInteger("Your choice: ",1,7);

            System.out.flush();
            switch (choice) {
                case 1 -> userList.get(pos).setUsername();
                case 2 -> userList.get(pos).setPassword();
                case 3 -> userList.get(pos).setFullName();
                case 4 -> userList.get(pos).setPhoneNumber();
                case 5 -> userList.get(pos).setEmail();
                case 6 -> userList.get(pos).addMoney();
            }
        }while (choice!=7);
    }

    private ArrayList<Integer> chooseSeat(int [][]a){
        ArrayList<Integer> ticketBought = new ArrayList<>();
        do{
            String input = MyUtil.inputString("Choose your seat (row column, ex: 11): ");
            String []seatNum= input.split(" ");
            try{
                for (String s : seatNum) {
                    int tkResult = Integer.parseInt(s);
                    int row = tkResult / 10;
                    int column = tkResult % 10;
                    if (tkResult < 11 || tkResult > 99 || tkResult % 10 == 0) {
                        throw new NumberFormatException();
                    }
                    if (a[row][column] == 1) {
                        throw new Exception();
                    }
                    ticketBought.add(tkResult);
                }
            }
            catch (NumberFormatException e){
                if (!MyUtil.continueAfterWrongInput("Uncorrected ticket form!"))
                    return null;
                continue;
            }
            catch (Exception e){
                if(!MyUtil.continueAfterWrongInput("This ticket have been bought!"))
                    return null;
                continue;
            }
            break;
        }while(true);
        return ticketBought;
    }

    public void buyTicket(MovieList movieList, TicketList ticketList,UserList userList){
        //Choose movie
        String movieName,slot;
        movieList.showAllMoviesInfo();
        int mvPosition = chooseMovieAndSlot(movieList);
        if(mvPosition==-1) return;
        movieName = movieList.get(mvPosition).getMovieName();
        int slotChosen = MyUtil.inputInteger("Choose slot: ",1,movieList.get(mvPosition).getShowTime().size());
        slot = movieList.get(mvPosition).getShowTime().get(slotChosen-1);
        double price = movieList.get(mvPosition).getPrice();

        //Show seats and choose seats
        int[][] a = ticketList.showAndReturn_SeatsMap(movieName,slot);
        System.out.println("Price per ticket: "+price);
        ArrayList<Integer> ticketBought = chooseSeat(a);
        if(ticketBought==null) return;

        //Thanh toan ve
        price = price*ticketBought.size();
        int pos = userList.findUserPosition(getUsername());
        System.out.println("Total price: "+price+ "$");
        System.out.println("Your wallet: "+getWallet()+"$");

        if(userList.get(pos).getWallet() < price){
            System.out.println("You don't have enough money!");
            return;
        }
        else{
            if(!MyUtil.continueAfterWrongInput("Do you want to pay?")){
                return;
            }
            userList.get(pos).setWallet(userList.get(pos).getWallet()-price);
            System.out.println("Bought successfully!");
        }


        //TH dat them ticket
        //Tim trong ticketList : Movie Name, username, show time
        for (Ticket ticket : ticketList) {
            if (ticket.getMovieName().equals(movieName)) {
                if (ticket.getUserName().equals(getUsername())) {
                    if (ticket.getShowTime().equals(slot)) {
                        ticket.getSeatOrdered().addAll(ticketBought);
                        return;
                    }
                }
            }
        }
        //TH dat moi ticket
        Ticket newTicket = new Ticket(movieName,getUsername(),slot,ticketBought);
        ticketList.add(newTicket);
    }
    public void deleteUser(UserList userList,TicketList ticketList){

        if(!MyUtil.continueAfterWrongInput("Are you sure to delete this account?")){
            return;
        }
        //Xoa ve da mua
        for(int i=0;i<ticketList.size();i++){
            if(ticketList.get(i).getUserName().equals(getUsername())){
                ticketList.remove(i);
                i--;
            }
        }

        //Xoa ng dung
        for (int i=0;i<userList.size();i++){
            if(userList.get(i).getUsername().equals(getUsername())){
                userList.remove(i);
                i--;
            }
        }
    }

    public void refundTicket(TicketList ticketList, MovieList movieList){
       ticketList.showTicket(this.getUsername());
       String movieName,showtime;
       int refundPosition = 0;
       int numberOfSeatRefund = 0;

       do{
           movieName = MyUtil.inputString("Enter movie name");
           showtime = MyUtil.inputString("Enter your time (dd/mm/slot)");
           refundPosition=ticketList.findTicket(movieName,showtime);
           if(refundPosition==-1){
               if(!MyUtil.continueAfterWrongInput("You haven't bought this film yet!")) return;
           }

       }while(refundPosition!=-1);

       boolean loop;
       do {
           loop=false;
           String []seats = MyUtil.inputString("Which seats you want to refund?").split(" ");
           for(String x: seats){
               int seat = 0;
               try {
                   seat = Integer.parseInt(x);
                   if (seat <=10 || seat>=100 ||seat%10==0) throw new NumberFormatException();
               }
               catch(NumberFormatException e){
                   System.out.println("Wrong seat format!");
                   loop=true;
               }
               for (int i =0;i<ticketList.get(refundPosition).getSeatOrdered().size();i++){
                   if(ticketList.get(refundPosition).getSeatOrdered().get(i) == seat){
                       ticketList.get(refundPosition).getSeatOrdered().remove(i);
                       numberOfSeatRefund++;
                   }
               }
           }
       }while(loop);
       //Refund
        for (Movie movie:movieList){
            if(movie.getMovieName().equals(movieName)){
                wallet += (movie.getPrice()*numberOfSeatRefund)/2;
            }
        }
    }
}
