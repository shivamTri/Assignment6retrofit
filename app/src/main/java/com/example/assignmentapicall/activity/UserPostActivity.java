package com.example.assignmentapicall.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.assignmentapicall.constants.Constants;
import com.example.assignmentapicall.R;
import com.example.assignmentapicall.model.UserDetailPost;
import com.example.assignmentapicall.adaptor.UserPostRecyclerAdapter;
import com.example.assignmentapicall.Interface.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserPostActivity extends AppCompatActivity {
    private RecyclerView userPost_rv;
    private UserPostRecyclerAdapter postRecyclerAdapter;
    private ArrayList<UserDetailPost> userDetailPostsArraList;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_post);
        progressBar=findViewById(R.id.pb);
        retrofitDataFetch(getIntent().getStringExtra(Constants.FRAGMENT_DATA));

    }

    /**
     * this methos is fetching the post of the user id has been passed as reference.
     * @param userId
     */
    private void retrofitDataFetch(String userId){

        Retrofit mRetrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api=mRetrofit.create(Api.class);

        Call<ArrayList<UserDetailPost>> call=api.getUserPost(Integer.parseInt(userId));
        call.enqueue(new Callback<ArrayList<UserDetailPost>>(){


            @Override
            public void onResponse(Call<ArrayList<UserDetailPost>> call, Response<ArrayList<UserDetailPost>> response) {

                userDetailPostsArraList=response.body();

                Log.d("yy", "onResponse: "+userDetailPostsArraList.get(0).getPost());
                init();
            }
            @Override
            public void onFailure(Call<ArrayList<UserDetailPost>> call, Throwable t) {
            }
        });
    }

    /**
     * initializing the reference of the views in this activity.
     */
    private void init(){
        userPost_rv=findViewById(R.id.userPost_rv);
        userPost_rv.setLayoutManager(new LinearLayoutManager(UserPostActivity.this));
        postRecyclerAdapter=new UserPostRecyclerAdapter(userDetailPostsArraList);
        userPost_rv.setAdapter(postRecyclerAdapter);
        progressBar.setVisibility(View.GONE);

    }
}
