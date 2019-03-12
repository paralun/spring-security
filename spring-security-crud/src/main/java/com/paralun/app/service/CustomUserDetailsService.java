package com.paralun.app.service;

import com.paralun.app.model.UserRole;
import com.paralun.app.repo.UserRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    @Qualifier("userRepo")
    private UserRepo userRepo;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.paralun.app.model.User user = userRepo.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        
        return new User(user.getUsername(), user.getPassword(), user.getActive(), true, true, true, getGrantedAuthorities(user));
    }
    
    private List<GrantedAuthority> getGrantedAuthorities(com.paralun.app.model.User user) {
        List<GrantedAuthority> authoritys = new ArrayList<>();
        for(UserRole role : user.getRoles()) {
            authoritys.add(new SimpleGrantedAuthority("ROLE_" + role.getType()));
        }
        
        return authoritys;
    }
    
}
