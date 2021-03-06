package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewUsersActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    ListView lv_users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users2);
        lv_users = findViewById(R.id.lv_UserName);
        databaseHelper = new DatabaseHelper(ViewUsersActivity.this);

        ArrayList<String> userList =new ArrayList<String>();
        userList =databaseHelper.viewUsers();

        ArrayAdapter<String> adapter =new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,userList);
        lv_users.setAdapter(adapter);
    }
}
