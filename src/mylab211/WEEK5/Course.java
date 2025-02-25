package mylab211.WEEK5;

public class Course {
    protected String courseID; //use protected for parents
    protected String courseName;
    protected int credits;

    public Course() {
        this.courseID = "";
        this.courseName = "";
        this.credits = 0;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }
    
    public void inputAll(String cID, String cName, int cr){
        if (cID.isEmpty() || cName.isEmpty() || cr <= 0) 
            throw new IllegalArgumentException("Data input is invalid");
        this.courseID = cID;
        this.courseName = cName;
        this.credits = cr;
    }
        
    @Override
    public String toString() {
        return courseID + " - " + courseName + " - " + credits;
    }
}
