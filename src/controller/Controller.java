package controller;

import model.*;
import service.DataService;
import service.StudyGroupService;
import view.StudentView;

import java.util.List;

public class Controller {
    private final DataService dataService = new DataService();
    private final StudyGroupService groupService = new StudyGroupService();
    private final StudentView view = new StudentView();

    // Создание студента
    public void createStudent(String firstName, String lastName, String middleName) {
        dataService.create(firstName, lastName, middleName, Type.STUDENT);
    }

    // Получение и вывод всех студентов
    public void getAllStudent() {
        List<User> userList = dataService.getAllStudent();
        for (User user : userList) {
            if (user instanceof Student) {
                Student student = (Student) user;
                view.printOnConsole(student);
            } else {
                System.out.println("User is not a Student: " + user);
            }
        }
    }

    // Создание группы студентов
    public void createStudentGroup(int teacherId) {
        // Получение учителя по его ID
        Teacher teacher = dataService.getTeacherById(teacherId);
        if (teacher == null) {
            System.out.println("Teacher with ID " + teacherId + " not found.");
            return;
        }

        // Получение всех студентов
        List<Student> students = dataService.getAllStudents();

        // Формирование группы студентов
        StudyGroup studentGroup = groupService.createStudentGroup(teacher, students);

        // Вывод информации о группе студентов
        System.out.println(studentGroup);
    }
}
