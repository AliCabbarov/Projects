package service.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import service.UserManagementService;
import service.UserService;

import static util.MenuUtil.entryMenu;

public class UserManagementServiceImpl implements UserManagementService {
    @Override
    public void userManagement() {
        while (true) {
            try {

                UserService userService = new UserServiceImpl();
                int option = entryMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                        break;
                    case 1:
                        userService.singIn();
                        break;
                    default:
                        throw new ApplicationException(ExceptionEnums.INVALID_OPTION_EXCEPTION);
                }

            }catch (RuntimeException exception){
                System.err.println(exception.getMessage());
            }
        }
    }
}