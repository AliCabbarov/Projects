package service.impl;

import enums.Exception;
import exception.InvalidOptionException;
import service.AdminService;
import service.CustomerManagementService;
import service.LibraryServiceManagement;

import static util.MenuUtil.adminEntryMenu;

public class AdminServiceImpl implements AdminService {
    @Override
    public void manage() {
        CustomerManagementService customerManagementService = new CustomerManagementServiceImpl();
        LibraryServiceManagement libraryServiceManagement = new LibraryServiceManagementImpl();
        while (true) {
            byte option = adminEntryMenu();
            switch (option) {
                case 0:
                    System.exit(-1);
                    break;
                case 1:
                    libraryServiceManagement.manageLibrary();
                    break;
                case 2:
                    customerManagementService.manageCustomer();
                    break;
                default:
                    throw new InvalidOptionException(Exception.INVALI_OPTION_EXCEPTION);
            }
        }
    }
}
