package utils;

import java.util.Scanner;

public class MyUtil {
    public static String inputString(String message) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(message);
            String value = sc.nextLine();
            if(!value.isEmpty()) {
                value = value.trim();
                return value;
            }
            System.out.println("Value can not be empty!");
        } while (true);
    }

    public static Double inputDouble(String message){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(message);
            String value = sc.nextLine();
            value = value.trim();

            if(!value.isEmpty() && !value.matches("")) {
                if(value.matches("[0-9]+") || value.matches("[0-9]+.[0-9]+")){
                    return Double.parseDouble(value);
                }
            }
            System.out.println("Value must be a number!");
        } while (true);
    }
}

