package students;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import students.domain.Gender;
import students.domain.Student;
import students.services.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@RestController
public final class MainController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/add")
    public
    @ResponseBody
    String addStudent(@RequestParam("id") String id,
                      @RequestParam("name") String name,
                      @RequestParam("gender") Gender gender,
                      @RequestParam("grade") float grade) {
        return studentService.create(id, name, gender, grade);
    }

    @RequestMapping(value = "/addById")
    public
    @ResponseBody
    String addStudentWithId(@RequestParam("id") String id) {
        return studentService.create(id);
    }

    @RequestMapping(value = "/remove")
    public
    @ResponseBody
    String removeStudent(@RequestParam("id") String id) {
        studentService.remove(id);
        return "Student removed!";
    }


    @RequestMapping(value = "/get")
    public
    @ResponseBody
    String getStudent(@RequestParam("id") String id) {
        Student student = studentService.getStudent(id);
        return student != null ? student.toString() : "Student with id " + id + " not found in db.";
    }
}
