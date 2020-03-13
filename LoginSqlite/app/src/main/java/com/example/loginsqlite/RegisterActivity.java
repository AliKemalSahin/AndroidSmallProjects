package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText ad,kullaniciAd,email,sifre,sifreKontrol;
    String name,userName,userMail,userPass,userPass2;
    ImageButton kayit;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ad = findViewById(R.id.et_name);
        kullaniciAd = findViewById(R.id.et_username);
        email = findViewById(R.id.et_email);
        sifre = findViewById(R.id.et_password);
        sifreKontrol = findViewById(R.id.et_password2);
        kayit = findViewById(R.id.kayit);

        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ad.getText().toString();
                userName = kullaniciAd.getText().toString();
                userMail = email.getText().toString();
                userPass = sifre.getText().toString();
                userPass2 = sifreKontrol.getText().toString();


                databaseHelper = new DatabaseHelper(RegisterActivity.this);
                if(!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userPass) && !TextUtils.isEmpty(userPass2) && !TextUtils.isEmpty(name)){
                    if(userPass.equals(userPass2)){
                        if(databaseHelper.insertUser(userName,name,userMail,userPass))
                            Toast.makeText(getApplicationContext(),"Your account is created Successfully",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getApplicationContext(),"An error occured...",Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"The passwords do not match",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}
