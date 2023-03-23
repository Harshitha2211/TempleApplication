package com.example.templeapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Report extends Fragment {
    ArrayList<MyListData> courseModalArrayList = new ArrayList<>();
    DatabaseHelper db;
    TextView txt;

    public Report() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);
        txt=view.findViewById(R.id.text);
        db=new DatabaseHelper(getContext());
        courseModalArrayList = db.readCourses();
        System.out.println(courseModalArrayList);
        //txt.setText(courseModalArrayList);
        return view;
    }
}