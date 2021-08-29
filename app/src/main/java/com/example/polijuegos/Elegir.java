package com.example.polijuegos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Elegir extends Activity {
    private TextView tv;
    private Button b;
    private Typeface Acme;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elegir_personajes);
        ImageView ar = (ImageView)findViewById(R.id.imageView5);
        ar.setImageResource(R.drawable.a);
        String f1 = "Fuentes/Acme.ttf";
        this.Acme = Typeface.createFromAsset(getAssets(),f1);
        tv = (TextView)findViewById(R.id.ale);
        tv.setTypeface(Acme);
        b = (Button)findViewById(R.id.button2);
        b.setTypeface(Acme);
        Button b2 = (Button)findViewById(R.id.sig);
        b2.setTypeface(Acme);
    }
    public void siguiente(View vista){
        Intent i = new Intent(this, VillarMain.class);
        startActivity(i);
        finish();
    }
    public void seleccionar(View vista){
        Intent i = new Intent(this, AhorcadoMain.class);
        startActivity(i);
        finish();
    }
}
