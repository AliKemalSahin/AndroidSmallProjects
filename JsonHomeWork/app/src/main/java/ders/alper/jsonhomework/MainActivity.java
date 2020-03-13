package ders.alper.jsonhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spTeacher;
    ListView lvInfo;
    String[] teacherNames;
    int[] teacherSicilId;

    String[] dersKod;
    String[] dersAd;
    int[] dersKredi;
    ArrayList<String> dersler=new ArrayList<String>();
    ArrayAdapter<String> adapter2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spTeacher=findViewById(R.id.spTeacher);
        lvInfo=findViewById(R.id.lvInfo);

        String URL="http://web.karabuk.edu.tr/yasinortakci/dokumanlar/web_dokumanlari/school.json";
        RequestQueue queue = Volley.newRequestQueue(this);
        RequestQueue queue2 = Volley.newRequestQueue(this);
        StringRequest request=new StringRequest(Request.Method.GET,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("OgretimElemanlari");
                    int lengthOfArray=jsonArray.length();
                    teacherNames=new String[lengthOfArray];


                    for(int i=0;i<lengthOfArray;i++){
                        JSONObject teachers=jsonArray.getJSONObject(i);
                        String names=teachers.getString("adi");
                        //int sicilId=teachers.getInt("sicil");
                        teacherNames[i]=names;
                    }

                    ArrayAdapter<String> adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,teacherNames);
                    spTeacher.setAdapter(adapter);
                }

                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Error",error.getMessage());
            }
        });

        StringRequest request2=new StringRequest(Request.Method.GET,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("Dersler");
                    int lengthOfArray=jsonArray.length();
                    dersKod=new String[lengthOfArray];
                    dersAd=new String[lengthOfArray];
                    teacherSicilId=new int[lengthOfArray];
                    dersKredi=new int[lengthOfArray];

                    for(int i=0;i<lengthOfArray;i++){
                        JSONObject teachers=jsonArray.getJSONObject(i);
                        String dKod=teachers.getString("Kodu");
                        String dName=teachers.getString("Adi");
                        int sicilId=teachers.getInt("OgretmenSicil");
                        int dKredi=teachers.getInt("Kredisi");
                        dersKod[i]=dKod;
                        dersAd[i]=dName;
                        teacherSicilId[i]=sicilId;
                        dersKredi[i]=dKredi;


                    }



                }

                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
                Log.e("Error",error.getMessage());
            }
        });

        queue.add(request);
        queue2.add(request2);
        spTeacher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int clickedIndex, long id) {
            int cid=clickedIndex+1;

                dersler.clear();


                for(int i=0;i<dersAd.length;i++){
                    if(teacherSicilId[i]==cid){
                       dersler.add(dersAd[i]);
                    }
                }


                 adapter2=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,dersler);
                    lvInfo.setAdapter(adapter2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


            lvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                    String name = (String) parent.getItemAtPosition(index);
                    String Dkod="";
                    int kredi=0;

                    for(int i=0;i<dersAd.length;i++){
                        if(dersAd[i].equals(name)){
                            Dkod=dersKod[i];
                            kredi=dersKredi[i];
                        }
                    }


                    Toast.makeText(getApplicationContext(),Dkod + "," + name + "," + kredi,Toast.LENGTH_SHORT).show();
                }
            });


    }
}
