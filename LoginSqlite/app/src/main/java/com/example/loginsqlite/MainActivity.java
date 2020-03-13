package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button login,register,viewUsers;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        viewUsers = findViewById(R.id.viewUsers);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String sifre = password.getText().toString();

                if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(sifre)) {
                    databaseHelper = new DatabaseHelper(MainActivity.this);
                    String returnpass = databaseHelper.findUser(name);              // sifreyi döndürüyor 4.sütun tabloda password a denk geliyor.
                    if(returnpass.equals(sifre)){
                        Intent welcomeIntent = new Intent(MainActivity.this,welcomeActivity.class);
                        welcomeIntent.putExtra("NAME",name);
                        startActivity(welcomeIntent);
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Username or password is wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        viewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usersIntent = new Intent(MainActivity.this,ViewUsersActivity.class);
                startActivity(usersIntent);
            }
        });


    }
}
