package gui;

import core.MovieList;
import core.TicketList;
import core.UserList;
import utils.MyUtil;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        UserList userList = new UserList();
        MovieList movieList = new MovieList();
        TicketList ticketList = new TicketList();
        int choice;

        //Get data
        movieList.readMovie();
        userList.readFromFile();
        ticketList.readTicket();

        do{
            System.out.flush();
            System.out.println("====================");
            System.out.println("1. Log in as User");
            System.out.println("2. Log in as Admin");
            System.out.println("3. Exit");
            System.out.println("====================");
            choice = MyUtil.inputInterger("Your choice: ",1,3);
            switch (choice){
                case 1 -> {
                    CustomerUI customerUI = new CustomerUI();
                    customerUI.CustomerMainUI(movieList,ticketList,userList);
                }
                case 2 -> {
                    AdminUI adminUI = new AdminUI();
                    if(adminUI.enterPassword()){
                        adminUI.AdminMainUI(movieList);
                    }
                }

            }
        }while(choice!=3);
        movieList.writeToFile();
    }



}
