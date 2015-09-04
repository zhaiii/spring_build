import cn.zhai.bean.Student;
import cn.zhai.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.Inet4Address;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by zhai on 15/9/3.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test(){
        Student s=new Student();
        s.setId(2);
        s.setName("haha");
//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
//        String date = format.format(new Date);
//        s.setBirthday(new Date());
        s.setBirthday(new Date());
        s.setCreate_time(new Date());
        s.setUpdate_time(new Date());
        userDao.addStudent(s);

    }

    @Test
    public void testSelect(){

        Student student = userDao.selectStudentById(2);
        System.out.println(student.toString());
    }

    @Test
    public void testCount(){
        Integer count=userDao.selectCount();
        System.out.println(count);
    }

    @Test
    public void testSelectAll(){
        List<Student> students = userDao.selectAll();
        System.out.println(students.toString());
    }


    @Test
    public void textOther() throws Exception{
        String hostName = Inet4Address.getLocalHost().getHostName();
        System.out.println(hostName);
        System.out.println(new Date());
        System.out.println(new java.sql.Date(new Date().getTime()));

    }

}
