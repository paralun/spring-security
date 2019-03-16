package com.paralun.app.service;

import com.paralun.app.model.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}
