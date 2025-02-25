package mylab211.WEEK5;

import java.time.LocalDate;
import java.util.*;

public class CourseManagement {
    private List<OnlineCourse> onlineCourseList = new ArrayList<>();
    private List<OfflineCourse> offlineCourseList = new ArrayList<>();
    
    public boolean isDuplicateID(String ID) {
        for (OnlineCourse course : onlineCourseList) {
            if (course.getCourseID().equals(ID)) {
                return true;
            }
        }
        for (OfflineCourse course : offlineCourseList) {
            if (course.getCourseID().equals(ID)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkOnlineCourse(String ID){
        if (isDuplicateID(ID)) {
            System.out.println("Data input is invalid, ID must be unique");
            return false;
        }
        return true;
    }
    
    public boolean addOnlineCourse(OnlineCourse onc){
        if (checkOnlineCourse(onc.getCourseID())){
            onlineCourseList.add(onc);
            return true;
        }
        return false;
    }
    public boolean deleteOnlineCourse(String IDcourse){
        OnlineCourse courseRemove = null;
        for (OnlineCourse onlineCourse: onlineCourseList){
            if (onlineCourse.getCourseID().equals(IDcourse)){
                courseRemove = onlineCourse;
            }
        }
        if (courseRemove != null){
            onlineCourseList.remove(courseRemove);
            return true;
        }
        return false;
    }
    
    public boolean updateOnlineCourse(String IDcourse, String newName, Integer newCr, 
                                        String newPlform, String newIns, String newNote){
        for (OnlineCourse onlineCourse : onlineCourseList){
            if(onlineCourse.getCourseID().equals(IDcourse)){
                System.out.println("\n*** Search results ***");
                System.out.println(onlineCourse);

                System.out.println("*** Updating ***");
                System.out.println("Note: Enter empty if you don't want to change it.");
                
                if(newName != null)
                    onlineCourse.courseName = newName;
                if(newCr != null && newCr > 0)
                    onlineCourse.credits = newCr;
                if(newPlform != null )
                    onlineCourse.platform = newPlform;
                if(newIns != null)
                    onlineCourse.instructors = newIns;
                if(newNote != null)
                    onlineCourse.note = newNote;
                
                System.out.println("Updated successfully.");
                return true;
            }
        }
        return false;
    }
    
    public void showOnlineCourse(){
        if(onlineCourseList.isEmpty()){
            System.out.println("No online course available!");
            return;
        }
        System.out.println("Course ID - Course Name - Credits - Platforms - Instructors - Note");
        for (OnlineCourse onlineCourse: onlineCourseList){
            System.out.println(onlineCourse);
        }
    }
    
    public boolean checkOfflineCourse(String ID){
        if (isDuplicateID(ID)){
            System.out.println("Data input is invalid, ID must be unique");
            return false;
        }
        return true;
    }
    
    public boolean addOfflineCourse(OfflineCourse offc){
        if (checkOfflineCourse(offc.getCourseID())){
            offlineCourseList.add(offc);
            return true;
        }
        return false;
    }
    
    public boolean deleteOfflineCourse(String IDcourse){
        OfflineCourse courseRemove = null;
        for (OfflineCourse offlineCourse: offlineCourseList){
            if (offlineCourse.getCourseID().equals(IDcourse)){
                courseRemove = offlineCourse;
            }
        }
        if (courseRemove != null){
            offlineCourseList.remove(courseRemove);
            return true;
        }
        return false;
    }
    
    public boolean updateOfflineCourse(String IDcourse, String newName, Integer newCr,
                                        String newBegin, String newEnd, String newCampus){
        for (OfflineCourse offlineCourse : offlineCourseList){
            if(offlineCourse.getCourseID().equals(IDcourse)){
                if(newName != null)
                    offlineCourse.courseName = newName;
                if(newCr != null && newCr > 0)
                    offlineCourse.credits = newCr;
                if(newBegin != null )
                    offlineCourse.begin = LocalDate.parse(newBegin);
                if(newEnd != null)
                    offlineCourse.end = LocalDate.parse(newEnd);
                if(offlineCourse.begin != null && offlineCourse.end != null && offlineCourse.begin.isAfter(offlineCourse.end)){
                    throw new IllegalArgumentException("Data input is invalid, end must be after begin");
                }
                if(newCampus != null)
                    offlineCourse.campus = newCampus;
                
                System.out.println("Updated successfully.");
                return true;
            }
        }
        return false;
    }
    
    public void showOfflineCourse(){
        if(offlineCourseList.isEmpty()){
            System.out.println("No offline course available!");
            return;
        }
        System.out.println("Course ID - Course Name - Credits - Begin - End - Campus");
        for (OfflineCourse offlineCourse: offlineCourseList){
            System.out.println(offlineCourse);
        }
    }
    
    public void showAllCourse(){
        System.out.println("Course ID - Course Name - Credits");
        for (OnlineCourse onlineCourse: onlineCourseList){
            System.out.println(onlineCourse.getCourseID() + " - " +
                               onlineCourse.getCourseName() + " - " + 
                                onlineCourse.getCredits());
        }
        for (OfflineCourse offlineCourse: offlineCourseList){
            System.out.println(offlineCourse.getCourseID() + " - " +
                               offlineCourse.getCourseName() + " - " + 
                                offlineCourse.getCredits());
        }
    }

    public Course findCourse(String IDCourse){
        for (OnlineCourse course: onlineCourseList){
            if( course.getCourseID().equals(IDCourse))
                return course;
        }
        for (OfflineCourse course: offlineCourseList){
            if( course.getCourseID().equals(IDCourse))
                return course;
        }        
        return null;
    }
    
    public void searchCourse(String IDcourse){
        Course course = findCourse(IDcourse);
        if(course != null) System.out.println(course);
    }
}
