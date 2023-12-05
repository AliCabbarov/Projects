package service.impl;

import enums.ExceptionsEnums;
import enums.MessageEnums;
import exception.UserNotFoundException;
import exception.WrongFormatException;
import globalData.GlobalData;
import helper.UserServiceHelper;
import model.User;
import service.UserService;
import util.InputUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;



public class UserServiceImpl implements UserService {

    protected UserServiceHelper userServiceHelper = UserServiceHelper.getInstance();

    private static int countArrayIndex = 0;

    @Override
    public void register() {
        try {


            byte count = InputUtil.inputByte("how many register: ");

            if (GlobalData.users == null) {
                GlobalData.users = new User[count];
                for (int i = 0; i < GlobalData.users.length; i++) {
                    User fill = userServiceHelper.fillUser();
                    if (fill != null) {
                        GlobalData.users[countArrayIndex] = fill;
                        countArrayIndex++;
                    }
                }
                System.out.println(MessageEnums.REGISTER_SUCCESSFULLY.getMessage() + MessageEnums.REGISTER_SUCCESSFULLY.getLocalDateTime());

            } else {
                User[] tempUser = GlobalData.users;
                GlobalData.users = new User[GlobalData.users.length + count];
                for (int i = 0; i < GlobalData.users.length; i++) {
                    if (i < tempUser.length) {
                        GlobalData.users[i] = tempUser[i];
                    } else {
                        User fill = userServiceHelper.fillUser();
                        if (fill != null) {
                            GlobalData.users[countArrayIndex] = fill;
                            countArrayIndex++;
                        }
                    }

                }
                System.out.println(MessageEnums.REGISTER_SUCCESSFULLY.getMessage() + MessageEnums.REGISTER_SUCCESSFULLY.getLocalDateTime());
            }
            byte numberNull = 0;
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (GlobalData.users[i] == null) {
                    numberNull++;
                }
            }
            User[] temp = GlobalData.users;
            GlobalData.users = new User[GlobalData.users.length - numberNull];
            for (int i = 0; i < GlobalData.users.length; i++) {

                GlobalData.users[i] = temp[i];

            }
            if(GlobalData.users.length == 0){
                GlobalData.users = null;
                countArrayIndex = 0;
            }
        }catch (WrongFormatException exception){
            System.out.println(exception.getMessage() + exception.getLocalDateTime());
        }catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }

    }


    @Override
    public void show() {
        if (GlobalData.users != null) {
            if(GlobalData.users[0].getName() == null){
                throw new UserNotFoundException(ExceptionsEnums.USER_NOT_FOUND_EXCEPTION);
            }
            for (int i = 0; i < GlobalData.users.length; i++) {
                System.out.println(GlobalData.users[i].toString());
            }
        } else {
            throw new UserNotFoundException(ExceptionsEnums.USER_NOT_FOUND_EXCEPTION);

        }

    }

    @Override
    public User search() {
        if (GlobalData.users != null) {
            String searchKey = InputUtil.inputString("Search user by (name/surname)");
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (GlobalData.users[i].getName().equals(searchKey) ||
                        GlobalData.users[i].getSurname().equals(searchKey)) {
                    System.out.println(GlobalData.users[i].toString());
                    return GlobalData.users[i];
                }
            }
        } else {
            throw new UserNotFoundException(ExceptionsEnums.USER_NOT_FOUND_EXCEPTION);
        }
        return null;
    }

    @Override
    public void update() {
        if (GlobalData.users != null) {
            int updateById = InputUtil.inputInt("update user id: ");
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (GlobalData.users[i].getId() == updateById) {
                    System.out.println("NOTE: If you don't want to change the selected field, just press enter.");
                    String newName = InputUtil.inputString("Name: ");
                    if (newName.isBlank()) {

                    } else {
                        GlobalData.users[i].setName(newName);
                    }
                    String newSurname = InputUtil.inputString("Surname: ");
                    if (newSurname.isBlank()) {

                    } else {
                        GlobalData.users[i].setSurname(newSurname);
                    }
                    LocalDate newBirthday = userServiceHelper.birthdayHelperService();
                    if (newBirthday == null) {

                    } else {
                        GlobalData.users[i].setBirthday(newBirthday);
                    }
                    GlobalData.users[i].setUpdateDate(LocalDateTime.now());
                    System.out.println(MessageEnums.UPDATE_SUCCESSFULLY.getMessage() + "-" + MessageEnums.UPDATE_SUCCESSFULLY.getLocalDateTime());
                }

            }
        } else throw new UserNotFoundException(ExceptionsEnums.USER_NOT_FOUND_EXCEPTION);

    }

    @Override
    public void delete() {
        if (GlobalData.users != null) {
            boolean isTrue = false;
            int deleteId = InputUtil.inputInt("delete user by id: ");
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (GlobalData.users[i].getId() == deleteId) {
                    countArrayIndex--;
                    isTrue = true;
                    User[] tempUser = GlobalData.users;
                    GlobalData.users = new User[GlobalData.users.length - 1];
                    for (int j = 0; j < GlobalData.users.length; j++) {
                        if (j < i) {
                            GlobalData.users[j] = tempUser[j];
                        } else {
                            GlobalData.users[j] = tempUser[j + 1];
                        }

                    }
                    System.out.println(MessageEnums.DELETE_SUCCESSFULLY.getMessage());
                }


            }
            if(GlobalData.users.length == 0){
                GlobalData.users = null;
                countArrayIndex = 0;
            }
            if (!isTrue) {
                throw new UserNotFoundException(ExceptionsEnums.USER_NOT_FOUND_EXCEPTION);
            }
        } else throw new UserNotFoundException(ExceptionsEnums.USER_NOT_FOUND_EXCEPTION);

    }
}
