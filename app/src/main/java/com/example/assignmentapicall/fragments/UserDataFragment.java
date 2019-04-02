package com.example.assignmentapicall.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignmentapicall.R;
import com.example.assignmentapicall.activity.UserPostActivity;
import com.example.assignmentapicall.constants.Constants;
import com.example.assignmentapicall.model.UserDetail;


public class UserDataFragment extends Fragment {
    private View view;
    private Context mContext;
    private TextView tv_rollNum, tv_name;
    private Button btn_post;
    private UserDetail userDetails;

    public UserDataFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * button on click is being perfomermed to get all posts of a person in  the list.
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_user_data, container, false);
        init();
        btn_post=view.findViewById(R.id.addbutton);
        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, UserPostActivity.class);
                intent.putExtra(Constants.FRAGMENT_DATA, tv_rollNum.getText().toString());
                startActivity(intent);
            }
        });
        return view;
    }

    /**
     * initializing all views here .
     */
    private void init(){
        tv_rollNum =view.findViewById(R.id.et_rollNum);
        tv_name =view.findViewById(R.id.et_name);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       mContext=context;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /**
     * here data is being set to the below fragment when user clicks an item in  recycler list.
     * @param bundle
     */
    public void setData(Bundle bundle) {
        userDetails=(UserDetail)bundle.getSerializable(Constants.FRAGMENT_DATA);
        if(userDetails!=null) {
            tv_rollNum.setText(userDetails.getId().toUpperCase());
            tv_name.setText(userDetails.getName().toUpperCase());
        }
    }
}
