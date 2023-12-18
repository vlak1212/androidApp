package com.example.java_androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
        Button backButton = (Button) findViewById(R.id.buttonGoBack);
        Button ledButton = (Button) findViewById(R.id.buttonToggleLED);
        Button fingerButton = (Button) findViewById(R.id.buttonCountFingers);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choices.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ledButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choices.this, ToggleLed.class);
                startActivity(intent);
            }
        });
        fingerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choices.this, FingerCounter.class);
                startActivity(intent);
            }
        });
    }
}