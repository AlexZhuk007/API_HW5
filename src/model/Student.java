package model;

public class Student extends User{
    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void getStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Student(String firstName, String lastName, String middleName, int studentId) {
        super(firstName, lastName, middleName);
        this.studentId = studentId;



    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                '}';
    }
}
