package com.example.assignmentapicall.Interface;

import com.example.assignmentapicall.model.UserDetail;
import com.example.assignmentapicall.model.UserDetailPost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL="https://jsonplaceholder.typicode.com";
    @GET("/users")
    Call<ArrayList<UserDetail>> getUser();

    @GET("/posts")
    Call<ArrayList<UserDetailPost>> getUserPost(@Query("userId") int userId);
}
