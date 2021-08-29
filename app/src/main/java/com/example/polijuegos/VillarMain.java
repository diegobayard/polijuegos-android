package com.example.polijuegos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class VillarMain extends Activity {
    private TextView tv;
    private Button b;
    private Typeface Acme;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.villar);
        ImageView fv = (ImageView)findViewById(R.id.imageView2);
        fv.setImageResource(R.drawable.fv);
        String f1 = "Fuentes/Acme.ttf";
        Acme = Typeface.createFromAsset(getAssets(),f1);
        tv = (TextView)findViewById(R.id.textView);
        tv.setTypeface(Acme);
        b = (Button)findViewById(R.id.button3);
        b.setTypeface(Acme);
        Button b2 = (Button)findViewById(R.id.button4);
        b2.setTypeface(Acme);
        Button b3 = (Button)findViewById(R.id.button5);
        b3.setTypeface(Acme);
    }
    public void previo(View vista){
        Intent i = new Intent(this, Elegir.class);
        startActivity(i);
        finish();
    }
    public void siguiente(View vista){
        Intent i = new Intent(this,RabaMain.class);
        startActivity(i);
        finish();
    }
    public void seleccion(View vista){
        Intent i = new Intent (this,TaTeTiMain.class);
        startActivity(i);
        finish();
    }
}
