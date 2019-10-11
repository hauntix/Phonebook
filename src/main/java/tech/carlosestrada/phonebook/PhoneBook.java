package tech.carlosestrada.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private Map<String, List<String>> book;

    public PhoneBook(Map<String, List<String>> map) {
        this.book = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<String, List<String>>());
    }

    public void add(String name, String phoneNumber) {
        if (book.containsKey(name)){
            book.get(name).add(phoneNumber);
        } else {
            book.put(name, new ArrayList<>());
            add(name, phoneNumber);
        }

    }

    public void addAll(String name, String... phoneNumbers) {
        book.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        book.remove(name);
    }

    public Boolean hasEntry(String name) {
        return book.containsKey(name);
    }

    public List<String> lookup(String name) {
        return book.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(String name: book.keySet()){
            List<String> phoneList = this.lookup(name);

            for (String number: phoneList){
                if (number.equals(phoneNumber)){
                    return name;
                }
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(book.keySet());
    }

    public Map<String, List<String>> getMap() {
        return book;
    }
}
