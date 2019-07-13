package com.example.moon.roomdatabasedemo;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GetUsers extends Fragment {

    ListView listView;
    ArrayAdapter arrayAdapter;
    MutableLiveData mutableLiveData;
    public GetUsers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blank, container, false);
        listView = view.findViewById(R.id.list_view);
        mutableLiveData = new MutableLiveData();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final List<User> users = MainActivity.myDatabase.getDao().getUsers();
//                ArrayList<String> userNames = new ArrayList<>();
//                for (User user: users) {
//                    String name = user.getName();
//                    userNames.add(name);
//                }
                //arrayAdapter = new ArrayAdapter(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,userNames);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mutableLiveData.setValue(users);
                    }
                });


            }
        });
        thread.start();

        mutableLiveData.observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                List<User> usersList = (List<User>) o;
                if(usersList!=null && usersList.size()>0) {
                    Custom_Adapter custom_adapter = new Custom_Adapter(getActivity().getApplicationContext(),usersList);
                    listView.setAdapter(custom_adapter);
                }
            }
        });


        return view;

    }

}
