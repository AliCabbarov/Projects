package Service;

import Util.InputUtil;
import Util.MenuUtil;

import java.awt.*;

public class ManagementService {
    public static void employeeAndManagerManage() {
        EmployeeService employeeService = new EmployeeService();
        ManagerService managerService = new ManagerService();
        while (true) {
            int option = MenuUtil.entryMenu();
            switch (option) {
                case 1:
                    int option1 = MenuUtil.createEmployeeOrManager();
                    if (option1 == 1) {
                        employeeService.createEmployee();
                    } else
                        managerService.createManager();
                    break;
                case 2:
                    int option2 = MenuUtil.updateEmployeeOrManager();
                    if(option2 == 1){
                        employeeService.updateEmployeeById();
                    }else
                        managerService.updateManagerById();
                    break;
                case 3:
                    int option3 = MenuUtil.getIdEmployeeOrManager();
                    if(option3==1){
                        employeeService.getEmployeeById();
                    }else managerService.getManagerById();
                    break;
                case 4:
                    int option4 = MenuUtil.getAllEmployeeOrManager();
                    if(option4== 1){
                        employeeService.getAllEmployee();
                    }
                    else managerService.getAllManager();
                    break;
                case 5:
                    int option5 = MenuUtil.avgSalaryEmployeeOrManager();
                    if(option5==1){
                        employeeService.avgSalaryOfEmployee();
                    }
                    else managerService.avgSalaryOfManager();
                    break;
                default:
                    System.out.println("invalid option!!!");

            }
        }
    }

}
