package core;

import utils.MyUtil;

import java.io.*;
import java.util.ArrayList;

public class UserList extends ArrayList<User> {

    private static final String FILENAME = "src\\data\\user.txt";

    public void readFromFile() {
        BufferedReader reader;
        String line;
        File file = new File(FILENAME);
        if (!file.exists()) {
            System.out.println("File not exist");
            System.exit(0);
        }
        try {
            reader = new BufferedReader(new FileReader(file));
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(", ");
                String username = row[0];
                String password = row[1];
                String fullName = row[2];
                String phoneNumber = row[3];
                String email = row[4];
                User user = new User(username, password, fullName, phoneNumber, email);
                this.add(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToFile() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(FILENAME);
        out.println("username, password, fullName, phoneNumber, email");
        for (User user : this) {
            out.println(user.getUsername() + ", " + user.getPassword() + ", " + user.getFullName() + ", " + user.getPhoneNumber() + ", " + user.getEmail());
        }
    }

    public User login() {
        String username = MyUtil.inputString("Enter your username: ");
        String password = MyUtil.inputString("Enter your password: ");
        for (User user : this) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    public void register() {
//        do yourself
        String username;
        String passwork;
        String fullname;
        String email;
        String phoneNumber;
        do
        {
            username = MyUtil.inputString("Input UserName: ");
            if (username.length() > 30)
            {
                System.out.println("Invalid username. Please enter a username that is 30 characters or fewer.");
            }
        } while (username.length() > 30);

        do
        {
            passwork = MyUtil.inputString("Input PassWork: ");
            if (!passwork.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-={}\\[\\]|:;\"'<>,.?/~`]).{8,}$"))
            {
                System.out.println("Password must be at least 8 characters long and contain at least one letter, one number, and one special character. Please try again.");

            }
        } while (!passwork.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-={}\\[\\]|:;\"'<>,.?/~`]).{8,}$"));

        do
        {
            phoneNumber = MyUtil.inputString("Input phone number:");
            if(phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]{10}"))
            {
                System.out.println("Please input correctly (10 digits)");
            }
        } while (phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]{10}"));

        do
        {
            fullname = MyUtil.inputString("Input FullName: ");
            if(fullname.length() > 30)
            {
                System.out.println("Maximum 30 characters!!!");
            }
        } while (fullname.length() > 30);
        do
        {
            email = MyUtil.inputString("Input Email: ");
            if (!email.matches("^[A-Za-z0-9+_.-]+@gmail.com$"))
            {
                System.out.println("Invalid email address. Please enter an email address from the gamil.com domain.");
            }
        } while (!email.matches("^[A-Za-z0-9+_.-]+@gmail.com$"));
        User newuser = new User(username, passwork, fullname, phoneNumber, email);
        this.add(newuser);
        System.out.println("Register successfully!");
    }

}
