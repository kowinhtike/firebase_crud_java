package com.example.firebasecrud;

import java.security.PublicKey;

public class Task {
    private String id;
    private String title;
    private String description;

    public  Task(){

    }
    public Task(String id, String title,String desription) {
        this.id = id;
        this.title = title;
        this.description = desription;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public  String getDescription(){
        return description;
    }

}