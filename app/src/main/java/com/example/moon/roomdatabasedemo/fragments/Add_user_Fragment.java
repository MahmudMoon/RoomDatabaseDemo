package com.example.moon.roomdatabasedemo.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.moon.roomdatabasedemo.activitites.MainActivity;
import com.example.moon.roomdatabasedemo.R;
import com.example.moon.roomdatabasedemo.entitys.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class Add_user_Fragment extends Fragment {

    User user;
    public Add_user_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_user_, container, false);
        final EditText et_user_uid = (EditText)view.findViewById(R.id.et_id);
        final EditText et_user_name = (EditText)view.findViewById(R.id.et_name);
        final EditText et_user_email = (EditText)view.findViewById(R.id.et_email);
        Button btn_submit = (Button)view.findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User(Integer.parseInt(et_user_uid.getText().toString()),et_user_name.getText().toString(),et_user_email.getText().toString());

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.myDatabase.getDao().addUser(user);
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();

                Toast.makeText(getActivity().getApplicationContext(),"Successfully stored",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
