package com.example.george.firstproject;

/**
 * Created by George on 10/31/16.
 */
public class Student {
    private int id;
    private String name;
    private String sex;
    private String birthday;
    private String email;
    private String homeLocation;

    public Student(){

    }

    public Student(int id, String name, String sex, String birthday, String email, String homeLocation) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.email = email;
        this.homeLocation = homeLocation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHomeLocation(String homeLocation) {
        this.homeLocation = homeLocation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getHomeLocation() {
        return homeLocation;
    }
}
