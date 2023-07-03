package core;

import utils.MyUtil;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        UserList userList = new UserList();
        userList.readFromFile();
        //LoginRegister
        ArrayList<String> MENU = new ArrayList<>();
        ArrayList<String> ROLE = new ArrayList<>();
        MENU.add("1. Login");
        MENU.add("2. Register");
        ROLE.add("1. Admin");
        ROLE.add("2. Customer");
        System.out.println("**Welcome to Cường Thịnh Cinema**");
        for (String s : ROLE) {
            System.out.println(s);
        }
        int choice = MyUtil.inputInteger("Who are you?", 1, 2);
        if (choice == 1)
        {
            System.out.println("Let me know more about you!");
            User admin = userList.login();
            if(admin == null) {
                System.out.println("Wrong username or password");
                System.out.println("You are an Admin, sure??");
            }
            else
            {
                System.out.println("Login success!!");
                System.out.println("Hello " + admin.getFullName() + ", have a good day! :)");
            }
        }
        if (choice == 2)
        {
            User newUser = userList.login();
            if(newUser == null) {
                System.out.println("Wrong username or password");
                System.out.println("Please login again");
            }
            else
            {
                System.out.println("Login success!!");
                System.out.println("Hello " + newUser.getFullName() + ", have a good day! :)");
            }
        }
        //Menu list
        System.out.println("Please choose your option:");
        System.out.println("===============MENU================");



    }

}
