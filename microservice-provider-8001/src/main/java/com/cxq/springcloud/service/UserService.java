package com.cxq.springcloud.service;

import com.cxq.springcloud.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService<T> {

    public User findById(Integer id);

    public List<User> findAll();

    public User saveOrUpdate(User user);

    public void deleteById(Integer id);

}
