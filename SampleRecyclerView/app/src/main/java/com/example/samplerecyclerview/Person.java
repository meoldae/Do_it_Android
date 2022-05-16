package com.example.samplerecyclerview;

public class Person {
    String name;
    String mobile;

    public Person(String name, String mobile){
        this.name = name;
        this.mobile = mobile;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String newMobile){
        this.mobile = newMobile;
    }
}
