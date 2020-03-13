package ders.yasin.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etLoginUN,etLoginPass;
    Button btnSignIn,btnViewUsers;
    TextView tvRegister;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etLoginPass=findViewById(R.id.et_LoginPass);
        etLoginUN=findViewById(R.id.et_LoginUN);
        btnSignIn=findViewById(R.id.btn_SignIn);
        tvRegister=findViewById(R.id.tv_Register);
        btnViewUsers = findViewById(R.id.btn_AllUsers);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=etLoginUN.getText().toString();
                String password=etLoginPass.getText().toString();
                if(!TextUtils.isEmpty(userName)&& !TextUtils.isEmpty(password)){
                    databaseHelper=new DatabaseHelper(LoginActivity.this);
                    String returnPass=databaseHelper.findUser(userName);
                    if(returnPass.equals(password)){
                        Intent welcomeIntent=new Intent(getApplicationContext(),WelcomeActivity.class);
                        welcomeIntent.putExtra("USERNAME",userName);
                        startActivity(welcomeIntent);
                    }else
                        Toast.makeText(getApplicationContext(),"Username or password is wrong",Toast.LENGTH_SHORT).show();



                }
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        btnViewUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userListIntent=new Intent(getApplicationContext(),ViewUsersActivity.class);
                startActivity(userListIntent);

            }
        });
    }
}
