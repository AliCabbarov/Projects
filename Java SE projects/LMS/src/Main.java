import service.AdminService;
import service.impl.AdminServiceImpl;

public class Main {
    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        adminService.manage();
    }
}