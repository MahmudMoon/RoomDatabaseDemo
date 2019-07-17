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
public class DeleteFragment extends Fragment {

    User user;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        final EditText editText = view.findViewById(R.id.editText);
        Button delete_btn = view.findViewById(R.id.button);

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User();
                final int uid = Integer.parseInt(editText.getText().toString());
                //user.setUid(uid);
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.myDatabase.getDao().removeUser(uid);
                    }
                });

                thread.start();

                Toast.makeText(getActivity().getApplicationContext(),"Deleted",Toast.LENGTH_SHORT).show();

            }
        });

        return view;

    }

}
