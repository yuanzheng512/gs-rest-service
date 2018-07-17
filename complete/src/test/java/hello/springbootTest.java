package hello;

import hello.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ASUS on 2018/7/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class springbootTest {
    @Autowired
    Person mPerson;

    @Autowired
    ApplicationContext context;

    Logger logger =  LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads(){
        logger.debug("this is debug ******************");
        logger.trace("this is trace******************");
        logger.info("this is info******************");
        logger.warn("this is warn******************");
        logger.error("this is error******************");
        logger.info(mPerson.toString());
    }

    @Test
    public void testHelloService(){
        boolean b = context.containsBean("helloService");
        System.out.println(b);

    }
}
