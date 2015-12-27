package cn.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.springmvc.entity.User;
import cn.springmvc.exception.ServiceException;
import cn.springmvc.mq.producer.Producer;
import cn.springmvc.service.UserService;

//4.0前结合@ResponseBody
//@Controller
//4.0后
@RestController
@Transactional(rollbackFor=Throwable.class)
public class GreetingController {
    
    @Autowired
    private UserService userService;
    
    @Resource
    private Producer producer;
    
    private Logger log = Logger.getLogger(this.getClass());
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> greeting() throws ServiceException{
        log.info("greeting");
        User u = new User(1,"10",1); 
        userService.add(u);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "Hello");
        log.info("success");
        return new ResponseEntity<Map<String, Object>>(map,HttpStatus.OK);
    }
    //非json需charset=UTF-8
    @RequestMapping(value="/hello",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
    public ResponseEntity<String> sayHello(){
        log.info("sayHello");
        return new ResponseEntity<String>("你好",HttpStatus.OK);
    }
    @RequestMapping(value="/mq",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
    public ResponseEntity<String> sendUser(){
        log.info("sendMq");
        User u = new User(1,"10",1);
        producer.sendUser(u);
        return new ResponseEntity<String>("你好",HttpStatus.OK);
    }
   
}
