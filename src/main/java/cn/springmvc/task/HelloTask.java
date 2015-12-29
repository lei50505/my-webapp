package cn.springmvc.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelloTask {
    
    @Scheduled(cron="* * * * * ?")
    public void hello(){
        System.out.println("hello task");
    }
}
