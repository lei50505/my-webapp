package cn.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.springmvc.dao.UserDao;
import cn.springmvc.entity.User;
import cn.springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.insert(user);
    }

}
