package service;

import model.Student;
import model.StudyGroup;
import model.Teacher;

import java.util.List;

public class StudyGroupService {

    // Метод для формирования и возврата объекта StudentGroup
    public StudyGroup createStudentGroup(Teacher teacher, List<Student> students) {
        return new StudyGroup(teacher, students);
    }
}
