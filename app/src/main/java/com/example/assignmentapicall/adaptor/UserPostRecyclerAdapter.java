package com.example.assignmentapicall.adaptor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignmentapicall.R;
import com.example.assignmentapicall.model.UserDetailPost;

import java.util.ArrayList;

public class UserPostRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<UserDetailPost> userDetailPostsArrayList;

    public UserPostRecyclerAdapter(ArrayList<UserDetailPost> userDetailPostsArrayList) {
        this.userDetailPostsArrayList = userDetailPostsArrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_post_layout,viewGroup,false);
        UserPostHolder userPostHolder=new UserPostHolder(view);
        return userPostHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int position1=viewHolder.getAdapterPosition();
        UserDetailPost userDetailPost= userDetailPostsArrayList.get(position1);
               int userId=userDetailPost.getUserId();
        Log.d("id", "onBindViewHolder: "+userDetailPost.getPost());
        int id=userDetailPost.getId();
        String title=userDetailPost.getTitle();
        String post=userDetailPost.getPost();
        ((UserPostHolder)viewHolder).id.setText(Integer.toString(id));
        ((UserPostHolder)viewHolder).userId.setText(Integer.toString(userId));
        ((UserPostHolder)viewHolder).title.setText(title);
        ((UserPostHolder)viewHolder).post.setText(post);

    }

    @Override
    public int getItemCount() {
        if(userDetailPostsArrayList !=null) {
            return userDetailPostsArrayList.size();
        }

        else {
            return 0;
        }


    }
    public class UserPostHolder extends RecyclerView.ViewHolder {
            TextView userId;
            TextView id;
            TextView title;
            TextView post;
        public UserPostHolder(@NonNull View itemView) {
            super(itemView);
            userId=itemView.findViewById(R.id.UserId);
            id =itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);
            post=itemView.findViewById(R.id.body);
        }
    }
}
