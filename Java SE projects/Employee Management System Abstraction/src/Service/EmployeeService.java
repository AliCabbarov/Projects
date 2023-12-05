package Service;

import Company.Employee;
import Data.GlobalData;
import Util.InputUtil;
import Util.MenuUtil;

public class EmployeeService {
    public void createEmployee(){
        int registerCount = InputUtil.inputRequiredInt("how many employee: ");
        if (GlobalData.employees == null) {
            GlobalData.employees = new Employee[registerCount];
            for (int i = 0; i < GlobalData.employees.length; i++) {
                GlobalData.employees[i] = fillEmployee();
            }
        } else {
            Employee[] tempEmployee = GlobalData.employees;
            GlobalData.employees = new Employee[GlobalData.employees.length + registerCount];
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (i < tempEmployee.length) {
                    GlobalData.employees[i] = tempEmployee[i];
                } else {
                    GlobalData.employees[i] = fillEmployee();
                }

            }
        }

    }
    public Employee fillEmployee() {
        System.out.println("------------Create-------------");
        String name = InputUtil.inputRequiredString("enter the name:");
        String surname = InputUtil.inputRequiredString("enter the surname: ");
        String username = InputUtil.inputRequiredString("enter the username: ");
        String password = InputUtil.inputRequiredString("enter the password: ");
        String department = InputUtil.inputRequiredString("enter the department: ");
        double salary = InputUtil.inputRequiredDouble("enter the salary: ");
        String position = InputUtil.inputRequiredString("enter the position: ");

        return new Employee(name, surname, username, password,department,salary,position);
    }
    public void updateEmployeeById(){
        if(GlobalData.employees!=null){
            int updateId = InputUtil.inputRequiredInt("update employee id: ");
            for (int i = 0; i <GlobalData.employees.length ; i++) {
                if(GlobalData.employees[i].getId()==updateId){
                   int option = MenuUtil.updateEmployeeFieldMenu();
                   switch (option){
                       case 1:
                           String update = InputUtil.inputRequiredString("update name: ");
                           GlobalData.employees[i].setName(update);
                           break;
                       case 2:
                           String updateName = InputUtil.inputRequiredString("update surname: ");
                           GlobalData.employees[i].setSurname(updateName);
                           break;
                       case 3:
                           String updateUsername = InputUtil.inputRequiredString("update username: ");
                           GlobalData.employees[i].setUsername(updateUsername);
                           break;
                       case 4:
                           String updatePassword = InputUtil.inputRequiredString("update password: ");
                           GlobalData.employees[i].setPassword(updatePassword);
                           break;
                       case 5:
                           String updatedDepartment = InputUtil.inputRequiredString("update department: ");
                           GlobalData.employees[i].setDepartment(updatedDepartment);
                           break;
                       case 6:
                           double updateSalary = InputUtil.inputRequiredDouble("update salary: ");
                           GlobalData.employees[i].setSalary(updateSalary);
                           break;
                       case 7:
                           String updatePosition = InputUtil.inputRequiredString("update position: ");
                           GlobalData.employees[i].setPosition(updatePosition);
                           break;
                       default:
                           System.out.println("invalid option!!!");

                   }
                }


            }

        }else System.out.println("Employees has not!!!");
    }
    public void getEmployeeById() {
        if (GlobalData.employees != null) {
            int getId = InputUtil.inputRequiredInt("get id: ");
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if(GlobalData.employees[i].getId()==getId){
                    System.out.println(GlobalData.employees[i].getInfo());
                }
            }
        }else System.out.println("employee has not yet!!!");
    }
    public void getAllEmployee(){
        if (GlobalData.employees != null) {
            for (int i = 0; i < GlobalData.employees.length; i++) {
                System.out.println(GlobalData.employees[i].getInfo());
            }
        }
        else System.out.println("employee has not yet!!!");

    }
    public void avgSalaryOfEmployee (){
        if (GlobalData.employees != null) {
            double sum =0;
            for (int i = 0; i <GlobalData.employees.length ; i++) {
                sum += GlobalData.employees[i].getSalary();
            }
            double avg = sum/GlobalData.employees.length;
            System.out.println(avg);
        }
        else System.out.println("employee has not yet!!!");

    }
}
