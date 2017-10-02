package com.example.admin.savingdata;

/**
 * Created by Admin on 10/2/2017.
 */

public class Person {
    String Name, Gender, Age;

    public Person(String name, String gender, String age) {
        Name = name;
        Gender = gender;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Age='" + Age + '\'' +
                '}';
    }
}
