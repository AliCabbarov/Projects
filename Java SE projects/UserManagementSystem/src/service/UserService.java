package service;

import model.User;

public interface UserService {
    void register();
    void  show();
    User search();
    void update();
    void delete();

}
