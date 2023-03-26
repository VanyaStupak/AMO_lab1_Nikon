package com.example.amo_lab1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class SecondTaskActivity extends AppCompatActivity {
    private TextView result2;
    private EditText enterI, enterA, enterB,enterC;
    private Button readButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task);
        result2 = findViewById(R.id.resout2);
        enterI = findViewById(R.id.editTextTextPersonName2);
        enterA = findViewById(R.id.editTextTextPersonName21);
        enterB = findViewById(R.id.editTextTextPersonName22);
        enterC = findViewById(R.id.editTextTextPersonName23);
        readButton3 = findViewById(R.id.input1);
        Button count2 = findViewById(R.id.count2);
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#561661"));
        actionBar.setBackgroundDrawable(colorDrawable);
        count2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double I = Double.parseDouble(enterI.getText().toString());
                    double C = Double.parseDouble(enterC.getText().toString());
                    double A = Double.parseDouble(enterA.getText().toString());
                    double B = Double.parseDouble(enterB.getText().toString());
                    if (I % 3 <= 1) {
                        if (Math.pow(C,I/A) == 0 || A == 0 || Math.pow(A,I/C) == 0 || C == 0 || Math.pow(A,B-I)/Math.pow(C,I/A) <= 0 || Math.pow(B,C-I)/Math.pow(A,I/C) <= 0) {
                            result2.setText("Помилка, ділення на 0 або вираз під коренем < 0");
                        } else {
                            double res1 = Math.sqrt(Math.pow(A,B-I)/Math.pow(C,I/A)) + Math.sqrt(Math.pow(B,C-I)/Math.pow(A,I/C));
                            result2.setText(String.format("%.5f", res1));
                        }
                    } else if (Math.pow(C+A,I) == 0) {
                        result2.setText("Помилка, ділення на 0");
                    } else {
                        double res2 = ((A+B) / Math.pow(C+A,I)) + (I +Math.pow(C,I));
                        result2.setText(String.format("%.5f", res2));
                    }
                } catch (NumberFormatException e) {
                    TextView result2 = (TextView) findViewById(R.id.resout2);
                    result2.setText("Введіть коректні  числа");
                }
            }


        });
        readButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "6\n4\n7\n10.4";
                try {
                    File file = new File("example.txt");
                    FileOutputStream fileOutput = openFileOutput(file.getName(), MODE_PRIVATE);
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
                    enterI.setText(buffer.readLine());
                    enterA.setText(buffer.readLine());
                    enterB.setText(buffer.readLine());
                    enterC.setText(buffer.readLine());

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