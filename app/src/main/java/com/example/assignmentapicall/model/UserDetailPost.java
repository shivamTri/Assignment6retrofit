package com.example.assignmentapicall.model;

import java.io.Serializable;
import java.sql.Struct;

public class UserDetailPost implements Serializable {
    private int id;
    private int userId;
    private String title;
    private String body;

    /**
     * Constructor of user posts.
     * @param id
     * @param userId
     * @param title
     * @param body
     */
    public UserDetailPost(int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    /**
     * getter of id.
     * @return int as id
     */
    public int getId() {
        return id;
    }

    /**
     * getter of userId.
     * @return int as userId.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * getter of title
     * @return string as title
     */
    public String getTitle() {
        return title;
    }

    /**
     * getter of post.
     * @return string as body.
     */

    public String getPost() {
        return body;
    }
}
