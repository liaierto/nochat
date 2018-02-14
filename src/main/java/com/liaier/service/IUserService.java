package com.liaier.service;

import com.liaier.dao.UserDao;
import com.liaier.entity.User;

public interface IUserService {

    Integer add(User user);
    User query(User user);
}
