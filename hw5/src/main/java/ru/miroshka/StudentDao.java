package ru.miroshka;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;


public class StudentDao {
    private SessionFactory sessionFactory;

    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }


    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
    }

    public void deleteStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
    }

    public Student getStudentById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        return student;
    }

    /**
     * Возвращает список студентов, у которых есть совпадение по полю 'name'
     * @param name - имя студента
     * @return
     */
    public List <Student> getStudentByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Student where name = :name");
        query.setParameter("name", name);
        List <Student> listStudents  = query.getResultList();
        session.getTransaction().commit();
        return listStudents;
    }

    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Student> students = session.createQuery("from Student").getResultList();
        session.getTransaction().commit();
        return students;
    }

}

