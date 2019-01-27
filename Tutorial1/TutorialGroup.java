import java.util.List;

interface TutorialGroup {

	String getGroupNum();

    String getStudentAt(int sNo);

    void addStudent(String student);

    void setStudentAt(int sNo, String newStudent);

    void shrinkClassSize(int newSize);

    String toString();
}
