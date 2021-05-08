package dataAccess.abstracts;

import entities.concretes.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    void update(User user);
    void delete(User user);
    User checkEmailPassword(String email, String password);
    User get(String email);

}
