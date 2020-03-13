package com.example.asynctext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button buton;
    String path = "https://twitter.com/home ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.TextView);
        buton = findViewById(R.id.button);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask task = new DownloadTask();
                task.execute(path);

            }
        });
    }

    private class DownloadTask extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setTitle("Dosya İndiriliyor...");
            progressDialog.setMessage("Lütfen Bekleyin !");
            //progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            //progressDialog.setProgress(0);
            //progressDialog.setMax(100);
            progressDialog.show();

        }
        @Override
        protected String doInBackground(String... strings) {
            String metin="";
                try {
                URL url = new URL(strings[0]);
                URLConnection baglanti = url.openConnection();
                baglanti.connect();
                //size = baglanti.getContentLength();

                BufferedReader oku = new BufferedReader(new InputStreamReader(baglanti.getInputStream()));
                String satir="";
                while ((satir=oku.readLine()) != null){
                    metin+=satir;
                    //total+=count;
                    //double percentage = (double) total / size * 100;
                    //publishProgress((int) percentage);
                }

                oku.close();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return metin;
        }

        //@Override
        //protected void onProgressUpdate(Integer... values) {
        //    super.onProgressUpdate(values);
        //   progressDialog.setProgress(values[0]);
        //}

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tv.setText(s);
            progressDialog.dismiss();
            buton.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(),"İndirme Tamamlandı...",Toast.LENGTH_SHORT).show();
        }

    }
}




















