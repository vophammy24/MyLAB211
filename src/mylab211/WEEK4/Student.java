/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mylab211.WEEK4;

/**
 *
 * @author MY
 */
public class Student {
    private String id;
    private String name;
    private String semester;
    private String courseName;

    public Student(String id, String name, String semester, String courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(String semeter) {
        this.semester = semeter;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student [" + "ID = " + id + " | Name = " + name + " | Semeter = "
                + semester + " | Course Name = " + courseName + ']';
    }
}
