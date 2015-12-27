package cn.springmvc.mq.listener;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.springmvc.entity.User;
import cn.springmvc.service.UserService;

@Component
public class QueueOneListener {
    
    @Resource
    private UserService userService;

    public void getUser(User user) {
        userService.add(user);
    }

}
