package cn.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.springmvc.entity.User;
import cn.springmvc.exception.ServiceException;
import cn.springmvc.service.UserService;

//4.0前结合@ResponseBody
//@Controller
//4.0后
@RestController
@Transactional(rollbackFor=Throwable.class)
public class GreetingController {
    
    @Autowired
    private UserService userService;
    
    @Value("#{jdbc[driver]}")
    private String driver;
    
    private Logger log = Logger.getLogger(this.getClass());
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> greeting() throws ServiceException{
        log.info("greeting");
        User u = new User(1,"10",1); 
        userService.insert(u);
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
   
}