package com.example.fragmentwork;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class FragmentFirst extends Fragment {

    public String[] name;
    public String[] version;
    public String[] apino;
    public ListView versionList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_first,container, false);

        versionList = viewGroup.findViewById(R.id.versionList);



        versionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentSecond fragmentSecond = new FragmentSecond();

                Bundle args = new Bundle();
                String namee = name[position];
                String versionn = version[position];
                String apinoo = apino[position];
                args.putString("Name", namee);
                args.putString("Version", versionn);
                args.putString("APINo", apinoo);


                System.out.println("haha: " + namee + versionn + apinoo);

                fragmentSecond.setArguments(args);

                getFragmentManager().beginTransaction().replace(R.id.frameLayout2, fragmentSecond).commit();
            }
        });

        String URL="https://api.myjson.com/bins/nqppk";

        RequestQueue queue = Volley.newRequestQueue(this.getContext());

        StringRequest request=new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("Versions");
                            int lengthOfArray=jsonArray.length();

                            name = new String[lengthOfArray];
                            version = new String[lengthOfArray];
                            apino = new String[lengthOfArray];

                            for(int i=0;i<lengthOfArray;i++){
                                JSONObject ogretmenler=jsonArray.getJSONObject(i);
                                name[i]=ogretmenler.getString("Name");
                                version[i]=ogretmenler.getString("Version");
                                apino[i]=ogretmenler.getString("APINo");
                            }

                            ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,name);
                            versionList.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            System.out.println("hahahahahahacatch");

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });

        queue.add(request);


        return viewGroup;
    }
}
