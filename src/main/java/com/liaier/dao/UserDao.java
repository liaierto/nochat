package com.liaier.dao;

import com.liaier.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    Integer add(User user);
    User query(User user);
}
