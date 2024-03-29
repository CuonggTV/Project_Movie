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
            choice =MyUtil.inputInteger("Your choice: ",1,3);
            switch (choice) {
                case 1 -> loginUser=userList.login();
                case 2 -> loginUser=userList.register();
            }
        }while(loginUser==null && choice!=3);
        return loginUser;
    }
    public void CustomerMainUI(MovieList movieList,TicketList ticketList,UserList userList){
        User loginUser = loginUI(userList);
        if(loginUser==null) return;
        Customer customer = new Customer(loginUser.getUsername(), loginUser.getPassword(), loginUser.getFullName(), loginUser.getPhoneNumber(), loginUser.getEmail(), loginUser.getWallet());
        int choice;
        do{
            System.out.println("========) CUSTOMER (========");
            System.out.println("1. Show account information.");
            System.out.println("2. Update account.");
            System.out.println("3. Buy movie tickets.");
            System.out.println("4. Refund tickets.");
            System.out.println("5. Delete account.");
            System.out.println("6. Log out.");
            System.out.println("===========================");
            choice = MyUtil.inputInteger("Your choice: ",1,6);
            switch (choice){
                case 1 -> customer.showInfo(userList);
                case 2 -> customer.updateCustomer(userList,ticketList);
                case 3 -> customer.buyTicket(movieList,ticketList,userList);
                case 4 -> customer.refundTicket(ticketList,movieList,userList);
                case 5 -> {
                    customer.deleteUser(userList,ticketList);
                    choice = 6;
                }
            }
        }while(choice!=6);
    }
}
