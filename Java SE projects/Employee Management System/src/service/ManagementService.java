package service;

import util.MenuUtil;

public class ManagementService {
    public static void employeeManage() {
        while (true) {
            EmployeeService employeeService = new EmployeeService();
            int option = MenuUtil.entryMenu();
            switch (option){
                case 0:
                    System.exit(-1);
                case 1:
                    employeeService.showEmployee();
                    break;
                case 2:
                    employeeService.registerEmployee();
                    break;
                case 3:
                    employeeService.search();
                    break;
                case 4:
                    employeeService.update();
                    break;
                case 5:
                    employeeService.deleteEmployee();
                    break;
                default:
                    System.out.println("invalid option!!!");
                    break;
            }
        }
    }
}


