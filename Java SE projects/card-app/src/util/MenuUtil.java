package util;

import static util.InputUtil.*;

public class MenuUtil {
    public static int entryMenu(){
        System.out.println("[0]. Exit System\n" +
                "[1]. Sign in");
        return inputInt("Choose option: ");
    }
    public static int singInMenu(){
        System.out.println("[0]. System exit\n" +
                "[1]. Card to card\n" +
                "[2]. Show balance\n" +
                "[3]. Show operations\n" +
                "[4]. User management Service");
        return inputInt("choose option: ");
    }
}
