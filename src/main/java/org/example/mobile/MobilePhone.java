package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;


    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }


    public String getMyNumber() {
        return myNumber;
    }

    // Getter for myContacts
    public List<Contact> getMyContacts() {
        return myContacts;
    }


    public boolean addNewContact(Contact contact) {
        if (!myContacts.contains(contact)) {
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact) {
        int index = findContact(contact);
        if (index != -1) {
            myContacts.remove(index);
            return true;
        }
        return false;
    }

    public int findContact(Contact contact) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).equals(contact)) {
                return i;
            }
        }
        return -1;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int index = findContact(oldContact);
        if (index != -1) {
            myContacts.set(index, newContact);
            return true;
        }
        return false;
    }

    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        for (Contact c : myContacts) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

}
