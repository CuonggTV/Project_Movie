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
                double wallet = Double.parseDouble(row[5]);
                User user = new User(username, password, fullName, phoneNumber, email, wallet);
                this.add(user);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToFile() throws FileNotFoundException {
        File file = new File(FILENAME);
        PrintWriter out = new PrintWriter(file);
        out.println("Username, Password, Full name, PhoneNumber, Email, Wallet");
        for (User user : this) {
            out.println(user.getUsername() + ", " + user.getPassword() + ", " + user.getFullName() + ", " + user.getPhoneNumber() + ", " + user.getEmail()+", "+user.wallet);
        }
        out.flush();
        out.close();
    }

    public User login() {
        String username = MyUtil.inputString("Enter your username: ");
        String password = MyUtil.inputString("Enter your password: ");
        for (User user : this) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successfully");
                return user;
            }
        }
        System.out.println("Your username or password is wrong.");
        return null;
    }
    public User register() {
        User newUser = new User();

        newUser.setFullName();
        newUser.setPassword();
        newUser.setFullName();
        newUser.setPhoneNumber();
        newUser.setEmail();

        this.add(newUser);
        System.out.println("Register successfully!");
        return newUser;
    }

    public int findUserPosition(String username){
        for(int i=0;i<this.size();i++){
            if (this.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }
}
