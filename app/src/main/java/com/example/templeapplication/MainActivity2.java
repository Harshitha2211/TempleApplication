package com.example.templeapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity2 extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TextView text,txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        text=findViewById(R.id.txt1);
        txt1=findViewById(R.id.txt);
        String version =
                "V" + BuildConfig.VERSION_NAME;
        txt1.setText(version);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = sdf.format(new Date());
        text.setText(currentDateandTime);
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.view);
        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter=new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragments(new Tickets(),"tickets");
        vpAdapter.addFragments(new Report(),"report");
        viewPager.setAdapter(vpAdapter);
    }
}