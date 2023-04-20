package com.example.templeapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Tickets extends Fragment {
    static TextView txt;
    static Button cbtn,pbtn;
    static DatabaseHelper databaseHelper;
    private ArrayList<MyListData> courseModalArrayList;


    MyListData[] myListData = new MyListData[]{
            new MyListData("Entrance", 20, R.drawable.entrance),
            new MyListData("SpecialEntry", 50, R.drawable.entry),
            new MyListData("ARCHANA", 50, R.drawable.archana),
            new MyListData("Arathi", 25, R.drawable.arathi),
            new MyListData("Laddu", 25, R.drawable.laddu),
            new MyListData("Vada", 20, R.drawable.vada),
            new MyListData("Pulihora", 25, R.drawable.pulihora),
    };




    public Tickets() {


        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tickets, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle);
        txt=view.findViewById(R.id.textView2);
        cbtn=view.findViewById(R.id.clear);
        pbtn=view.findViewById(R.id.print);
        MyListadapter adapter = new MyListadapter(myListData);
        databaseHelper=new DatabaseHelper(getContext());
        Context context = null;
        RecyclerView.LayoutManager manager = new GridLayoutManager(context, 3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        return view;



    }




}