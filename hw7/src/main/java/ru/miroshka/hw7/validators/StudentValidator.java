package ru.miroshka.hw7.validators;

import org.springframework.stereotype.Component;
import ru.miroshka.hw7.dto.StudentDto;
import ru.miroshka.hw7.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentValidator {
    public  void  validate (StudentDto productDto){
        List<String> errors = new ArrayList<>();
        if (productDto.getAge() < 15) {
            errors.add("Возраст  не может быть меньше 15");
        }

        if (productDto.getName().isBlank()){
            errors.add("Студент не может иметь пустое имя");
        }

        if (!errors.isEmpty()){
            throw new ValidationException(errors );
        }
    }
}
