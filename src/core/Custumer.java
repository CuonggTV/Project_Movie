package core;


import utils.MyUtil;

import java.util.ArrayList;

public class Custumer extends User{
    double wallet = 0;
    double moneyAdd;
    public Custumer(String username, String password, String fullName, String phoneNumber, String email) {
        super(username, password, fullName, phoneNumber, email);
    }

    public void showInfor()
    {
        System.out.println("Full Name: " + this.getFullName());
        System.out.println("Phone Number: " + this.getPhoneNumber());
        System.out.println("Email: " + this.getEmail());
    }

    public double addMoney()
    {
        System.out.println("Your Money: " + wallet + " VND");
        moneyAdd = MyUtil.inputDouble("How much money do you want to add?");
        wallet += moneyAdd;
        System.out.println("You have added " + moneyAdd + " VND");
        System.out.println("Your money: " + wallet + " VND");
        return 0;
    }

    public static void main(String[] args) {

    }
}
