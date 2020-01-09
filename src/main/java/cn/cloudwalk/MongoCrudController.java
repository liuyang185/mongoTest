package cn.cloudwalk;

import cn.cloudwalk.mongo.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mongodb.DBObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexDefinition;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author YCKJ1423
 * @Date 2019/12/13 18:33
 * Version 1.0
 **/
@RestController
public class MongoCrudController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @PostMapping("/{op}/**")
    public Object execute(@RequestBody JSONObject param, @PathVariable("op")String op){
        if(op.equalsIgnoreCase("add")){
            User user1 = new User();
            BeanUtils.copyProperties(param.toJavaObject(User.class),user1);
            user1.setBirthday(new Date());
            mongoTemplate.insert(user1);
        }
        else if(op.equalsIgnoreCase("delete")){
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is("5df7271db3547fca1483b058"));
            mongoTemplate.remove(query,"userList");
            mongoTemplate.remove(query);

        }
        else if(op.equalsIgnoreCase("update")){
            Query query = new Query(Criteria.where("name").is("ko"));
            Update update = new Update().set("userId","123");
            mongoTemplate.upsert(query,update,User.class);
        }
        else if(op.equalsIgnoreCase("find")){
            Query query = new Query(Criteria.where("name").is("javc"));
            List<User> userList = mongoTemplate.find(query,User.class);
            System.out.println(JSON.toJSONString(userList));
        }


        return null;
    }
}
