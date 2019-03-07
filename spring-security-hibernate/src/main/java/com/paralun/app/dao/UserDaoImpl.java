package com.paralun.app.dao;

import com.paralun.app.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl implements UserDao {
    
    @Autowired
    private SessionFactory factory;

    @Override
    public User findById(int id) {
        return (User) factory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User findByUserName(String username) {
        Criteria criteria = factory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }
}
