package com.yiriba.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView tv2;
    TextView tv3;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        share_btn = findViewById(R.id.btn2);

        int random_number = generateRandom();

        Intent i = getIntent();
        String userName = i.getStringExtra("name");
        tv3.setText(random_number+"");

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, random_number);
            }
        });

        Toast.makeText(this, "random_number: "+ random_number, Toast.LENGTH_LONG).show();
    }

    public int generateRandom() {
        Random rand = new Random();
        int upper_limit = 1000;
        int randNumber = rand.nextInt(upper_limit);
        return randNumber;
    }

    public void shareData(String userName, int random_number) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky!");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number today is: " + String.valueOf(random_number));
        startActivity(Intent.createChooser(i, "Choisis une app"));
    }
}