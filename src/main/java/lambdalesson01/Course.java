package lambdalesson01;
/*
         Plain Old Java Object
         1-Constructor without parameter
         2-Constructor with all parameter
         3-getter() and setter()  (Java Beans)
         4-toString()

 */
public class Course {

    private String season;
    private String courseName;
    private int averageScore;
    private int numberOfStudent;



    public Course(){

    }
    public Course(String seas,String course,int aver,int num){
        this.season=seas;
        this.courseName=course;
        this.averageScore=aver;
        this.numberOfStudent=num;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }



    @Override
    public String toString() {
        return "Course{" +
                "season='" + season + '\'' +
                ", courseName='" + courseName + '\'' +
                ", averageScore=" + averageScore +
                ", numberOfStudent=" + numberOfStudent +
                '}';




    }
}
