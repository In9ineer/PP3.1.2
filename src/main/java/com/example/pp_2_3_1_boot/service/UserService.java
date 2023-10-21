package com.example.pp_2_3_1_boot.service;



import com.example.pp_2_3_1_boot.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void save(User user);

    User getUserById(long id);

    void update(long id, User updateUser);

    void delete(long id);
}
