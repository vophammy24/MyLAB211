package mylab211.WEEK6;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ContactManagement {
    List<Contact> contactList = new ArrayList<>();
    
    public boolean addContact(String firstName, String lastName, String group, String address, String phone){
        int newID;
        if(contactList.isEmpty()){
            newID = 1;
        } else newID = contactList.get(contactList.size() - 1 ).getID() + 1;
        Contact newContact =  new Contact(newID, firstName, lastName, group, address, phone);
        contactList.add(newContact);
        return true;
    }
    
    public void displayAll(){
        System.out.println("ID\tName\tGroup\tAddress\tPhone");
        for(Contact contact: contactList){
            System.out.println(contact.toString());
        }
    }
    
    public boolean deleteContact(int id){
        for(Contact contact: contactList){
            if(contact.getID() == id){
                contactList.remove(contact);
                System.out.println("Delete Contact Successful.");
                return true;
            }
        }
        System.out.println("Delete Contact Fail.");
        return false;
    }
}
