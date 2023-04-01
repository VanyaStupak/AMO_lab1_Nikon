package com.example.amo_lab1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThirdTaskActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_task);
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#3FAC5A"));
        actionBar.setBackgroundDrawable(colorDrawable);
        Button countButton = findViewById(R.id.countButton);
        EditText enterP = findViewById(R.id.enterP);
        EditText enterA = findViewById(R.id.enterA);
        EditText enterB = findViewById(R.id.enterB);
        TextView result3 = findViewById(R.id.resout3);
        Button readButton = findViewById(R.id.button6);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double P = Double.parseDouble(enterP.getText().toString());
                    double A = Double.parseDouble(enterA.getText().toString());
                    double B = Double.parseDouble(enterB.getText().toString());
                    if((A + B) < 0){
                        result3.setText("Помилка, число або вираз під коренем меньше 0");
                    }else {
                        double sum = 0.0;
                        for (int i = 1; i <= P; i++) {
                            for (int j = 1; j <= P; j++) {
                                for (int k = 1; k <= P; k++) {
                                    double term = i * (i * j * (i * j * k * Math.sqrt(A + B)));
                                    sum += term;
                                }
                            }
                        }
                        result3.setText(String.format("%.5f", sum));
                    }
                } catch (NumberFormatException e) {
                    result3.setText("Введіть коректні числа");
                }

            }
        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "5\n7\n-2";
                try {
                    File file = new File("example.txt");FileOutputStream fileOutput = openFileOutput(file.getName(), MODE_PRIVATE);
                    fileOutput.write(txt.getBytes());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    FileInputStream fileInput = openFileInput("example.txt");
                    InputStreamReader reader = new InputStreamReader(fileInput);
                    BufferedReader buffer = new BufferedReader(reader);
                    enterP.setText(buffer.readLine());
                    enterA.setText(buffer.readLine());
                    enterB.setText(buffer.readLine());
                    fileInput.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
