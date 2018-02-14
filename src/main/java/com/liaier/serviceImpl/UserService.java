package com.liaier.serviceImpl;

import com.liaier.dao.UserDao;
import com.liaier.entity.User;
import com.liaier.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserService implements IUserService {

    @Resource
    private UserDao userDao;

    public Integer add(User user) {
        return userDao.add(user);
    }

    public User query(User user) {
        return userDao.query(user);
    }
}
