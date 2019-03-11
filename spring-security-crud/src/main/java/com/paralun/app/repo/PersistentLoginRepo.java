package com.paralun.app.repo;

import com.paralun.app.model.PersistentLogin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("persistentLoginRepo")
public interface PersistentLoginRepo extends CrudRepository<PersistentLogin, String>{
    
    PersistentLogin findByUsername(String username);
}
