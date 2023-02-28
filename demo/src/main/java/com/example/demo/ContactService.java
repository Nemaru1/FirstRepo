package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    //Contacts list
    private List<Contact> contacts;

    public ContactService(){
        contacts = new ArrayList<>();
        contacts.add(new Contact(1, "Jaime", 123, "jaime@gmail.com"));
        contacts.add(new Contact(2, "Luis", 456, "luis@gmail.com"));
        contacts.add(new Contact(3, "Pedro", 789, "pedro@gmail.com"));
    }

    public List<Contact> list(){
        return contacts;
    }

    //Search contact
    public Contact find(int id){
        for(Contact contact : contacts){
            if(contact.getId()==id){
                return contact;
            }
        }
        return null;
    }

    //Create contact
    public Contact save(Contact cont){
        contacts.add(cont);
        return cont;
    }

    //Update contact
    public Contact update(int id, Contact cont){
        int index = 0;
        for(Contact i : contacts){
            if(i.getId()==id){
                cont.setId(id);
                contacts.set(index, cont);
            }
        }
        return cont;
    }

    //Delete contact
    public boolean delete(int id){
        for(Contact c : contacts){
            if(c.getId()==id){
                return contacts.remove(c);
            }
        }
        return false;
    }
}
