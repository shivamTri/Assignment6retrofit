package com.example.assignmentapicall.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.assignmentapicall.Interface.CommunicationInterface;
import com.example.assignmentapicall.R;
import com.example.assignmentapicall.adaptor.AdapterUserList;
import com.example.assignmentapicall.constants.Constants;
import com.example.assignmentapicall.model.UserDetail;
import com.example.assignmentapicall.Interface.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UserListFragment extends Fragment {
    private CommunicationInterface communicationInterface;
    //private UserDetail userDetail;
    private View view;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private AdapterUserList mAdapterUserList;
    private ArrayList<UserDetail> mUserArrayList;
   // private Button btn_post;


    public UserListFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserArrayList =new ArrayList<>();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view= inflater.inflate(R.layout.fragment_user_list, container, false);
        retrofitDataFetch();

        return view;
    }

    /**
     * data is being sent to  user data fragment using communication interface.
     * @param position
     */
    private void onClickRecycle(int position){
        Bundle bundle=new Bundle();
        bundle.putSerializable(Constants.FRAGMENT_DATA, mUserArrayList.get(position));
        communicationInterface.communicationFragment(bundle);
    }

    /**
     * adapter is set to the recycler view
     * on click is being performed in recycler item.
     */
    private void init(){
       mRecyclerView = view.findViewById(R.id.rv_user_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapterUserList = new AdapterUserList(mUserArrayList);
        mRecyclerView.setAdapter(mAdapterUserList);
        mAdapterUserList.setOnClickListener(new AdapterUserList.OnItemClickListener() {
            @Override
            public void onItemCLick(int position) {
                onClickRecycle(position);
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
        if (context instanceof CommunicationInterface) {
            communicationInterface = (CommunicationInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement Cummunication");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        communicationInterface=null;
    }

    /**
     * data from the URL is being fetched and stored in the arraylist from json file.
     */
    private void retrofitDataFetch(){

        Retrofit mRetrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api=mRetrofit.create(Api.class);

        Call<ArrayList<UserDetail>> call=api.getUser();
        call.enqueue(new Callback<ArrayList<UserDetail>>(){


            @Override
            public void onResponse(Call<ArrayList<UserDetail>> call, Response<ArrayList<UserDetail>> response) {
                mUserArrayList =response.body();
                Log.d(mUserArrayList.get(0).getName(), "onResponse: ");
                init();

            }
            @Override
            public void onFailure(Call<ArrayList<UserDetail>> call, Throwable t) {
            }
        });
    }

}
