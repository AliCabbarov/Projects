package helper;

import enums.ExceptionsEnums;
import model.User;
import util.InputUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserServiceHelper {
    private static UserServiceHelper userServiceHelper = null;
    private static long id = 0;

    public static UserServiceHelper getInstance() {
        if (userServiceHelper == null) {
            userServiceHelper = new UserServiceHelper();
        }
        return userServiceHelper;

    }

    public User fillUser() {
        try {


            String name = InputUtil.inputString("Name: ");
            String surname = InputUtil.inputString("Surname: ");
            LocalDate birthday = birthdayHelperService();
            if (birthday == null) {
                return null;
            }
            LocalDateTime registerDate = LocalDateTime.now();
            return new User(++id, name, surname, birthday, registerDate, null);
        } catch (RuntimeException exception) {
            System.err.println(ExceptionsEnums.WRONG_FORMAT.getMessage() + "-" + ExceptionsEnums.WRONG_FORMAT.getLocalDateTime());
        }
        return null;

    }

    public LocalDate birthdayHelperService() {
        try {
            String stringBirthday = InputUtil.inputString("birthday: (dd-MM-yyyy)");
            if (stringBirthday.isBlank()) {

            } else {
                String[] stringBirthdayArray = stringBirthday.split("-");
                int day = Integer.parseInt(stringBirthdayArray[0]);
                int month = Integer.parseInt(stringBirthdayArray[1]);
                int years = Integer.parseInt(stringBirthdayArray[2]);
                return LocalDate.of(years, month, day);
            }
        } catch (NumberFormatException exception) {
            System.err.println(ExceptionsEnums.WRONG_FORMAT.getMessage() + "-" + ExceptionsEnums.WRONG_FORMAT.getLocalDateTime());
        }
        return null;
    }

}
