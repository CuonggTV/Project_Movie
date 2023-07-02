package core;


import utils.MyUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User{

    public Customer(String username, String password, String fullName, String phoneNumber, String email) {
        super(username, password, fullName, phoneNumber, email);
    }

    public void showInfo()
    {
        System.out.println("Full Name: " + this.getFullName());
        System.out.println("Phone Number: " + this.getPhoneNumber());
        System.out.println("Email: " + this.getEmail());
    }

    public void addMoney()
    {
        System.out.println("Your Money: " + wallet + " VND");
        moneyAdd = MyUtil.inputDouble("How much money do you want to add?",0);
        wallet += moneyAdd;
        System.out.println("You have added " + moneyAdd + " VND");
        System.out.println("Your money: " + wallet + " VND");
    }
    private int chooseMovieAndSlot(MovieList movieList,String movieName,String slot){
        int mvPosition =movieList.findMoviePosition();
        if(mvPosition==-1) return mvPosition;
        for(String x: movieList.get(mvPosition).getShowTime()){
            System.out.println(x);
        }
        int slotChosen = MyUtil.inputInterger("Choose slot: ",1,movieList.get(mvPosition).getShowTime().size());

        movieName = movieList.get(mvPosition).getMovieName();
        slot = movieList.get(mvPosition).getShowTime().get(slotChosen);
        return mvPosition;
    }


    private ArrayList<Integer> chooseSeat(int [][]a){
        Scanner sc= new Scanner(System.in);
        ArrayList<Integer> ticketBought = new ArrayList<>();
        do{
            String []seatNum= sc.nextLine().split(" ");
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
        System.out.println("Bought successfully!");
        return ticketBought;
    }

    public void buyTicket(MovieList movieList, TicketList ticketList){
        //Choose movie
        String movieName="",slot="";
        int mvPostion = chooseMovieAndSlot(movieList,movieName,slot);
        if(mvPostion==-1) return;

        //Show seats and choose seats
        int[][] a = ticketList.showAndReturn_SeatsMap(movieName,slot);
        ArrayList<Integer> ticketBought = chooseSeat(a);
        if(ticketBought==null) return;


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
    public void deleteUser(UserList userList){
        for (int i=0;i<userList.size();i++){
            if(userList.get(i).getUsername().equals(getUsername())){
                userList.remove(i);
            }
        }
    }
}
