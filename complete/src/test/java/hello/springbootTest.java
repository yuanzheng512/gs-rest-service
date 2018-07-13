package hello;

import hello.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ASUS on 2018/7/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class springbootTest {

    @Autowired
    Person mPerson;
    @Test
    public void contextLoads(){
        System.out.println(mPerson);
    }
}
