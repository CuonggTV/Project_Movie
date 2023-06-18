package gui;

import core.User;
import core.UserList;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        UserList userlist = new UserList();
        userlist.register();
        userlist.writeToFile();
        User loginUser = userlist.login();
        if(loginUser == null)
        {
            System.out.println("Login not successfully");
        } else
        {
            System.out.println("Login successfully!");
            System.out.println("Hello " + loginUser.getFullName());
        }
    }

}
