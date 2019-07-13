package com.example.moon.roomdatabasedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Custom_Adapter extends BaseAdapter {
    Context context;
    List<User> arrayList;
    LayoutInflater layoutInflater;

    public Custom_Adapter(Context context, List<User> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_layout,null);
        TextView tvUid,tvName,tvEmail;
        tvUid = (TextView)view.findViewById(R.id.tv_uid);
        tvName = (TextView)view.findViewById(R.id.tv_name);
        tvEmail = (TextView)view.findViewById(R.id.tv_email);

        tvUid.setText(String.valueOf(arrayList.get(position).getUid()));
        tvName.setText(arrayList.get(position).getName());
        tvEmail.setText(arrayList.get(position).getEmail());

        return view;
    }
}
