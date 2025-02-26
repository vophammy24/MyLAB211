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
    for (OnlineCourse onlineCourse: onlineCourseList){
        if(onlineCourse.getCourseID().equals(IDcourse)){
            onlineCourseList.remove(onlineCourse);
            return true;
        }
    }
    return false;     
    }
    
    public boolean updateOnlineCourse(String IDcourse, String newName, Integer newCr, 
                                        String newPlform, String newIns, String newNote){
        for (OnlineCourse onlineCourse : onlineCourseList){
            if(onlineCourse.getCourseID().equals(IDcourse)){
                
                if(newName != null)
                    onlineCourse.setCourseName(newName);
                if(newCr != null && newCr > 0)
                    onlineCourse.setCredits(newCr);
                if(newPlform != null )
                    onlineCourse.setPlatform(newPlform);
                if(newIns != null)
                    onlineCourse.setInstructors(newIns);
                if(newNote != null)
                    onlineCourse.setNote(newNote);
                
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
            System.out.println(onlineCourse.toString());
        }
    }
    
    public boolean checkOfflineCourse(String ID){
        if (isDuplicateID(ID)){
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
        for (OfflineCourse offlineCourse: offlineCourseList){
            if (offlineCourse.getCourseID().equals(IDcourse)){
                offlineCourseList.remove(offlineCourse);
            return true;
            }
        }
        return false;
    }
    
    public boolean updateOfflineCourse(String IDcourse, String newName, Integer newCr,
                                        String newBegin, String newEnd, String newCampus){
        for (OfflineCourse offlineCourse : offlineCourseList){
            if(offlineCourse.getCourseID().equals(IDcourse)){
                if(newName != null)
                    offlineCourse.setCourseName(newName);
                if(newCr != null && newCr > 0)
                    offlineCourse.setCredits(newCr);
                if(newBegin != null )
                    offlineCourse.begin = LocalDate.parse(newBegin);
                if(newEnd != null)
                    offlineCourse.end = LocalDate.parse(newEnd);
                if(offlineCourse.begin != null && offlineCourse.end != null && offlineCourse.begin.isAfter(offlineCourse.end)){
                    throw new IllegalArgumentException("Data input is invalid, end must be after begin");
                }
                if(newCampus != null)
                    offlineCourse.setCampus(newCampus);
                
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
            System.out.println(offlineCourse.toString());
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
        if(course != null) System.out.println(course.toString());
    }
}
