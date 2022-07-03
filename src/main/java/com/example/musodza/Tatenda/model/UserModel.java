package com.example.musodza.Tatenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
public class UserModel {
    String fname, lname;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public UserModel() {
    }
    public UserModel(String fname, String lname) {
        this.fname=fname;
        this.lname=lname;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}

