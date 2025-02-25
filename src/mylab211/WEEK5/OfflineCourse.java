package mylab211.WEEK5;

import java.time.LocalDate;

public class OfflineCourse extends Course{
    public LocalDate begin;
    public LocalDate end;
    public String campus;

    public OfflineCourse() {
        super();
        this.begin = null;
        this.end = null;
        this.campus = "";
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public void inputAll(String cID, String cName, int cr, String be, String en, String cam){
        super.inputAll(cID, cName, cr);
        
        LocalDate beginDate = LocalDate.parse(be);
        LocalDate endDate = LocalDate.parse(en);
        if (cam.isEmpty() || !validDate(beginDate, endDate)) {
            throw new IllegalArgumentException("Data input is invalid");
        }
        this.begin = beginDate;
        this.end = endDate;
        this.campus = cam;
    }

    public boolean validDate(LocalDate begin, LocalDate end) {
        return begin != null && end != null && begin.isBefore(end);
    }
    
    @Override
    public String toString() {
        return super.toString() + " - " + begin + " - " + end + " - " + campus;
    }
}
