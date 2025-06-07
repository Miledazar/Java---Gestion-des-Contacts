package test; 

import controller.ContactController;
import controller.GroupController;
import data.DataManager;
import model.Contact;
import model.Group;

public class TestMain {
    public static void main(String[] args) {
        // Create controllers
        ContactController contactController = new ContactController();
        GroupController groupController = new GroupController();

        // Create contacts
        Contact c1 = new Contact("Alice", "Smith", "Paris");
        Contact c4 = new Contact("Alice", "Smith", "Paris");
        Contact c2 = new Contact("Bob", "Jones", "London");
        Contact c3 = new Contact("Charlie", "Brown", "New York");

        // Add phone numbers if you want
        c1.addPhoneNumber("123456789");
        c2.addPhoneNumber("987654321");
        c4.addPhoneNumber("123456789");

        // Create groups
        Group g1 = new Group("Friends", "Close friends");
        Group g2 = new Group("Work", "Work colleagues");

        // Add contacts to groups
        g1.addContact(c1);
        g1.addContact(c3);

        g2.addContact(c2);
        g2.addContact(c4);
        // Add contacts and groups to controllers
        contactController.addContact(c1);
        contactController.addContact(c3);
        contactController.addContact(c2);
        contactController.addContact(c4);

        groupController.addGroup(g1);
        groupController.addGroup(g2);
        

        DataManager.saveContacts(contactController.getAllContacts());
        DataManager.saveGroups(groupController.getAllGroups());
   

        
      System.out.println(DataManager.loadContacts());
       
        DataManager.loadGroups();
        // Test search by first name prefix
//        System.out.println("Search contacts starting with 'A':");
//        for (Contact c : contactController.searchFirstNameByPrefix("A")) {
//            System.out.println(c.getFirstName());
//        }
//
//        System.out.println("\nContacts sorted by first name:");
//        for (Contact c : contactController.getContactsSortedByFirstName()) {
//            System.out.println("First name: " + c.getFirstName()
//                + ", Last name: " + c.getLastName()
//                + ", Group: " + (c.getGroup() != null ? c.getGroup() : "None"));
//        }
//
//
//        System.out.println("\nGroups:");
//        for (Group g : groupController.getAllGroups()) {
//            System.out.println("Group: " + g.getName());
//            for (Contact c : g.getContacts()) {
//                System.out.println("    - " + c.getFirstName() + " " + c.getLastName());
//            }
//        }
//        for (Group g : c1.getGroup()) {
//            System.out.println("Group name: " + g.getName());
//        }
//
//
    }
}


