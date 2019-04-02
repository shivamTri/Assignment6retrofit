package com.example.assignmentapicall.model;

import java.io.Serializable;

public class UserDetail implements Serializable {
    private String name;
    private String id;

    public UserDetail(String user_name, String id) {
        this.name = user_name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
