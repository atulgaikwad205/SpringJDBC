package org.example.studentDao;

import org.example.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentjdbctemp")
public class StudentDaoImpl implements StudentDao{

   @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        String query = "insert into student (id, name, city) values (?, ?, ?)";
        int r = jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
        return r;
    }

    @Override
    public int update(Student student) {
        String query = "update student set name=? , city=? where id=?";
        int r = jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return r;
    }

    @Override
    public int delete(Student student) {
        String query = "delete from student where id =?";
        int r = jdbcTemplate.update(query,student.getId());
        return r;
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "select * from Student where id=?";
        RowMapper<Student> rowMapper =  new RowMapperImpl();
        Student std = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
        return std;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from student";
        List<Student>  std = this.jdbcTemplate.query(query,new RowMapperImpl());
        return std;
    }
}
