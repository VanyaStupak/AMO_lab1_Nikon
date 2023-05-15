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
    private EditText enterK, enterA, enterC;
    private Button readButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_task);
        result2 = findViewById(R.id.resout2);
        enterK = findViewById(R.id.editTextTextPersonName2);
        enterA = findViewById(R.id.editTextTextPersonName21);
        enterC = findViewById(R.id.editTextTextPersonName22);

        readButton3 = findViewById(R.id.input1);
        Button count2 = findViewById(R.id.count2);
        ActionBar actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#EC920D"));
        actionBar.setBackgroundDrawable(colorDrawable);
        count2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double K = Double.parseDouble(enterK.getText().toString());
                    double C = Double.parseDouble(enterC.getText().toString());
                    double A = Double.parseDouble(enterA.getText().toString());
                    if (K < 10) {
                            double res1 = Math.pow((A+C),4) + Math.pow((A-C),2);
                            result2.setText(String.format("%.5f", res1));
                    } else {
                        double res2 = Math.pow((A-C),3) + Math.pow((A+C),2);
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
                String txt = "12\n-128\n29.5";
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
                    enterK.setText(buffer.readLine());
                    enterA.setText(buffer.readLine());
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