package service.impl;

import enums.Exception;
import exception.*;
import service.AdminService;
import service.LibraryService;
import service.LibraryServiceManagement;

import static util.MenuUtil.entryMenu;

public class LibraryServiceManagementImpl implements LibraryServiceManagement {
    @Override
    public void manageLibrary() {
        LibraryService libraryService = new LibraryServiceImpl();
        AdminService adminService = new AdminServiceImpl();

        while (true){
            try {
                byte option = entryMenu();
                switch (option){
                    case 0:
                        System.exit(-1);
                        break;
                    case 1:
                        libraryService.register();
                        break;
                    case 2:
                        libraryService.search();
                        break;
                    case 3:
                        libraryService.show();
                        break;
                    case 4:
                        libraryService.update();
                        break;
                    case 5:
                        libraryService.delete();
                        break;
                    case 6:
                        libraryService.storageToStock();
                        break;
                    case 7:
                        adminService.manage();
                        break;
                    default: throw new InvalidOptionException(Exception.INVALI_OPTION_EXCEPTION);
                }
            }catch (BookNotFoundException   |
                    InvalidOptionException | WrongFormatException | WrongStorageStatusException exception){
                System.err.println(exception.getMessage());
            }catch (RuntimeException exception){
                System.err.println(Exception.WRONG_FORMAT_EXCEPTION.getMessage());
            }
        }
    }

}
