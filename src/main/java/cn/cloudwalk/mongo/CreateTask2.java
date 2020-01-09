package cn.cloudwalk.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description
 * @Author YCKJ1423
 * @Date 2019/12/16 16:04
 * Version 1.0
 **/
@Component
@EnableScheduling
public class CreateTask2 {
    private AtomicInteger count = new AtomicInteger(1);

    @Value("${pre.key}")
    private String key;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Scheduled(cron = "0/10 * * * * ?")
    public void execute(){
        if(count.get()>40000){
            return;
        }
        System.out.println("任务开始");
        final CountDownLatch countDownLa = new CountDownLatch(40);
        ExecutorService service = Executors.newCachedThreadPool();
        for(int k=0;k<40;k++){
            service.submit(new Runnable() {
                @Override
                public void run() {
                    int countLocal = count.getAndIncrement();
                    System.out.println("任务开始执行"+countLocal);
                    for (int i = 0; i <1000 ; i++) {
                        User user1 = new User();
                        String userId =countLocal+key+i;
                        user1.setUserId(userId);
                        user1.setBirthday(new Date());
                        user1.setFeature("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");
                        mongoTemplate.insert(user1,userId);

                    }
                    countDownLa.countDown();
                    System.out.println(Thread.currentThread().getName()+"結束");
                }
            });
        }
        try {
            countDownLa.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("任务结束执行");

    }
}
