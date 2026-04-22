package Game;

import java.util.Scanner;

public class ErrorCheck {

    public static int getInt(Scanner sc) {
        {
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Enter a number:");
                sc.next(); // clear bad input
            }
            return sc.nextInt();
        }
    }
}