package service.impl;

import enums.ExceptionsEnums;
import enums.MessageEnums;
import exception.InvalidOptionException;
import exception.UserNotFoundException;
import globalData.GlobalData;
import util.InputUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SuperUserServiceImpl extends UserServiceImpl {
    @Override
    public void update() {
        if (GlobalData.users != null) {
            int updateById = InputUtil.inputInt("update user id: ");
            for (int i = 0; i < GlobalData.users.length; i++) {
                if (GlobalData.users[i].getId() == updateById) {
                    boolean isTrue = false;
                    String parameters = InputUtil.inputString("enter the update update field: (exp: name,surname,birthday))");
                    String[] ArrayParameter = parameters.split(",");
                    for (String parameter : ArrayParameter) {
                        switch (parameter) {
                            case "name":
                                String updateName = InputUtil.inputString("enter the update name: ");
                                if (updateName.isEmpty()) {

                                } else {
                                    isTrue = true;
                                    GlobalData.users[i].setName(updateName);
                                    GlobalData.users[i].setUpdateDate(LocalDateTime.now());
                                }
                                break;
                            case "surname":
                                String updateSurname = InputUtil.inputString("enter the update surname: ");
                                if (updateSurname.isEmpty()) {

                                } else {
                                    isTrue =true;
                                    GlobalData.users[i].setSurname(updateSurname);
                                    GlobalData.users[i].setUpdateDate(LocalDateTime.now());
                                }
                                break;
                            case "birthday":
                                LocalDate updateBirthday = userServiceHelper.birthdayHelperService();
                                if (updateBirthday == null) {

                                } else {
                                    isTrue =true;
                                    GlobalData.users[i].setBirthday(updateBirthday);
                                    GlobalData.users[i].setUpdateDate(LocalDateTime.now());
                                }
                                break;
                            default:
                                throw new InvalidOptionException(ExceptionsEnums.INVALID_OPTION_EXCEPTION);


                        }

                    }
                    if(isTrue){
                        System.out.println(MessageEnums.UPDATE_SUCCESSFULLY.getMessage() + "-" + MessageEnums.UPDATE_SUCCESSFULLY.getLocalDateTime());
                    }


                }


            }
        } else throw new UserNotFoundException(ExceptionsEnums.USER_NOT_FOUND_EXCEPTION);

    }
}
