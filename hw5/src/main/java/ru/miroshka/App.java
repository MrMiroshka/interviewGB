package ru.miroshka;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = HibernateSession.getSessionFactory()) {
            StudentDao studentDao = new StudentDao(sessionFactory);
//            studentDao.addRandomStudents(); добавление 1000 студентов
            //Проверяем добавление
            studentDao.addStudent(Student.builder()
                    .name("Batman")
                    .mark(new BigDecimal(5.0))
                    .build());

            studentDao.addStudent(Student.builder()
                    .name("Batman")
                    .mark(new BigDecimal(4.0))
                    .build());
            //Получим список всех студентов с нужным нам именем
            List<Student> listStudent = studentDao.getStudentByName("Batman");
            listStudent.forEach(System.out::println);

            // Проверяем удаление по id и поиск по id
            studentDao.deleteStudent(studentDao.getStudentById(listStudent.get(0).getId()));


            studentDao.addStudent(Student.builder()
                    .name("Batman")
                    .mark(new BigDecimal(5.0))
                    .build());

            //Проверяем возможность изменения существующей записи в таблице
            Student updateStudent = studentDao.getStudentById(2L);
            System.err.println(updateStudent.toString());
            updateStudent.setName("UPDATED Batman");
            studentDao.updateStudent(updateStudent);
            System.out.println(studentDao.getStudentById(2L).toString());

            //Проверяем получения списка студентов
            studentDao.getAllStudents().forEach(System.out::println);


            //добавляем 1000 студентов
            addStudents(sessionFactory,1000);
        }
    }



    public static void addStudents(SessionFactory sessionFactory, int count) {
        Random rand = new Random();

        for (int i = 1; i <= count; i++) {
            String name = "Joker-" + i;
            double markTemp = rand.nextDouble(4) + 1;
            StudentDao studentDao = new StudentDao(sessionFactory);
            studentDao.addStudent(Student.builder()
                    .name(name)
                    .mark(BigDecimal.valueOf(markTemp))
                    .build());

        }

    }
}
