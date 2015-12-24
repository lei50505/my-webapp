package cn.springmvc.dao;

import cn.springmvc.annotation.MyBatisRepository;
import cn.springmvc.entity.User;

@MyBatisRepository
public interface UserDao {
    public void insert(User user);
}
