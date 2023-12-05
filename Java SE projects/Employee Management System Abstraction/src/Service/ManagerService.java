package Service;

import Company.Manager;
import Data.GlobalData;
import Util.InputUtil;
import Util.MenuUtil;

public class ManagerService {
    public void createManager() {
        int registerCount = InputUtil.inputRequiredInt("how many manager: ");
        if (GlobalData.managers == null) {
            GlobalData.managers = new Manager[registerCount];
            for (int i = 0; i < GlobalData.managers.length; i++) {
                GlobalData.managers[i] = fillManager();
            }
        } else {
            Manager[] tempManager = GlobalData.managers;
            GlobalData.managers = new Manager[GlobalData.managers.length + registerCount];
            for (int i = 0; i < GlobalData.managers.length; i++) {
                if (i < tempManager.length) {
                    GlobalData.managers[i] = tempManager[i];
                } else {
                    GlobalData.managers[i] = fillManager();
                }

            }
        }

    }

    public Manager fillManager() {
        System.out.println("------------Create-------------");
        String name = InputUtil.inputRequiredString("enter the name:");
        String surname = InputUtil.inputRequiredString("enter the surname: ");
        String username = InputUtil.inputRequiredString("enter the position: ");
        String password = InputUtil.inputRequiredString("enter the password: ");
        String department = InputUtil.inputRequiredString("enter the department: ");
        double salary = InputUtil.inputRequiredDouble("enter the salary: ");
        String experienceInYear = InputUtil.inputRequiredString("enter the Experience In Year: ");

        return new Manager(name, surname, username, password, department, salary, experienceInYear);
    }

    public void updateManagerById() {
        if (GlobalData.managers != null) {
            int updateId = InputUtil.inputRequiredInt("update manager id: ");
            for (int i = 0; i < GlobalData.managers.length; i++) {
                if (GlobalData.managers[i].getId() == updateId) {
                }
                int option = MenuUtil.updateManagerFieldMenu();
                switch (option) {
                    case 1:
                        String updateName = InputUtil.inputRequiredString("update name: ");
                        GlobalData.managers[i].setName(updateName);
                        break;
                    case 2:
                        String updateSurname = InputUtil.inputRequiredString("update surname: ");
                        GlobalData.managers[i].setSurname(updateSurname);
                        break;
                    case 3:
                        String updateUserName = InputUtil.inputRequiredString("update username: ");
                        GlobalData.managers[i].setSurname(updateUserName);
                        break;
                    case 4:
                        String updatePassword = InputUtil.inputRequiredString("update password: ");
                        GlobalData.managers[i].setPassword(updatePassword);
                        break;
                    case 5:
                        String updateDepartment = InputUtil.inputRequiredString("update department: ");
                        GlobalData.managers[i].setDepartment(updateDepartment);
                        break;
                    case 6:
                        double updateSalary = InputUtil.inputRequiredDouble("update salary");
                        GlobalData.managers[i].setSalary(updateSalary);
                        break;
                    case 7:
                        String updateExperienceInYear = InputUtil.inputRequiredString("update Experience in Year");
                        GlobalData.managers[i].setExperienceInYear(updateExperienceInYear);
                        break;
                    default:
                        System.out.println("invalid option!!!");
                }

            }
        }else System.out.println("manager has not yet!!!");
    }

    public void getManagerById() {
        if (GlobalData.managers != null) {
            int getId = InputUtil.inputRequiredInt("get id: ");
            for (int i = 0; i < GlobalData.managers.length; i++) {
                if(GlobalData.managers[i].getId()==getId){
                    System.out.println(GlobalData.managers[i].getInfo());
                }
            }
        }else System.out.println("employee has not yet!!!");
    }
    public void getAllManager(){
        if (GlobalData.managers != null) {
            for (int i = 0; i < GlobalData.managers.length; i++) {
                System.out.println(GlobalData.managers[i].getInfo());
            }
        }
        else System.out.println("manager has not yet!!!");

        }
        public void avgSalaryOfManager (){
            if (GlobalData.managers != null) {
                double sum =0;
                for (int i = 0; i <GlobalData.managers.length ; i++) {
                    sum += GlobalData.managers[i].getSalary();
                }
                double avg = sum/GlobalData.managers.length;
                System.out.println(avg);
            }
            else System.out.println("has not yet!!");

            }
}
