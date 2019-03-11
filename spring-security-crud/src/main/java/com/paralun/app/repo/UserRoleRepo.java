package com.paralun.app.repo;

import com.paralun.app.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userRoleRepo")
public interface UserRoleRepo extends CrudRepository<UserRole, Integer>{
    
}
