package Class;

public class Student {
    private int id;
    private String name;
    private int examScore;
    private String grade;
    private String imageUrl;

    public Student(int id, String name, int examScore, String grade,String imageUrl){
        this.id = id;
        this.name = name;
        this.examScore = examScore;
        this.grade = grade;
        this.imageUrl = imageUrl;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExamScore() {
        return examScore;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
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
