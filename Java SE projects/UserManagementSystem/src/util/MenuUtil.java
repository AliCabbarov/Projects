package util;

import enums.ExceptionsEnums;

import java.util.InputMismatchException;

public class MenuUtil {
    public static byte entryMenu() {



            System.out.println("-------------------------\n" +
                    "[1]. exist system\n" +
                    "[2]. register\n" +
                    "[3]. show \n" +
                    "[4]. search\n" +
                    "[5]. update\n" +
                    "[6]. delete");
            return InputUtil.inputByte("choose option: ");



    }
}
