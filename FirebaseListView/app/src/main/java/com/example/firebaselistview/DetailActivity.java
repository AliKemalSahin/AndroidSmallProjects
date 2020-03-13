package com.example.firebaselistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.EventListener;
import java.util.Map;

public class DetailActivity extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference mRef;

    TextView tvAd,tvAge,tvTeam;
    int sayac = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvAd = findViewById(R.id.tvAd);
        tvAge = findViewById(R.id.tvAge);
        tvTeam = findViewById(R.id.tvTeam);

        final int position = getIntent().getIntExtra("position",0);

        database = FirebaseDatabase.getInstance();
        mRef = database.getReference("tablePlayers");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postDataSnapshot : dataSnapshot.getChildren()){
                    //Toast.makeText(getApplicationContext(),postDataSnapshot.getKey(),Toast.LENGTH_SHORT).show();

                    if(position == Integer.parseInt(postDataSnapshot.getKey())){
                        Map <String,String> map = (Map<String,String>) postDataSnapshot.getValue();
                        tvAd.setText(map.get("name"));
                        tvAge.setText(map.get("age"));
                        tvTeam.setText(map.get("team"));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });














    }
}
