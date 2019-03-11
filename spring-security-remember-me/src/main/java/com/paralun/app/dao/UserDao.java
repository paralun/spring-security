package com.paralun.app.dao;

import com.paralun.app.model.User;

public interface UserDao {
    
    User findById(int id);
    User findByUserName(String username);
}
