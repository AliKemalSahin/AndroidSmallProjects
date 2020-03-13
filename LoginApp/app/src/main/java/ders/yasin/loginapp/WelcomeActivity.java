package ders.yasin.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView tvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        tvUserName=findViewById(R.id.tv_UserName);
        String username = getIntent().getStringExtra("USERNAME");
        tvUserName.setText(username);

    }
}
