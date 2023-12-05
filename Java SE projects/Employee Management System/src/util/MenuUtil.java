package util;

public class MenuUtil {
    public static int entryMenu(){
        System.out.println("------------------------\n" +
                "[0]. exit System\n" +
                "[1]. Show all employee\n" +
                "[2]. Register employee\n" +
                "[3]. Search employee\n" +
                "[4]. Update employee\n" +
                "[5]. Delete employee");
        return InputUtil.inputRequiredInt("choose option: ");
    }
    public static String entryMenuUpdate(){
        System.out.println("---------------------------\n" +
                "[1]. Name\n" +
                "[2]. Surname\n" +
                "[3]. Position\n" +
                "[4]. Salary");
        return InputUtil.inputRequiredString("choose the change employee field (exp(1, 2, 3)):    ");
    }
}
