package com.example.moon.roomdatabasedemo.activitites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.moon.roomdatabasedemo.database.MyDatabase;
import com.example.moon.roomdatabasedemo.R;
import com.example.moon.roomdatabasedemo.fragments.HomeFragment;


public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static FrameLayout frameLayout;
    public static MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //.allowMainThreadQueries() will help to execute db operation on ui thread
        myDatabase = Room.databaseBuilder(getApplicationContext(),MyDatabase.class,"userdb").build();

        frameLayout = (FrameLayout)findViewById(R.id.fragment_container);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
    }
}
