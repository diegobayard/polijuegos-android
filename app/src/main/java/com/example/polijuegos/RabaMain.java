package com.example.polijuegos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RabaMain extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.raba);
        ImageView jmra = (ImageView)findViewById(R.id.imageView3);
        jmra.setImageResource(R.drawable.jmr);
        Typeface Acme;
        String f1 = "Fuentes/Acme.ttf";
        Acme = Typeface.createFromAsset(getAssets(),f1);
        TextView tv = (TextView)findViewById(R.id.textView3);
        tv.setTypeface(Acme);
        Button b = (Button)findViewById(R.id.button6);
        b.setTypeface(Acme);
        Button b2 = (Button)findViewById(R.id.button7);
        b2.setTypeface(Acme);
    }
    public void previo(View vista){
        Intent i = new Intent(this, VillarMain.class);
        startActivity(i);
        finish();
    }
    public void seleccionado(View vista){
        Intent i = new Intent(this, RabaQuizMain.class);
        startActivity(i);
        finish();
    }
}
