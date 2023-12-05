package helper;

import enums.Exception;
import globalData.GlobalData;
import model.Customer;
import model.Library;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static util.InputUtil.inputString;

public class CustomerServiceHelper {
    private static long id;
    private static int countIndex = 0;

    public static void oneMinusCountIndex() {
        countIndex--;
    }

    public static Customer fillCustomer() {
        try {


            String name = inputString("enter the name: ");
            String surname = inputString("enter the surname: ");
            LocalDate birthday = birthdayFormat();
            String username = inputString("enter the username: ");
            LocalDateTime registerDate = LocalDateTime.now();
            return new Customer(++id, name, surname, birthday, username, 0, registerDate, null);

        } catch (RuntimeException e) {
            System.err.println(Exception.WRONG_FORMAT_EXCEPTION.getMessage());
            return null;
        }
    }

    public static LocalDate birthdayFormat() {
        try {
            String birthday = inputString("enter birthday: (dd/MM/yyyy)");
            String[] birthdaySplit = birthday.split("/");
            int day = Integer.parseInt(birthdaySplit[0]);
            int month = Integer.parseInt(birthdaySplit[1]);
            int year = Integer.parseInt(birthdaySplit[2]);
            return LocalDate.of(year, month, day);
        } catch (RuntimeException exception) {
            System.err.println(Exception.WRONG_FORMAT_EXCEPTION.getMessage());
            return null;
        }
    }
    public static boolean appropriationCustomer(){
        Customer customer = fillCustomer();
        if(customer != null){
            GlobalData.customers[countIndex] = customer;
            countIndex++;
            return true;
        }
        return false;
    }
    public static void deleteNullCustomer(){
        int nullCount = 0;
        for (int i = 0; i < GlobalData.libraries.length; i++) {
            if (GlobalData.libraries[i] == null) {
                nullCount++;
            }

        }
        Library[] tempLibrary = GlobalData.libraries;
        GlobalData.libraries = new Library[GlobalData.libraries.length - nullCount];
        for (int i = 0; i < GlobalData.libraries.length; i++) {
            GlobalData.libraries[i] = tempLibrary[i];
        }
        zeroCountIndex();
    }
    public static void zeroCountIndex(){
        if (GlobalData.libraries.length == 0) {
            GlobalData.libraries = null;
            countIndex = 0;
        }
    }
}
