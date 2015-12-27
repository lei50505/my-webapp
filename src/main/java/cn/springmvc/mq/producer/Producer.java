package cn.springmvc.mq.producer;

import javax.annotation.Resource;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import cn.springmvc.entity.User;

@Component
public class Producer {
    @Resource
    private AmqpTemplate amqpTemplate;
    
    public void sendUser(User user){
        amqpTemplate.convertAndSend("queue_one_key", user);
    }
}
