package service;

import domain.Grade;
import domain.Homework;
import domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.GradeXMLRepository;
import repository.HomeworkXMLRepository;
import repository.StudentXMLRepository;
import validation.GradeValidator;
import validation.HomeworkValidator;
import validation.StudentValidator;
import validation.Validator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    private static Service service;

    @BeforeAll
    public static void setup() {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Homework> homeworkValidator = new HomeworkValidator();
        Validator<Grade> gradeValidator = new GradeValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "students.xml");
        HomeworkXMLRepository fileRepository2 = new HomeworkXMLRepository(homeworkValidator, "homework.xml");
        GradeXMLRepository fileRepository3 = new GradeXMLRepository(gradeValidator, "grades.xml");

        service = new Service(fileRepository1, fileRepository2, fileRepository3);
    }

    @Test
    void findAllStudents() {
    }

    @Test
    void findAllHomework() {
    }

    @Test
    void findAllGrades() {
        Grade grade1 = new Grade("gid1", 6.0, 2, "feedback");
        Grade grade2 = new Grade("gid2", 7.0, 2, "feedback");
        Grade grade3 = new Grade("gid3", 8.0, 2, "feedback");
        for (Grade grade:(new Grade[]{grade1, grade2, grade3})) {
            service.saveGrade(grade.get)
        }

    }

    @Test
    @DisplayName("Saving valid student")
    void saveValidStudent() {
        Student testStudent = new Student("testId", "testName", 200);
        int ret = service.saveStudent(testStudent.getID(), testStudent.getName(), testStudent.getGroup());
        Assertions.assertEquals(ret, 0); // 1-el kell megnezni
        service.deleteStudent(testStudent.getID());
    }

    @Test
    @DisplayName("Saving invalid student")
    void saveInvalidStudent() {
        Student testStudent = new Student("testId", "testName", -100);
        int ret = service.saveStudent(testStudent.getID(), testStudent.getName(), testStudent.getGroup());
        Assertions.assertEquals(ret, 1);

    }



    @Test
    @DisplayName("Saving valid homework")
    void saveValidHomework() {
        Homework homework = new Homework("testId", "test description", 12, 3);
        int ret = service.saveHomework(homework.getID(), homework.getDescription(), homework.getDeadline(), homework.getStartline());
        Assertions.assertEquals(ret, 0);
        service.deleteHomework(homework.getID());
    }
    @Test
    @DisplayName("Saving invalid homework")
    void saveInvalidHomework() {
        Homework homework = new Homework("testId", "test description", 3, 12);
        int ret = service.saveHomework(homework.getID(), homework.getDescription(), homework.getDeadline(), homework.getStartline());
        Assertions.assertEquals(ret, 1);

        homework = new Homework("testId2", "test description", 12, -3);
        ret = service.saveHomework(homework.getID(), homework.getDescription(), homework.getDeadline(), homework.getStartline());
        Assertions.assertTrue(ret == 1);
    }

    @Test
    void saveGrade() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void deleteHomework() {
    }

    @Test
    void updateStudent() {
    }

    @Test
    void updateHomework() {
    }

    @Test
    void extendDeadline() {
    }

    @Test
    void createStudentFile() {
    }
}