package com.example.assignmentapicall.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.assignmentapicall.Interface.CommunicationInterface;
import com.example.assignmentapicall.R;
import com.example.assignmentapicall.fragments.UserDataFragment;
import com.example.assignmentapicall.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity  implements CommunicationInterface {

    private UserListFragment mUserListFragment;
    private UserDataFragment mUserDataFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void communicationFragment(Bundle bundle) {
        UserDataFragment userDataFragment = (UserDataFragment) getSupportFragmentManager().findFragmentById(R.id.ll_data_fragment);
        userDataFragment.setData(bundle);

    }


}
