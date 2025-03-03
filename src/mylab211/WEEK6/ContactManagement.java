package mylab211.WEEK6;

import java.util.ArrayList;
import java.util.List;

public class ContactManagement {
    private List<Contact> contactList = new ArrayList<>();
    
    public void addContact(Contact contact){
        contactList.add(contact);
    }
    
    public void displayAll(){
        System.out.println("ID\tName\tFirst Name\tLast Name\tGroup\tAddress\tPhone");
        for(Contact c: contactList){
            System.out.println(c.toString());
        }
    }
    
}
