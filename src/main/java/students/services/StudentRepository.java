package students.services;


import org.springframework.data.jpa.repository.JpaRepository;
import students.domain.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}

