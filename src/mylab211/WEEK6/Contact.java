package mylab211.WEEK6;

public class Contact {
    int ID;
    String fullName;
    String firstName;
    String lastName;
    String group;
    String address;
    String phone;

    public Contact(int ID, String fullName, String firstName, String lastName, String group, String address, String phone) {
        this.ID = ID;
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGroup() {
        return group;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return ID + "\t" + fullName + "\t" + group + "\t" + address + "\t" + phone;
    }
    
    
}
