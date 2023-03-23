package com.example.templeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Password extends AppCompatActivity {
    EditText ed1;
    TextView text, txt1;
    public static final String DATA = "0123456789";
    final Random random = new Random();
    String pass;
    public int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        getSupportActionBar().hide();
        text = findViewById(R.id.txt1);
        txt1 = findViewById(R.id.txt);
        String version =
                "V" + BuildConfig.VERSION_NAME;
        txt1.setText(version);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = sdf.format(new Date());
        text.setText(currentDateandTime);
        ed1 = findViewById(R.id.edit);
        change();


    }


    private void change() {
        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 6; i++) {
            sb.append(DATA.charAt(random.nextInt(DATA.length())));
            pass = String.valueOf(sb);
            counter++;
            Timer();


        }
        System.out.println();
        System.out.println(sb);
        Toast.makeText(Password.this, "" + sb, Toast.LENGTH_LONG).show();
    }

    private void Timer() {
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            //your method here
                        } catch (Exception e) {
                        }
                    }
                });
            }
        };
        timer.schedule(doAsynchronousTask, 0, 120000);
    }


    public void pass(View view) {

        if (ed1.length() == 0) {
            ed1.setError("Please enter password");
        }
        if (ed1.getText().toString().equals(pass)) {
            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();
            Intent in = new Intent(Password.this, MainActivity2.class);
            in.setAction("android.permission.BIND_DEVICE_ADMIN");
            startActivity(in);
        } else {
            Toast.makeText(this, "Login Unsuccessfull", Toast.LENGTH_SHORT).show();
        }
        ed1.setText("");
    }
}