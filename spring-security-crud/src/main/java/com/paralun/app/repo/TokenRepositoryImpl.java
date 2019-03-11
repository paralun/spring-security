package com.paralun.app.repo;

import com.paralun.app.model.PersistentLogin;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("tokenRepository")
@Transactional
public class TokenRepositoryImpl implements PersistentTokenRepository {
    
    @Autowired
    PersistentLoginRepo loginRepo;

    @Override
    public void createNewToken(PersistentRememberMeToken prmt) {
        PersistentLogin login = new PersistentLogin();
        login.setUsername(prmt.getUsername());
        login.setSeries(prmt.getSeries());
        login.setToken(prmt.getTokenValue());
        login.setLast_used(prmt.getDate());
        loginRepo.save(login);
    }

    @Override
    public void updateToken(String seriesId, String tokenValue, Date lasdUsed) {
        PersistentLogin login = loginRepo.findOne(seriesId);
        login.setToken(tokenValue);
        login.setLast_used(lasdUsed);
        loginRepo.save(login);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        PersistentLogin login = loginRepo.findOne(seriesId);
        return new PersistentRememberMeToken(login.getUsername(), login.getSeries(), login.getToken(), login.getLast_used());
    }

    @Override
    public void removeUserTokens(String username) {
        PersistentLogin login = loginRepo.findByUsername(username);
        if(login != null) {
            loginRepo.delete(login);
        }
    }
    
}
