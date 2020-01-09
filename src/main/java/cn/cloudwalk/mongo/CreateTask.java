package cn.cloudwalk.mongo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description
 * @Author YCKJ1423
 * @Date 2019/12/16 16:04
 * Version 1.0
 **/
//@Component
//@EnableScheduling
public class CreateTask {
    private int count =1;

    @Autowired
    private MongoTemplate mongoTemplate;
    @Scheduled(cron = "0/10 * * * * ?")
    public void execute(){
        int countLocal = count++;

        System.out.println("任务开始执行"+countLocal);
        for (int i = 0; i <Integer.MAX_VALUE ; i++) {
            User user1 = new User();
            user1.setUserId(countLocal+"s00"+i);
            user1.setBirthday(new Date());
            user1.setFeature("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");
            mongoTemplate.insert(user1);
        }
        
        System.out.println("任务结束执行"+countLocal);

    }
}
