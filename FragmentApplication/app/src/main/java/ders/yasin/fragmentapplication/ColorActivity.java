package ders.yasin.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;

public class ColorActivity extends AppCompatActivity implements ColorFragment.OnColorChangeListener {
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        constraintLayout=findViewById(R.id.constraint_layout);

        ColorFragment colorFragment=new ColorFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.color_container,colorFragment).commit();
    }

    @Override
    public void onColorChange(String color) {
        switch (color){
            case "blue": constraintLayout.setBackgroundColor(Color.parseColor("#039BE5")); break;
            case "red" : constraintLayout.setBackgroundColor(Color.parseColor("#DD2C00")); break;
            case "green": constraintLayout.setBackgroundColor(Color.parseColor("#43A047")); break;
        }


    }
}
