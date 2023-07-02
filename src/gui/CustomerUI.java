package gui;

import core.*;
import utils.MyUtil;

public class CustomerUI {
    public CustomerUI(){

    }

    public User loginUI(UserList userList){
        User loginUser = null;
        int choice;

        do{
            System.out.flush();
            System.out.println("=====) CUSTOMER (=====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit to menu");
            System.out.println("======================");
            choice =MyUtil.inputInterger("Your choice: ",1,3);
            switch (choice) {
                case 1 -> loginUser=userList.login();
                case 2 -> loginUser=userList.register();
            }
        }while(loginUser==null || choice!=3);
        return loginUser;
    }
    public void CustomerMainUI(MovieList movieList,TicketList ticketList,UserList userList){
        User loginUser = loginUI(userList);
        if(loginUser==null) return;
        int choice;
        do{
            System.out.println("=====) CUSTOMER (=====");
            System.out.println("1. Show account information");
            System.out.println("2. Add Money");
            System.out.println("3. Buy movie tickets");
            System.out.println("4. Delete account");
            System.out.println("=======================");
            choice = MyUtil.inputInterger("Your choice: ",1,5);
            switch (choice){
                case 1 -> ((Customer)loginUser).showInfo();
                case 2 -> ((Customer)loginUser).addMoney();
                case 3 -> ((Customer)loginUser).buyTicket(movieList,ticketList);
                case 4 -> ((Customer)loginUser).deleteUser(userList);
            }
        }while(choice!=5);
    }
}
