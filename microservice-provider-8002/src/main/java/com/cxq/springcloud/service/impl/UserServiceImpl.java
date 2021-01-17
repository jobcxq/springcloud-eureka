package com.cxq.springcloud.service.impl;

import com.cxq.springcloud.dao.UserDao;
import com.cxq.springcloud.model.User;
import com.cxq.springcloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService<User> {
    Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public User findById(Integer id) {
        return userDao.findOne(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User saveOrUpdate(User user) {
        return userDao.save(user);
    }

    public void deleteById(Integer id) {
        userDao.delete(id);
    }
}
