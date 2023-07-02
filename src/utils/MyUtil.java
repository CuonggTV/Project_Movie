package utils;

import java.util.Scanner;

public class MyUtil {
    public static String inputString(String message) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(message);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("Value can not be empty!");
        } while (true);
    }

    public static Double inputDouble(String message,int min) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(message);
            double value = Double.parseDouble(sc.nextLine());

            if (value >= min) {
                return value;
            }
            System.out.println("Value must be a number!");
        } while (true);
    }

    public static Integer inputInterger(String message, int min, int max) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(message);
            int value = Integer.parseInt(sc.nextLine());
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Value must be in range of " + min + " and " + max);
        } while (true);
    }

    public static boolean continueAfterWrongInput(String message) {
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.println(message);
        System.out.println("Continue: enter 1.");
        choice = sc.nextLine().trim();
        return choice.equals("1");
    }

    public static String inputDate(){
        int month,day;
        do{
            System.out.flush();
            month = MyUtil.inputInterger("Enter month: ", 1, 12);
            day = switch (month) {
                case 1, 3, 5, 7, 8, 10, 12 -> MyUtil.inputInterger("Enter day: ", 1, 31);
                case 4, 6, 9, 11 -> MyUtil.inputInterger("Enter day: ", 1, 30);
                case 2 -> MyUtil.inputInterger("Enter day: ", 1, 28);
                default -> -1;
            };
            if(day==-1){
                if(!MyUtil.continueAfterWrongInput("Date not valid!")){
                    return null;
                }
            }
        }while(day==-1);
        return  Integer.toString(day) + "/" + Integer.toString(month);
    }
}