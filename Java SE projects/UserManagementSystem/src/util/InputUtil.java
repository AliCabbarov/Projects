package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    public static byte inputByte(String title)  {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextByte();
    }
    public static String inputString(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextLine();
    }
    public static int inputInt(String title) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(title);
        return scanner.nextInt();
    }

}
