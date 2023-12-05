package service.impl;

import enums.Exception;
import exception.BookNotFoundException;
import exception.InvalidOptionException;
import exception.WrongFormatException;
import exception.CustomerNotFoundException;
import service.AdminService;
import service.CustomerManagementService;
import service.CustomerService;

import static util.MenuUtil.entryMenuCustomer;

public class CustomerManagementServiceImpl implements CustomerManagementService {
    @Override
    public void manageCustomer() {
        CustomerService customerService = new CustomerServiceImpl();
        AdminService adminService = new AdminServiceImpl();
        while (true) {
            try {
                byte option = entryMenuCustomer();
                switch (option) {
                    case 0:
                        System.exit(-1);
                        break;
                    case 1:
                        customerService.register();
                        break;
                    case 2:
                        customerService.search();
                        break;
                    case 3:
                        customerService.show();
                        break;
                    case 4:
                        customerService.update();
                        break;
                    case 5:
                        customerService.delete();
                        break;
                    case 6:
                        customerService.login();
                        break;
                    case 7:
                        adminService.manage();
                        break;
                    default:
                        throw new InvalidOptionException(Exception.INVALI_OPTION_EXCEPTION);
                }
            } catch (CustomerNotFoundException | BookNotFoundException | WrongFormatException exception) {
                System.err.println(exception.getMessage());
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
