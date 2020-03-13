package ders.yasin.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText etRegisterUN,etRegisterName,etRegisterMail,etRegisterPass,etConfirm;
    Button btnRegister;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etConfirm=findViewById(R.id.et_Confirm);
        etRegisterMail=findViewById(R.id.et_RegisterMail);
        etRegisterName=findViewById(R.id.et_RegisterName);
        etRegisterUN=findViewById(R.id.et_RegisterUN);
        etRegisterPass=findViewById(R.id.et_RegisterPass);
        btnRegister=findViewById(R.id.btn_Register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=etRegisterUN.getText().toString();
                String password=etRegisterPass.getText().toString();
                String name=etRegisterName.getText().toString();
                String email=etRegisterMail.getText().toString();
                String confirmPass=etConfirm.getText().toString();

                if(!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirmPass) && !TextUtils.isEmpty(name))
                    if(password.equals(confirmPass)){
                        databaseHelper=new DatabaseHelper(RegisterActivity.this);
                        if(databaseHelper.insertUser(userName,name,email,password))
                            Toast.makeText(RegisterActivity.this,"Your account is created successfully",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(RegisterActivity.this,"An error occured...",Toast.LENGTH_SHORT).show();

                    }else
                        Toast.makeText(RegisterActivity.this,"The passwords do not match",Toast.LENGTH_SHORT).show();








            }
        });
    }
}
