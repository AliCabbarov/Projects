package util;

import static util.InputUtil.*;

public class MenuUtil {
    public static byte entryMenu() {
        System.out.println(
                "[0]. Exit System\n" +
                        "[1]. Register\n" +
                        "[2]. Search\n" +
                        "[3]. Show\n" +
                        "[4]. Update\n" +
                        "[5]. Delete\n" +
                        "[6]. Storage to stock\n" +
                        "[7]. Admin Service"
        );
        return inputByte("choose option: ");
    }

    public static byte viewMenu() {
        System.out.println(
                "[1]. to see what's in base\n" +
                        "[2]. to see what's in stock"
        );
        return inputByte("choose option: ");
    }
    public static String updateMenu(){
        System.out.println(
                "name\n" +
                        "author\n" +
                        "genre\n" +
                        "pageCount\n" +
                        "language\n" +
                        "price\n" +
                        "count"
        );
        return inputString("write update field\n" +
                "for more option write like this (exp: name,author): ");
    }
    public static byte SearchMenu(){
        System.out.println(
                "[1]. by name\n" +
                        "[2]. by authorName\n" +
                        "[3]. by genre"
        );
        return inputByte("choose option: ");
    }
    public static byte entryMenuCustomer(){
        System.out.println(
                "[0]. Exit System\n" +
                        "[1]. Register\n" +
                        "[2]. Search\n" +
                        "[3]. Show\n" +
                        "[4]. Update\n" +
                        "[5]. Delete\n" +
                        "[6]. Login\n" +
                        "[7]. Admin Service"
        );
        return inputByte("choose option: ");
    }
    public static byte adminEntryMenu(){
        System.out.println(
                "[0]. Exit System\n" +
                        "[1]. BookService\n" +
                        "[2]. CustomerService\n"
        );
        return inputByte("choose option: ");
    }

}
