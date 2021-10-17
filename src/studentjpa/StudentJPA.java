package studentjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;
import java.math.BigDecimal;

public class StudentJPA {
    public static void main(String[] args) {
        Student stu1 = new Student(3, "Jame", 1.4);
        Student stu2 = new Student(4, "Khem", 3.9);
        StudentT2.insertStudent(stu1);
        StudentT2.insertStudent(stu2);
        Student stu;
        stu = StudentT2.findStudentById(1);
        if (stu != null) {
            stu.setName("Korn");
            StudentT2.removeStudent(stu);
            StudentT2.updateStudent(stu);
        }
        List<Student> stuList = StudentT2.findAllStudent();
        printAllStudent(stuList);
    }
    private static void printAllStudent(List<Student> stuList) {
        for(Student stu : stuList) {
           System.out.print(stu.getId() + " ");
           System.out.print(stu.getName() + " ");
           System.out.println(stu.getGpa() + " ");
       }
    }
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    }
    
