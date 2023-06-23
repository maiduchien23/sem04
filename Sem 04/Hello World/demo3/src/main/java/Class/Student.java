package Class;

public class Student {

    private int id;
    private String studentName;
    private String imageUrl;
    private String grade;

    public Student(int id, String studentName, String grade, String imageUrl) {
        super();

        this.id = id;
        this.studentName = studentName;
        this.grade = grade;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}