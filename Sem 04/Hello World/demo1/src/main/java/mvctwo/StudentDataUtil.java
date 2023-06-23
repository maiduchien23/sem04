package mvctwo;
import java.util.ArrayList;
import java.util.List;

public class StudentDataUtil {

    public static List<Student> getStudents(){
        List<Student> studentsList =new ArrayList<>();

        studentsList.add(new Student("Pham", "Tai","phamtai@fpt.vn"));
        studentsList.add(new Student("Nguyen", "Minh","nguyenminh@fpt.vn"));
        studentsList.add(new Student("Chau", "Anh","chauanh@fpt.vn"));
        return studentsList;
    }
}