package com.example.moon.roomdatabasedemo;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        Button btn_add = (Button)view.findViewById(R.id.add_user);
        Button btn_get = (Button)view.findViewById(R.id.get_user);
        Button btn_remove = (Button)view.findViewById(R.id.remove_user);
        Button btn_update = (Button)view.findViewById(R.id.Update_user);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new Add_user_Fragment()).addToBackStack(null).commit();
            }
        });

        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new GetUsers()).addToBackStack(null).commit();

            }
        });

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteFragment()).addToBackStack(null).commit();
            }
        });

        return view;
    }

}
