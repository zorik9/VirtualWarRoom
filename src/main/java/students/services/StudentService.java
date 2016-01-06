package students.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import students.domain.Gender;
import students.domain.Student;

@Service
@Repository
public class StudentService {

    private static final int MAX_STUDENTS = 1000;
    private static int savedStudents = 0;

    @Autowired
    StudentRepository studentRepository;

    public String create(String id){
        Student student = new Student(id);
        return saveAndIncStudentsSaved(student);
    }

    public String create(String id, String name, Gender gender, float grade) {
        Student student = new Student(id, name, gender, grade);
        return saveAndIncStudentsSaved(student);
    }

    private String saveAndIncStudentsSaved(Student student){
        if (studentRepository.findOne(student.getId()) != null)
            return "Student already exists";
        if (savedStudents >= MAX_STUDENTS)
            return "MAX NUMBER OF STUDENTS EXCEEDED.";
        if (studentRepository.save(student) != null) {
            savedStudents++;
            return "New student added!";
        }
        return "Error saving student to DB";
    }

    public boolean remove(String id){
        if (getStudent(id) != null){
            studentRepository.delete(id);
            savedStudents--;
            return true;
        }
        return false;
    }

    public Student getStudent(String id){
        return studentRepository.findOne(id);
    }
    
}
