package Util;

import jdk.jshell.execution.Util;

public class MenuUtil {
    public static int entryMenu(){
        System.out.println("[1]. Create User\n" +
                "[2]. Update User by Id\n" +
                "[3]. Get User by Id\n" +
                "[4]. Get All Users\n" +
                "[5]. Avg Salary of Employees or Manager");
       return InputUtil.inputRequiredInt("Choose the option: ");
    }
    public static int createEmployeeOrManager(){
        System.out.println("[1]. Create Employee\n" +
                "[2]. Create Manager");
        return InputUtil.inputRequiredInt("Choose the option:");
    }
    public static int updateEmployeeFieldMenu(){
        System.out.println(
                "\n[1]. name: " +
                "\n[2]. surname: " +
                "\n[3]. username: " +
                "\n[4]. password" +
                "\n[5]. department: " +
                "\n[6]. salary:"+
                "\n[7]. position: ");
        return InputUtil.inputRequiredInt("update the option: ");
    }
    public static int updateManagerFieldMenu(){
        System.out.println(
                "\n[1]. name: " +
                        "\n[2]. surname: " +
                        "\n[3]. username: " +
                        "\n[4]. password" +
                        "\n[5]. department: " +
                        "\n[6]. salary:"+
                        "\n[7]. experience in year: ");
        return InputUtil.inputRequiredInt("update the option: ");
    }
    public static int updateEmployeeOrManager(){
        System.out.println("[1]. update Employee\n" +
                "[2]. update Manager");
        return InputUtil.inputRequiredInt("Choose the option:");
    }
    public static int getIdEmployeeOrManager(){
        System.out.println("[1]. get id Employee\n" +
                "[2]. get id Manager");
        return InputUtil.inputRequiredInt("Choose the option:");
    }
    public static int getAllEmployeeOrManager(){
        System.out.println("[1]. get all Employee\n" +
                "[2]. get all Manager");
        return InputUtil.inputRequiredInt("Choose the option:");
    }
    public static int avgSalaryEmployeeOrManager(){
        System.out.println("[1]. avg salary Employee\n" +
                "[2]. Avg salary Manager");
        return InputUtil.inputRequiredInt("Choose the option:");
    }

}
