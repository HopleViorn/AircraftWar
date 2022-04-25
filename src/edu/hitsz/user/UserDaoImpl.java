package edu.hitsz.user;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao, Serializable {
    private List<User> userList;
    public UserDaoImpl() {
        userList= new LinkedList<>();
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public User findUser(int userID) {
        return userList.stream().filter(e->e.userID==userID).findAny().orElse(null);
    }

    @Override
    public void addUser(User user) {
        userList.add(user);
    }

    @Override
    public void deleteUser(int userID) {
        userList.removeIf(e->e.userID==userID);
    }
}
