package service;


import util.MenuUtil;

public class ManagementService {
    public static void studentManage() {
        while (true) {
            StudentService studentService = new StudentService();
            int option = MenuUtil.entryMenu1();

            switch (option) {
                case 0:
                    System.out.println("exit program!!!");
                    System.exit(-1);
                case 1:
                    studentService.registerStudent();
                    break;
                case 2:
                    studentService.showStudents();
                    break;
                case 3:
                    studentService.findByFullNameOrrGroupOrrSpecialty();
                    break;
                case 4:
                    studentService.updateStudent();
                    break;
                case 5:
                    studentService.deleteStudent();
                    break;
                default:
                    System.out.println("invalid option!!!");


            }
        }

    }

}
