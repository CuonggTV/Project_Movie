package core;


public class Customers extends User {
    double wallet = 0;
    double moneyAdd;

    public Customers(String username, String password, String fullName, String phoneNumber, String email, double wallet, double moneyAdd) {
        super(username, password, fullName, phoneNumber, email);
        this.wallet = wallet;
        this.moneyAdd = moneyAdd;
    }

    public void showInfor() {
        System.out.println("Full Name: " + this.getFullName());
        System.out.println("Phone Number: " + this.getPhoneNumber());
        System.out.println("Email: " + this.getEmail());
    }
}

//    public double addMoney()
//    {
//        System.out.println("Your Money: " + wallet + " VND");
//        moneyAdd = MyUtil.inputDouble("How much money do you want to add?");
//        wallet += moneyAdd;
//        System.out.println("You have added " + moneyAdd + " VND");
//        System.out.println("Your money: " + wallet + " VND");
//        return 0;
//    }

