package com.cxq.springcloud.dao;

import com.cxq.springcloud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
