package hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/7/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    Logger logger =  LoggerFactory.getLogger(getClass());
    @Autowired
    private StringRedisTemplate mStringRedisTemplate;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Test
    public void test(){
        mStringRedisTemplate.opsForValue().set("this","hello");
    }
    @Test
    public void get(){
        String key = mStringRedisTemplate.opsForValue().get("this");
        logger.debug(".........   "+key+"   ...............");
    }

    @Test
    public void testObject(){
        List<Student> list = new ArrayList<Student>();

        Student s = new Student();
        s.setUsername("hello123");
        list.add(s);

        Student s1 = new Student();
        s1.setUsername("hello123456");
        list.add(s1);
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//           String json =  mapper.writeValueAsString(s);
//           mStringRedisTemplate.opsForValue().set("student",json);
//           mStringRedisTemplate.opsForValue().get("student");
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        redisTemplate.opsForValue().set("student",list);
        List<Student> student =(List<Student>) redisTemplate.opsForValue().get("student");
        logger.debug(student.toString());
    }
}
