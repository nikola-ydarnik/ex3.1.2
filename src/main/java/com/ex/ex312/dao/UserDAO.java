package com.ex.ex312.dao;

import com.ex.ex312.model.User;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    List<User> allUsers();

    User getUserById(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);

}
