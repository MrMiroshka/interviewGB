package ru.miroshka.hw7.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.miroshka.hw7.data.Student;

public class StudentsSpecifications {
    //>=
    public static Specification<Student> ageGreaterOrEqualsThen(Integer cost) {
        return (Specification<Student>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .greaterThanOrEqualTo(root.get("age"), cost);
    }

    //<=
    public static Specification<Student> ageLesserOrEqualsThen(Integer cost) {
        return (Specification<Student>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .lessThanOrEqualTo(root.get("age"), cost);
    }

    //ищем студента по части имени
    public static Specification<Student> nameLike(String nameStudent) {
        return (Specification<Student>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .like(root.get("name"), String.format("%%%s%%",nameStudent));
    }

}

