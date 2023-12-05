package util;

import java.security.PublicKey;
import java.util.SortedMap;

public class MenuUtil {
    public static int entryMenu1() {
        System.out.println("-------------------------------\n" +
                "[0]. exit program\n" +
                "[1]. register\n" +
                "[2]. show details\n" +
                "[3]. Search: \n" +
                "[4]. update\n" +
                "[5]. delete");
        return InputUtil.inputRequiredInt("Choose option: ");

    }
    public static String entryMenu2(){
        System.out.println("---------------------------\n" +
                "[1]. Full Name\n" +
                "[2]. Group\n" +
                "[3]. specialty\n");
        return InputUtil.inputRequiredString("choose the change Student field (exp(1, 2, 3)):    ");
    }

}
