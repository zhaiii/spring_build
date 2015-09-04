package cn.zhai.dao.mapper;

import cn.zhai.bean.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by zhai on 15/9/3.
 */
public class StudentRowMapper implements RowMapper<Student>{
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student s=new Student();
        s.setId(resultSet.getInt(1));
        s.setName(resultSet.getString(2));
        s.setBirthday(resultSet.getDate("birthday"));
        s.setCreate_time(resultSet.getTimestamp(4));
//        s.setCreate_time(resultSet.getDate(4));
        s.setUpdate_time(resultSet.getTime(5));


        return s;
    }
}
