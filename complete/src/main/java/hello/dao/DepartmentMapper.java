package hello.dao;

import hello.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface DepartmentMapper {

//    @Select("select * from student")
    public List<Student> getDeptById();


}
