package org.example.javaConfig;

import org.example.entities.Student;
import org.example.studentDao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestMain {
    public static void main(String [] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(javaConfig.class);

        StudentDao std = context.getBean("studentjdbctemp", StudentDao.class);

        System.out.println("Program Started...");

        // Define SQL query for insertion
        //String query = "insert into student (id, name, city) values (?, ?, ?)";

        // Execute the insert operation using JdbcTemplate
        //jdbcTemplate.update(query, 102, "Ayush", "UP");

        Student s = new Student();
//        s.setId(104);
//        s.setName("Ganesh");
//        s.setCity("Baramati");
//        std.insert(s);

//    s.setId(103);
//    s.setName("Ayush");
//    s.setCity("UP");
//    std.update(s);

//    s.setId(104);
//    std.delete(s);

//        Student snt =  std.getStudent(101);
//        System.out.println(snt);


        List<Student> students =  std.getAllStudents();
        for(Student st: students){
            System.out.println(st);
        }
        System.out.println("Data Inserted...");
    }
}
