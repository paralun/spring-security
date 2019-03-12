package com.paralun.app.util;

import com.paralun.app.model.UserRole;
import com.paralun.app.repo.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("roleToUserConverter")
public class RoleToUserConverter implements Converter<Object, UserRole>{
    
    @Autowired
    @Qualifier("userRepo")
    UserRoleRepo roleRepo;

    @Override
    public UserRole convert(Object s) {
        String uuid = (String) s;
        UserRole role = roleRepo.findOne(uuid);
        return role;
    }
    
}
