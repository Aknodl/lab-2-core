package com.luxoft.springioc.lab2.model;

import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

public class UsualPerson implements Person {
    private int id;

    private String name;

    private Country country;

    private int age;
    private float height;
    private boolean isProgrammer;

    private List<Contact> contacts;

    public void setIsProgrammer(boolean isProgrammer) {
        this.isProgrammer = isProgrammer;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sayHello(Person person) {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public boolean isProgrammer() {
        return isProgrammer;
    }

    public void setProgrammer(boolean programmer) {
        isProgrammer = programmer;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        StringBuilder s = new StringBuilder("Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Height: " + height + "\n"
                + "Country: " + country + "\n"
                + "Is Programmer?: " + isProgrammer + "\n");
        if (!CollectionUtils.isEmpty(contacts)) {
            s.append("Contacts: ");
            for (Contact contact : contacts) {
                s.append(contact.getName()).append(": ");
                s.append(contact.getPhoneNumber()).append(", ");
                s.append(contact.getEmail()).append("; ");
            }
            s.append("\n");
        }
        return s.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsualPerson)) return false;
        UsualPerson that = (UsualPerson) o;
        return id == that.id &&
                age == that.age &&
                Float.compare(that.height, height) == 0 &&
                isProgrammer == that.isProgrammer &&
                Objects.equals(name, that.name) &&
                Objects.equals(country, that.country) &&
                Objects.equals(contacts, that.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, age, height, isProgrammer, contacts);
    }
}