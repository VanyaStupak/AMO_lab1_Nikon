package com.example.amo_lab1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#EC920D"));
        actionBar.setBackgroundDrawable(colorDrawable);

    }

    public void startNewActivity1(View v) {
        Intent intent = new Intent(this, FirstTaskActivity.class);
        startActivity(intent);
    }
    public void startNewActivity2(View v) {
        Intent intent = new Intent(this, SecondTaskActivity.class);
        startActivity(intent);
    }
    public void startNewActivity3(View v) {
        Intent intent = new Intent(this, ThirdTaskActivity.class);
        startActivity(intent);
    }
}