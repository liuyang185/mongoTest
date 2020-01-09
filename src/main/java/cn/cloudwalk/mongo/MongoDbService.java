package cn.cloudwalk.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author YCKJ1423
 * @Date 2019/12/12 15:58
 * Version 1.0
 **/
@Component
public class MongoDbService {
    @Autowired
    private MongoTemplate mongoTemplate;
    public Object getData(){
        return null;
    }
}
