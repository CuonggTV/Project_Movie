package utils;

import java.util.Scanner;

public class MyUtil {
    public static String inputString(String message) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(message);
            String value = sc.nextLine();
            if(!value.isEmpty()) {
                return value;
            }
            System.out.println("Value can not be empty!");
        } while (true);
    }
}
