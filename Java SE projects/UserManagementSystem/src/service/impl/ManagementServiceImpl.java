package service.impl;

import enums.ExceptionsEnums;
import exception.InvalidOptionException;
import exception.UserNotFoundException;
import exception.WrongFormatException;
import service.ManagementService;
import service.UserService;
import util.MenuUtil;

import java.util.InputMismatchException;


public class ManagementServiceImpl implements ManagementService {
    @Override
    public void managementService() {
        UserService userServiceImpl = new UserServiceImpl();
        UserService superuserServiceImpl = new SuperUserServiceImpl();
        while (true) {
            try {
                byte option = MenuUtil.entryMenu();
                switch (option) {
                    case 1:
                        System.exit(-1);
                        break;
                    case 2:
                        userServiceImpl.register();
                        break;
                    case 3:
                        userServiceImpl.show();
                        break;
                    case 4:
                        userServiceImpl.search();
                        break;
                    case 5:
                        superuserServiceImpl.update();
                        break;
                    case 6:
                        userServiceImpl.delete();
                        break;
                    default:
                        throw new InvalidOptionException(ExceptionsEnums.INVALID_OPTION_EXCEPTION);
                }

            } catch (UserNotFoundException exception) {
                System.err.println(exception.getMessage() + "-" + exception.getLocalDateTime());
            } catch (WrongFormatException exception) {
                System.err.println(exception.getMessage() + "-" + exception.getLocalDateTime());
            } catch (InvalidOptionException exception) {
                System.err.println(exception.getMessage() + "-" + exception.getLocalDateTime());
            } catch (InputMismatchException | NumberFormatException exception) {
                System.err.println(ExceptionsEnums.WRONG_FORMAT.getMessage() + "-" + ExceptionsEnums.WRONG_FORMAT.getLocalDateTime());
            }catch (RuntimeException exception){
                System.out.println(exception.getMessage());
            }
        }

    }
}
