package mylab211.WEEK5;

public class OnlineCourse extends Course{
    public String platform;
    public String instructors;
    public String note;

    public OnlineCourse() {
        super();
        this.platform = "";
        this.instructors = "";
        this.note = "";
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getInstructors() {
        return instructors;
    }

    public void setInstructors(String instructors) {
        this.instructors = instructors;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    public void inputAll(String cID, String cName, int cr, String plform, String ins, String n){
        super.inputAll(cID, cName, cr);
        if (plform.isEmpty() || n.isEmpty())
            throw new IllegalArgumentException("Data input is invalid");
        this.platform = plform;
        this.instructors = ins;
        this.note = n;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + platform + " - " + instructors + " - " + note;
    }
}
