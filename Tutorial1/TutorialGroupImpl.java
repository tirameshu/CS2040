import java.util.List;
import java.util.ArrayList;

class TutorialGroupImpl implements TutorialGroup {
    private String groupNum;
    private List<String> students;

    public TutorialGroupImpl(String groupNum) {
        this.groupNum = groupNum;
        students = new ArrayList<String>();
    }

    public String getGroupNum() {
        return groupNum;
    }

    public String getStudentAt(int sNo) {
        return students.get(sNo - 1);
    }

    public void addStudent(String student) {
        students.add(student);
    }

    public void setStudentAt(int sNo, String newStudent) {
        if (sNo <= students.size()) {
            students.set(sNo - 1, newStudent);
        } else {
            for (int i = 0; i < sNo - students.size() - 1; i++) {
                students.add("");
            }
            students.add(newStudent);
        }
    }

    public void shrinkClassSize(int newSize) {
        if (newSize < students.size()) {
            int orig = students.size();
            for (int i = orig; i > newSize; i--) {
                students.remove(i - 1);
            }
        }
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < students.size(); i++) {
            result += (i + 1) + ":" + students.get(i) + ", ";
        }
        result += "]";
        return result;
    }
}
