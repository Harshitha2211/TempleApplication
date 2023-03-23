package com.example.templeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView text,txt1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        text=findViewById(R.id.txt1);
        txt1=findViewById(R.id.txt);
        //text2=findViewById(R.id.txt4);
        String version =
                "V" + BuildConfig.VERSION_NAME;
        txt1.setText(version);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = sdf.format(new Date());
        text.setText(currentDateandTime);
    }

    public void login(View view) {
        Intent i=new Intent(MainActivity.this,Password.class);
        startActivity(i);
    }



}