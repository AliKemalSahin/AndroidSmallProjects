package com.example.firebaselistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class AddActivity extends AppCompatActivity {
    EditText name,age,team;
    Button ekle;
    Integer count;

    FirebaseDatabase database;
    DatabaseReference mRef,mainRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        team = findViewById(R.id.team);
        ekle = findViewById(R.id.ekle);

        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("lastIndex");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postDataSnapshot : dataSnapshot.getChildren()){
                    count = Integer.parseInt(postDataSnapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad = name.getText().toString();
                String yas = age.getText().toString();
                String takim = team.getText().toString();

                count += 1;

                database = FirebaseDatabase.getInstance();
                mainRef = database.getReference("tablePlayers");
                DatabaseReference indexRef = mainRef.child(count.toString());
                DatabaseReference valueName = indexRef.child("name");
                DatabaseReference valueAge = indexRef.child("age");
                DatabaseReference valueTeam = indexRef.child("team");

                valueName.setValue(ad);
                valueAge.setValue(yas);
                valueTeam.setValue(takim);

                DatabaseReference countRef = mRef.child("lindex");
                countRef.setValue(count.toString());
            }
        });






    }
}
