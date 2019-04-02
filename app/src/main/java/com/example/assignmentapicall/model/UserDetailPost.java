package com.example.assignmentapicall.model;

import java.io.Serializable;

public class UserDetailPost implements Serializable {
    private int id;
    private int userId;
    private String title;
    private String body;

    public UserDetailPost(int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getPost() {
        return body;
    }
}
