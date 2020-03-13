package com.example.fragmentwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);









        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentFirst fragmentFirst = new FragmentFirst();
        fragmentTransaction.add(R.id.frameLayout,fragmentFirst).commit();


        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
        FragmentSecond fragmentSecond = new FragmentSecond();
        fragmentTransaction2.add(R.id.frameLayout2,fragmentSecond).commit();




    }
}
