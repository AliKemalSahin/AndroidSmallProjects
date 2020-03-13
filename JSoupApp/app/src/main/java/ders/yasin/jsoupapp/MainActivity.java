package ders.yasin.jsoupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvTitle;
    ListView lvList;
    Button btnNews;
    Button btnAnnounce;
    Button btnImage;
    Button btnOffice;
    ArrayList<String> data;
    ArrayAdapter<String> adapter;

    String URL="http://www.karabuk.edu.tr";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle=findViewById(R.id.tv_Title);
        lvList=findViewById(R.id.lv_List);
        btnNews=findViewById(R.id.btn_News);
        btnAnnounce=findViewById(R.id.btn_Announce);
        btnImage=findViewById(R.id.btn_Images);
        btnOffice=findViewById(R.id.btn_Office);

        data=new ArrayList<>();
        adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,data);

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.clear();
                new GetData().execute(URL,"1");
            }
        });
        btnAnnounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.clear();
                new GetData().execute(URL,"2");
            }
        });

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.clear();
                new GetData().execute(URL,"3");
            }
        });

        btnOffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.clear();
                new GetData().execute(URL,"4");
            }
        });




    }


    public class  GetData extends AsyncTask<String,Void, Document>{
        ProgressDialog progressDialog;
        String requestType;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Karabuk University");
            progressDialog.setMessage("Loading");
            progressDialog.show();
        }

        @Override
        protected Document doInBackground(String... strings) {
            Document document=null;
            try {
                 document= Jsoup.connect(strings[0]).get();
                 requestType=strings[1];
            } catch (IOException e) {
                e.printStackTrace();
            }
            return document;
        }

        @Override
        protected void onPostExecute(Document doc) {
            super.onPostExecute(doc);
            progressDialog.dismiss();
            String title=doc.title();
            tvTitle.setText(title);

            switch (requestType) {
                case "1":{
                    Elements haberler = doc.select("div.haberBoxHeader");   // div. dememizin sebebi div tagının içinde olması
                    for (Element haber : haberler) {
                        data.add(haber.text());
                    }
                    break;
                }
                case "2":{
                    Elements announcements = doc.select("span.containerDuyuruBaslikLabel");
                    for (Element announce : announcements)
                        data.add(announce.text());

                    Elements announceLinks=doc.select("div.owl-item a");
                    for(Element link:announceLinks) {
                        data.add(link.attr("href"));
                    }
                    break;
                }
                case "3":{
                    Elements medias = doc.select("[src]");
                    for (Element media : medias) {
                       if(media.tagName().equals("img"))
                           data.add(media.attr("abs:src"));
                    }
                    break;
                }
                case "4":{
                    Elements offices= doc.select("div.col-md-4 span");
                    for (Element office : offices) {
                        if(office.text().equals("Daire Başkanlıkları")){
                            Element nextSibling=office.nextElementSibling();
                            Elements children=nextSibling.children();
                            for(Element child:children){
                                data.add(child.text());
                            }
                        }
                    }
                    break;
                }
            }

            lvList.setAdapter(adapter);


        }
    }
}
