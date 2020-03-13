package com.example.sehirler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView resim;
    TextView sehir,plaka,info;
    ImageButton sol,sag;
    int i = 0,sayac=0,sayac2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resim = findViewById(R.id.imageView);
        sehir = findViewById(R.id.sehirAd);
        plaka = findViewById(R.id.plakaNo);
        info = findViewById(R.id.bilgi);
        sol = findViewById(R.id.left);
        sag = findViewById(R.id.right);


        Resources res = getResources();
        final String[] sehirler = res.getStringArray(R.array.sehirler);
        final String[] plakalar = res.getStringArray(R.array.plakalar);
        final String[] bilgiler = res.getStringArray(R.array.bilgiler);


        sag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sayac2 == 0){
                    if(i == 0){
                        resim.setImageResource(R.drawable.safranbolu);
                        sol.setVisibility(View.INVISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                    else if(i == 1) {
                        resim.setImageResource(R.drawable.istanbul);
                        sol.setVisibility(View.VISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                    else if(i == 2) {
                        resim.setImageResource(R.drawable.ankara);
                        sol.setVisibility(View.VISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                    else if(i == 3) {
                        resim.setImageResource(R.drawable.mersin);
                        sol.setVisibility(View.VISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                    else if(i == 4) {
                        resim.setImageResource(R.drawable.canakkale);
                        sol.setVisibility(View.VISIBLE);
                        sag.setVisibility(View.INVISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                }
                else {
                    i++;
                    if(i == 0){
                        resim.setImageResource(R.drawable.safranbolu);
                        sol.setVisibility(View.INVISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                    else if(i == 1) {
                        resim.setImageResource(R.drawable.istanbul);
                        sol.setVisibility(View.VISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                    else if(i == 2) {
                        resim.setImageResource(R.drawable.ankara);
                        sol.setVisibility(View.VISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                    else if(i == 3) {
                        resim.setImageResource(R.drawable.mersin);
                        sol.setVisibility(View.VISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                    else if(i == 4) {
                        resim.setImageResource(R.drawable.canakkale);
                        sol.setVisibility(View.VISIBLE);
                        sag.setVisibility(View.INVISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                    sayac2=0;
                }

                i++;
                sayac=0;
            }
        });
        sol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac2++;
                if(sayac==0) {
                    i -= 2;
                    if (i == 0) {
                        resim.setImageResource(R.drawable.safranbolu);
                        sag.setVisibility(View.VISIBLE);
                        sol.setVisibility(View.INVISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    } else if (i == 1) {
                        resim.setImageResource(R.drawable.istanbul);
                        sol.setVisibility(View.VISIBLE);
                        sag.setVisibility(View.VISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    } else if (i == 2) {
                        resim.setImageResource(R.drawable.ankara);
                        sag.setVisibility(View.VISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    } else if (i == 3) {
                        resim.setImageResource(R.drawable.mersin);
                        sag.setVisibility(View.VISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    } else if (i == 4) {
                        resim.setImageResource(R.drawable.canakkale);
                        sag.setVisibility(View.INVISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                    sayac++;
                }

                else {
                    i--;
                    if (i == 0) {
                        resim.setImageResource(R.drawable.safranbolu);
                        sol.setVisibility(View.INVISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    } else if (i == 1) {
                        resim.setImageResource(R.drawable.istanbul);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    } else if (i == 2) {
                        resim.setImageResource(R.drawable.ankara);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    } else if (i == 3) {
                        resim.setImageResource(R.drawable.mersin);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    } else if (i == 4) {
                        resim.setImageResource(R.drawable.canakkale);
                        sag.setVisibility(View.INVISIBLE);
                        sehir.setText(sehirler[i]);
                        plaka.setText(plakalar[i]);
                        info.setText(bilgiler[i]);
                    }
                }

            }

        });


    }





}
