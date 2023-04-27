package ru.miroshka.hw7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.miroshka.hw7.converters.StudentConverter;
import ru.miroshka.hw7.data.Student;
import ru.miroshka.hw7.dto.StudentDto;
import ru.miroshka.hw7.servicies.StudentService;
import ru.miroshka.hw7.validators.StudentValidator;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentConverter studentConverter;
    private final StudentValidator studentValidator;

    @GetMapping("/{id}")
    public List<StudentDto> findStudentById(@PathVariable Long id){
        List<StudentDto> lpDto= new ArrayList<>();
        lpDto.add(studentConverter.entityToDto(studentService.findById(id)));
        return lpDto;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto postStudent(@RequestBody StudentDto studentDto) {
        studentValidator.validate(studentDto);
        studentDto.setId(null);
        Student student = this.studentService.addStudent(studentConverter.dtoToEntity(studentDto));
        return studentConverter.entityToDto(student);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateStudent(@RequestBody StudentDto studentDto) {
        studentValidator.validate(studentDto);
        this.studentService.changeStudent(studentConverter.dtoToEntity(studentDto));
    }

    @GetMapping
    public Page<StudentDto> getStudents(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "min_age", required = false) Integer minAge,
            @RequestParam(name = "max_age", required = false) Integer maxAge,
            @RequestParam(name = "name_student", required = false) String nameStudent,
            @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
    ) {
        if (page < 1) {
            page = 1;
        }

        Page<StudentDto> d =this.studentService.find(minAge, maxAge, nameStudent, page, pageSize).map(
                p-> studentConverter.entityToDto(p)
        );
        return d;
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        this.studentService.deleteById(id);
    }
}
