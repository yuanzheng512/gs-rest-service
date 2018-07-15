package hello;

import hello.bean.Student;
import hello.dao.DepartmentMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ASUS on 2018/7/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class testDatabase {
    @Autowired
    private DataSource datasource;
    Logger logger =  LoggerFactory.getLogger(getClass());

    @Autowired
    private DepartmentMapper mapper;
    @Test
    public  void testMapper(){
        List<Student> list = mapper.getDeptById();
        logger.debug(list.size()+"");
    }
    @Test
    public void testDatasource(){
        try {
            Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("inser into student ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Object object = resultSet.getObject(1);
                logger.debug("*******",object.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
