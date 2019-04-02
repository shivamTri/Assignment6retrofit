package com.example.assignmentapicall.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.assignmentapicall.Interface.CommunicationInterface;
import com.example.assignmentapicall.R;
import com.example.assignmentapicall.fragments.UserDataFragment;
import com.example.assignmentapicall.fragments.UserListFragment;

public class MainActivity extends AppCompatActivity  implements CommunicationInterface {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isConnected(MainActivity.this)) {
            AlertDialog mAlertDialog=buildDialog(MainActivity.this).create();
            mAlertDialog.setCanceledOnTouchOutside(false);
            mAlertDialog.show();
        }
        else {
            setContentView(R.layout.activity_main);
            Toast.makeText(MainActivity.this,getString(R.string.netwrok_available), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void communicationFragment(Bundle bundle) {
        UserDataFragment userDataFragment = (UserDataFragment) getSupportFragmentManager().findFragmentById(R.id.ll_data_fragment);
        userDataFragment.setData(bundle);

    }
    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
        else return false;
        } else
        return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle(R.string.no_internet);

        builder.setMessage(R.string.alert_message_internet);

        builder.setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();

            }
        });

        return builder;
    }


}
