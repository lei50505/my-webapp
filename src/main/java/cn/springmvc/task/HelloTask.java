package cn.springmvc.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelloTask {
    
    @Scheduled(cron="0 0 1 * * ?")
    public void hello(){
        System.out.println("hello task");
    }
}
