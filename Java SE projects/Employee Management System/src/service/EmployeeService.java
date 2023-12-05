package service;

import employee.Employee;
import global.GlobalData;
import util.InputUtil;
import util.MenuUtil;

public class EmployeeService {
    public void showEmployee() {
        if (GlobalData.employees != null) {
            for (int i = 0; i < GlobalData.employees.length; i++) {
                System.out.println("------------------------------");
                System.out.println(GlobalData.employees[i].getInfo());
            }
        } else
            System.out.println("employee has not yet!");
    }

    public void registerEmployee() {
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
        System.out.println("Employees Save!!!");
    }

    public void search() {
        if (GlobalData.employees != null) {
            boolean check = false;
            String key = InputUtil.inputRequiredString("enter the keyword: ");
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getName().contains(key) ||
                        GlobalData.employees[i].getSurname().contains(key) ||
                        GlobalData.employees[i].getPosition().contains(key) ||
                        GlobalData.employees[i].salaryString().contains(key)) {
                    check = true;
                    System.out.println("---------------------------\n" +
                            GlobalData.employees[i].getInfo());
                }
            }
            if (!check) {
                System.out.println("employee has not yet");
            }
        } else {
            System.out.println("Employee has not yet!!!");
        }

    }

    public void update() {
        if (GlobalData.employees != null) {
            boolean check = false;
            int updateEmployeeId = InputUtil.inputRequiredInt("input update employee id:");
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getId() == updateEmployeeId) {
                    check = true;
                    System.out.println("------------------------");
                    System.out.println(GlobalData.employees[i].getInfo());
                    String[] fieldSplit = MenuUtil.entryMenuUpdate().split(", ");
                    for (int j = 0; j < fieldSplit.length; j++) {
                        int option = Integer.valueOf(fieldSplit[j]);
                        switch (option) {
                            case 1:
                                String updateName = InputUtil.inputRequiredString("enter the new name: ");
                                GlobalData.employees[i].setName(updateName);
                                break;
                            case 2:
                                String updateSurname = InputUtil.inputRequiredString("enter the new surname: ");
                                GlobalData.employees[i].setSurname(updateSurname);
                                break;
                            case 3:
                                String updatePosition = InputUtil.inputRequiredString("enter the new position: ");
                                GlobalData.employees[i].setPosition(updatePosition);
                                break;
                            case 4:
                                Double updateSalary = InputUtil.inputRequiredDouble("enter the  new salary: ");
                                GlobalData.employees[i].setSalary(updateSalary);
                                break;
                            default:
                                System.out.println("invalid option!!!");
                        }


                    }
                }


            }
            if (!check) {
                System.out.println("Student has not yet!!!");
            }
        } else
            System.out.println("employee has not yet!!");

    }

    public void deleteEmployee() {
        if (GlobalData.employees != null) {
            boolean check = false;
            Employee[] tempEmployee = GlobalData.employees;
            int input = InputUtil.inputRequiredInt("Delete Student id: ");
            for (int i = 0; i < GlobalData.employees.length; i++) {
                if (GlobalData.employees[i].getId() == input) {
                    check = true;
                    GlobalData.employees = new Employee[GlobalData.employees.length - 1];
                    for (int j = 0; j < GlobalData.employees.length; j++) {
                        if (tempEmployee[j].getId() < input) {
                            GlobalData.employees[j] = tempEmployee[j];
                        } else {
                            GlobalData.employees[j] = tempEmployee[j + 1];
                        }
                    }
                    System.out.println("delete successfully");
                }
            }
            if (!check) {
                System.out.println("employee has not yet");
            }
        } else {
            System.out.println("employee has not yet!!");
        }
    }

    public Employee fillEmployee() {
        System.out.println("------------register-------------");
        int id = InputUtil.inputRequiredInt("enter id:");
        String name = InputUtil.inputRequiredString("enter the name:");
        String surname = InputUtil.inputRequiredString("enter the surname: ");
        String position = InputUtil.inputRequiredString("enter the position: ");
        double salary = InputUtil.inputRequiredDouble("enter the salary: ");
        return new Employee(id, name, surname, position, salary);
    }
}
