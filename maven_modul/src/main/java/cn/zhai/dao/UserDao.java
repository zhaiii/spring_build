package cn.zhai.dao;

import cn.zhai.bean.Student;
import cn.zhai.dao.mapper.StudentRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhai on 15/9/3.
 */
@Repository
public class UserDao extends JdbcDaoSupport {

    public boolean addStudent(Student student){
        String sql="insert into student(id,name,birthday,create_time,update_time) values(?,?,?,?,?)";

        try{
            int row = this.getJdbcTemplate().update(sql,student.getId(), student.getName(),
                    student.getBirthday(),
                    student.getCreate_time(),
                    student.getUpdate_time());

            return row>0;
        }catch (Exception e){

            e.printStackTrace();
        }
        return false;
    }
    public Student selectStudentById(final int id){
        String sql="select * from student where id = ?";

        Student student = null;
        try{
/*
            List<Student> query = this.getJdbcTemplate().query(sql, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setInt(1, id);

                }
            }, new StudentRowMapper());
*/
            List<Student> query = this.getJdbcTemplate().query(sql, new Object[]{id}, new StudentRowMapper());

            if(query != null && query.size()>0){
                return query.get(0);
            }

//            student = this.getJdbcTemplate().queryForObject(sql, Student.class, id); xxxx

//            student = this.getJdbcTemplate().queryForObject(sql, new ParameterizedBeanPropertyRowMapper().newInstance(Student.class), id);
        }catch (Exception e){
             e.printStackTrace();
        }
        return student;


    }
    public Integer selectCount(){
        String sql="select count(*) from student";
        Integer count=null;

        try{
            count=this.getJdbcTemplate().queryForObject(sql,Integer.class);

        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
    public List<Student> selectAll(){
        String sql="select * from student";
        List<Student> students=null;
//        List<Student> students = this.getJdbcTemplate().queryForList(sql, Student.class);
//        List<Student> students = this.getJdbcTemplate().query(sql, new StudentRowMapper());

        List<Map<String, Object>> maps = this.getJdbcTemplate().queryForList(sql);
        students=new ArrayList<Student>();
        for(Map<String,Object> m:maps){
            Student s=new Student();
            s.setId((Integer)m.get("id"));
            s.setName((String) m.get("name"));
            s.setBirthday((java.util.Date) m.get("birthday"));
            s.setCreate_time((java.util.Date) m.get("create_time"));
            s.setUpdate_time((java.util.Date)m.get("update_time"));
            students.add(s);
        }

        return students;


    }
}
