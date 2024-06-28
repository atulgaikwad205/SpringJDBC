package org.example;

import org.example.entities.Student;
import org.example.studentDao.StudentDao;
import org.example.studentDao.StudentDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App{

public static void main(String[] args) {
    // Load the Spring configuration file
    ApplicationContext context = new ClassPathXmlApplicationContext("coonfig.xml");

    // Retrieve the JdbcTemplate bean from the context
    StudentDao std = context.getBean("studentjdbctemp", StudentDao.class);

    System.out.println("Program Started...");

    Student s = new Student();
//    s.setId(103);
//    s.setName("Ganesh");
//    s.setCity("Baramati");
//    std.insert(s);

//    s.setId(103);
//    s.setName("Vishal");
//    s.setCity("Mumbai");
//
//    std.update(s);

//    s.setId(102);
//    std.delete(s);

   Student snt =  std.getStudent(101);
    System.out.println(snt);
    // Define SQL query for insertion
    //String query = "insert into student (id, name, city) values (?, ?, ?)";

    // Execute the insert operation using JdbcTemplate
    //jdbcTemplate.update(query, 102, "Ayush", "UP");

   List<Student> students =  std.getAllStudents();
   for(Student st: students){
       System.out.println(st);
   }
    System.out.println("Data Inserted...");
}
}
