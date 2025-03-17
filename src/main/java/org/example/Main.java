package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;

import java.util.ArrayList;

import static org.example.models.Grocery.startGrocery;

public class Main {
    public static void main(String[] args) {
        startGrocery();


        Contact contact1 = Contact.createContact("Bob", "31415926");
        Contact contact2 = Contact.createContact("Alice", "16180339");
        Contact contact3 = Contact.createContact("Tom", "11235813");


        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);


        MobilePhone mobilePhone = new MobilePhone("11111111", contacts);


        mobilePhone.printContacts();


        Contact newContact = Contact.createContact("Jane", "23571113");
        System.out.println("Yeni kişi ekleniyor: " + newContact.getName() + " -> " + newContact.getPhoneNumber());
        mobilePhone.addNewContact(newContact);
        mobilePhone.printContacts();


        System.out.println("Silinen kişi: " + contact2.getName());
        mobilePhone.removeContact(contact2);
        mobilePhone.printContacts();


        System.out.println("Aranan kişi: Alice");
        Contact contactToFind = new Contact("Alice", "16180339");
        Contact foundContact = mobilePhone.queryContact("Alice");

        if (foundContact != null) {
            System.out.println("Bulunan kişi: " + foundContact.getName() + " -> " + foundContact.getPhoneNumber());
        } else {
            System.out.println("Kişi bulunamadı!");
        }


        Contact updatedContact = Contact.createContact("Tom", "98765432");
        boolean updated = mobilePhone.updateContact(contact3, updatedContact);
        if (updated) {
            System.out.println("Kişi güncellendi: " + updatedContact.getName() + " -> " + updatedContact.getPhoneNumber());
        } else {
            System.out.println("Kişi güncellenemedi.");
        }
        mobilePhone.printContacts();

    }
}
