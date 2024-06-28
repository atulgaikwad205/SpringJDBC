package org.example.javaConfig;

import org.example.studentDao.StudentDao;
import org.example.studentDao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.example.studentDao")
public class javaConfig {

    @Bean("ds")
    public DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }


    @Bean("temp")
    public JdbcTemplate getjdbcTemplete(){
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(getDataSource());
        return template;
    }

    // commenting for use this with Annotation(Autowire)
//    @Bean("studentjdbctemp")
//    public StudentDao getStudentDao(){
//        StudentDaoImpl std = new StudentDaoImpl();
//        std.setJdbcTemplate(getjdbcTemplete());
//        return  std;
//    }

}
