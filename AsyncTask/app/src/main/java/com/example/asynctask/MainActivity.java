package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView text;

    String url="https://files.fm/down.php?cf&i=svu7b5sa&n=aa.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        text=findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadTask downloadTask=new DownloadTask();
                downloadTask.execute(url);
            }
        });
    }


    public class DownloadTask extends  AsyncTask<String,Integer, String>{

        ProgressDialog progressDialog;

        protected String doInBackground(String... strings){

            String result = null;

            try {

                URL url = new URL(strings[0]);
                URLConnection urlConnection = url.openConnection();

                urlConnection.connect();
                int textSize = urlConnection.getContentLength();

                BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());

                ByteArrayOutputStream output = new ByteArrayOutputStream();

                byte[] data = new byte[1];
                int count = 0;
                int total = 0;
                while ((count = bufferedInputStream.read(data)) != -1) {
                    total += count;
                    output.write(data, 0, count);
                    double percentage = (double) total / textSize * 100;
                    publishProgress((int) percentage);
                }

                byte[] text = output.toByteArray();
                String decodedData = new String(text);
                result = decodedData;

            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

            return result;
        }
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("indiriliyor..");
            progressDialog.setMax(100);
            progressDialog.setProgress(0);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String yazi) {
            super.onPostExecute(yazi);
            progressDialog.dismiss();

            text.setText(yazi);
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressDialog.setProgress(values[0]);
        }
    }
}
