package ru.miroshka.hw7.converters;

import org.springframework.stereotype.Component;
import ru.miroshka.hw7.data.Student;
import ru.miroshka.hw7.dto.StudentDto;


import java.util.Optional;

@Component
public class StudentConverter {
    public Student dtoToEntity(StudentDto studentDto){
        return new Student(studentDto.getId(),studentDto.getName(),studentDto.getAge());
    }

    public StudentDto entityToDto(Student student){
        return new StudentDto(student.getId(),student.getName(),student.getAge());
    }

    public StudentDto entityToDto(Optional<Student> student) {
        return new StudentDto(student.get().getId(), student.get().getName(),student.get().getAge());
    }
}
