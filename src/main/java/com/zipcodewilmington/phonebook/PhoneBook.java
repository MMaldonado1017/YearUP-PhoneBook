package com.zipcodewilmington.phonebook;



import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */

public class PhoneBook {

    private Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        this.phonebook.put(name, new ArrayList<>(Collections.singleton(phoneNumber)));
    }

    public void addAll(String name, String... phoneNumbers) {
        this.phonebook.put(name, new ArrayList<>(List.of(phoneNumbers)));
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        List<String> phoneNumbers = this.phonebook.getOrDefault(name, new ArrayList<>());
        return phoneNumbers.contains(phoneNumber);
    }

    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for(Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            if (phoneNumbers.contains(phoneNumber)) {
                return name;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(this.phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
