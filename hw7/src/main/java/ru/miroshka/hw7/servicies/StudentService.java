package ru.miroshka.hw7.servicies;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.miroshka.hw7.data.Student;
import ru.miroshka.hw7.exceptions.ResourceNotFoundException;
import ru.miroshka.hw7.repositories.StudentDao;
import ru.miroshka.hw7.repositories.specifications.StudentsSpecifications;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Lazy
public class StudentService {
    private final StudentDao studentDao;



    public List<Student> findAll(){
        return studentDao.findAll();
    }

    public static final Function<Student, Student> functionEntityToSoap = se ->{
        Student s = new Student();
        s.setId(se.getId());
        s.setName(se.getName());
        s.setAge(se.getAge());
        return s;
    };

    public List<Student> getAllStudents(){
        return studentDao.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }


    public Page<Student> find(Integer minAge, Integer maxAge, String nameStudent, Integer page, Integer pageSize) {
        Specification<Student> spec = Specification.where(null);
        if (minAge != null) {
            spec = spec.and(StudentsSpecifications.ageGreaterOrEqualsThen(minAge));
        }
        if (maxAge != null) {
            spec = spec.and(StudentsSpecifications.ageLesserOrEqualsThen(maxAge));
        }
        if (nameStudent != null) {
            spec = spec.and(StudentsSpecifications.nameLike(nameStudent));
        }
        return this.studentDao.findAll(spec, PageRequest.of(page - 1, pageSize));

    }

    public List<Student> getStudent(Long id) {
        return this.studentDao.findById(id).stream().toList();
    }

    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(studentDao.findById(id).orElseThrow(() -> new ResourceNotFoundException
                ("This student not found  id =  " + id)));
    }

    public Student addStudent(Student student) {
        return this.studentDao.save(student);
    }

    public void deleteById(Long id) {
        this.studentDao.deleteById(id);
    }


    @Transactional
    public void changeStudent(Student student) {
        Student studentChange = this.studentDao.findById(student.getId()).orElseThrow(() ->
                new ResourceNotFoundException("This student not found id - " + student.getId()));
        if (student.getAge() != null && student.getAge() > 0) {
            studentChange.setAge(student.getAge());
        }
        if (!student.getName().isEmpty() && student.getName().length() > 3) {
            studentChange.setName(student.getName());
        }
    }
}
