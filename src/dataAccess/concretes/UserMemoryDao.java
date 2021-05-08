package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class UserMemoryDao implements UserDao {
    private ArrayList<User> users=new ArrayList<User>();

    @Override
    public void save(User user) {
        this.users.add(user);
    }

    @Override
    public void update(User user) {
        this.users.set(this.users.indexOf(user),user);
    }

    @Override
    public void delete(User user) {
        this.users.remove(this.users.indexOf(user));
    }

    @Override
    public User checkEmailPassword(String email, String password) {
        for(User user:users){
            if(user.getEmail()==email && user.getPassword()==password)
                return user;
        }
        return null;
    }

    @Override
    public User get(String email) {
        for(User user:users){
            if(user.getEmail() == email)
                return user;
        }
        return null;
    }

}
