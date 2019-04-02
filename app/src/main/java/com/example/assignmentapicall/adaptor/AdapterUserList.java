package com.example.assignmentapicall.adaptor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.assignmentapicall.R;
import com.example.assignmentapicall.model.UserDetail;

import java.util.ArrayList;

public class AdapterUserList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<UserDetail> mUserArrayList;
    private OnItemClickListener mListener;
    private ProgressBar progressBar;


    public interface OnItemClickListener{
        void onItemCLick(int position);
    }
    public void setOnClickListener(OnItemClickListener listener){
        mListener=listener;
    }
    public AdapterUserList(final ArrayList<UserDetail> nameLsit){
        this.mUserArrayList =nameLsit;
    }

    @NonNull
    @Override
    /**
     * view holder method will inflate view on recler view.
     */
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_list,viewGroup,false);
        UserViewHolder userViewHolder=new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    /*
     *onBindViewHolder binds data and set the title on the recycler view.
     */
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        UserDetail userData=mUserArrayList.get(viewHolder.getAdapterPosition());

        String userName=userData.getName();
        String Id=userData.getId();
        ( (UserViewHolder) viewHolder).textViewUserName.setText(userName);
        ( (UserViewHolder) viewHolder).textViewUserId.setText(Id);

    }

    @Override
    /*
     * this method counts the size of arrayList and will iterate acccording to the size.
     */
    public int getItemCount(){

        return mUserArrayList.size();
    }


    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewUserName;
        TextView textViewUserId;

        public UserViewHolder(@NonNull final View itemView) {
            super(itemView);

            textViewUserName=itemView.findViewById(R.id.text_name);
            textViewUserId=itemView.findViewById(R.id.text_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.onItemCLick(position);
                        }
                    }
                }
            });

        }
    }
}
