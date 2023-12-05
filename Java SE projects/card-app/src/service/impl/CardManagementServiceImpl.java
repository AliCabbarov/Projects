package service.impl;

import enums.ExceptionEnums;
import exception.ApplicationException;
import service.CardManagementService;
import service.CardService;
import service.UserManagementService;

import static util.MenuUtil.singInMenu;

public class CardManagementServiceImpl implements CardManagementService {
    @Override
    public void cardManagement(int id) {
        while (true) {
            try {

                CardService cardService = new CardServiceImpl();
                UserManagementService userManagementService = new UserManagementServiceImpl();
                int option = singInMenu();
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        cardService.CardToCard(id);
                        break;
                    case 2:
                        cardService.showBalance(id);
                        break;
                    case 3:
                        cardService.showOperations(id);
                        break;
                    case 4:
                        userManagementService.userManagement();
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