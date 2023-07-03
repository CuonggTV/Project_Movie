package core;

import utils.MyUtil;

public class User {
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String email;

    double wallet = 0;
    double moneyAdd;

    public User(){

    }

    public User(String username, String password, String fullName, String phoneNumber, String email, double wallet) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.wallet = wallet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        String username;
        do
        {
            username = MyUtil.inputString("Input UserName: ");
            if (username.length() > 30)
            {
                System.out.println("Invalid username. Please enter a username that is 30 characters or fewer.");
            }
        } while (username.length() > 30);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        String password;
        do
        {
            password = MyUtil.inputString("Input Password: ");
            if (!password.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-={}\\[\\]|:;\"'<>,.?/~`]).{8,}$"))
            {
                System.out.println("Password must be at least 8 characters long and contain at least one letter, one number, and one special character. Please try again.");

            }
        } while (!password.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-={}\\[\\]|:;\"'<>,.?/~`]).{8,}$"));

        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        String fullName;
        do
        {
            fullName = MyUtil.inputString("Input FullName: ");
            if(fullName.length() > 30){
                System.out.println("Maximum 30 characters!!!");
                continue;
            }
            if(!fullName.matches("[a-zA-Z\\t]+")){
                System.out.println("Full name just contains alphabet!");
                System.out.println("Please enter again.");
                continue;
            }
            break;
        } while (true);
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber() {
        String phoneNumber;
        do
        {
            phoneNumber = MyUtil.inputString("Input phone number:");
            if(phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]{10}"))
            {
                System.out.println("Please input correctly (10 digits)");
            }
        } while (phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]{10}"));
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        String email;
        do
        {
            email = MyUtil.inputString("Input Email: ");
            if (!email.matches("^[A-Za-z0-9+_.-]+@gmail.com$"))
            {
                System.out.println("Invalid email address. Please enter an email address from the gmail.com domain.");
            }
        } while (!email.matches("^[A-Za-z0-9+_.-]+@gmail.com$"));
        this.email = email;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
    public void addMoney()
    {
        System.out.println("Your Money: " + wallet + " VND");
        moneyAdd = MyUtil.inputDouble("How much money do you want to add?",0);
        wallet += moneyAdd;
        System.out.println("You have added " + moneyAdd + " VND");
        System.out.println("Your money: " + wallet + " VND");
    }
}
