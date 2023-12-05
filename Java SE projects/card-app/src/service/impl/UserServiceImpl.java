package service.impl;

import data.GlobalData;
import enums.ExceptionEnums;
import exception.ApplicationException;
import model.User;
import service.CardManagementService;
import service.UserService;

import static util.InputUtil.inputString;

public class UserServiceImpl implements UserService {
    private static int failedAttempts = 0;
    CardManagementService cardManagementService = new CardManagementServiceImpl();

    @Override
    public void singIn() {
        String phoneNumberOrFin = inputString("enter the phone number or fin: ").toUpperCase();
        String password = inputString("enter the password: ");
        boolean userDoesntExist = true;
        for (User user : GlobalData.users) {
            if (user.getMobileNumber().equals(phoneNumberOrFin) ||
                    user.getFin().equals(phoneNumberOrFin)) {
                userDoesntExist = false;
                if (user.getPassword().equals(password)) {
                    cardManagementService.cardManagement((int) user.getId());
                    failedAttempts = 0;
                } else {
                    failedAttempts++;
                }
                if (failedAttempts == 3) {
                    System.exit(-1);
                }
            }
        }
        if(userDoesntExist){
            throw new ApplicationException(ExceptionEnums.NOT_FOUND_EXCEPTION);
        }
    }
}
