package com.paralun.app.repo;

import com.paralun.app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepo")
public interface UserRepo extends CrudRepository<User, String>{
    
    User findByUsername(String username);
}
