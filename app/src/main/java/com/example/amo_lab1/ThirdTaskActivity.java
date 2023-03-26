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
                = new ColorDrawable(Color.parseColor("#561661"));
        actionBar.setBackgroundDrawable(colorDrawable);
        Button countButton = findViewById(R.id.countButton);
        EditText enterN = findViewById(R.id.enterN);
        TextView result3 = findViewById(R.id.resout3);
        Button readButton = findViewById(R.id.button6);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int n = Integer.parseInt(enterN.getText().toString());
                     if (n < 1) {
                        result3.setText("введіть n яке більше за 1");
                    } else {
                        double sum = 0;
                        int[] p = new int[n+1];
                        for(int k = 1; k <= p.length; k++) {
                            p[k-1] = k * 10;
                        }
                        for (int i = 1; i <= n; i++) {
                           double temp = 0;
                            for (int j = 1; j <= n; j++) {
                                temp += (p[i] + p[j]) / (p[j] - j);
                            }
                               sum += (p[i] + i) / temp;
                        }
                        result3.setText(String.format("%.5f", sum));
                    }
                } catch (NumberFormatException e) {
                    result3.setText("Введіть коректнe число");
                }

            }
        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "10";
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
                    enterN.setText(buffer.readLine());
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
