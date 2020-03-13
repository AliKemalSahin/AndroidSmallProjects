package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class welcomeActivity extends AppCompatActivity {
    TextView tv;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tv = findViewById(R.id.tv);

        name = getIntent().getStringExtra("NAME");
        tv.setText(name);
    }
}
