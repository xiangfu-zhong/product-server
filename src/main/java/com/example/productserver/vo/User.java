package com.example.productserver.vo;

import java.io.Serializable;

public class User implements Serializable {

    private Long serialVersionUID = 1L;

    private String user_no;

    private String user_name;

    private String user_female;

    private char user_age;

    public String getUser_no() {
        return user_no;
    }

    public void setUser_no(String user_no) {
        this.user_no = user_no;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_female() {
        return user_female;
    }

    public void setUser_female(String user_female) {
        this.user_female = user_female;
    }

    public char getUser_age() {
        return user_age;
    }

    public void setUser_age(char user_age) {
        this.user_age = user_age;
    }
}
