package com.example.zulqarnain.studentrepo.model;

/**
 * Created by Zul Qarnain on 9/26/2017.
 */

public class Student {
    int st_id;
    String st_name;
    String st_ph;
    String st_email;
    String st_img;


    public Student(int st_id, String st_name, String st_ph, String st_email, String st_img) {
        this.st_id = st_id;
        this.st_name = st_name;
        this.st_ph = st_ph;
        this.st_email = st_email;
        this.st_img = st_img;
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public String getSt_ph() {
        return st_ph;
    }

    public void setSt_ph(String st_ph) {
        this.st_ph = st_ph;
    }

    public String getSt_email() {
        return st_email;
    }

    public void setSt_email(String st_email) {
        this.st_email = st_email;
    }

    public String getSt_img() {
        return st_img;
    }

    public void setSt_img(String st_img) {
        this.st_img = st_img;
    }
}
