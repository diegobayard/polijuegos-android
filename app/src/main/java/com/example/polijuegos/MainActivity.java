package com.example.polijuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView tv;
    private Button b;
    private Button b1;
    private Typeface Acme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView inicio = (ImageView)findViewById(R.id.imageView);
        inicio.setImageResource(R.drawable.poli);
        String f1 = "Fuentes/Acme.ttf";
        this.Acme = Typeface.createFromAsset(getAssets(),f1);
        TextView tv = (TextView)findViewById(R.id.textView2);
        tv.setTypeface(Acme);
        Button b = (Button)findViewById(R.id.button);
        b.setTypeface(Acme);
        Button b1 = (Button)findViewById(R.id.button10);
        b1.setTypeface(Acme);
    }

    public void elegirBoton(View vista) {
        Intent i = new Intent(this, Elegir.class);
        startActivity(i);
        finish();
    }
    public void saliendo(View vista){
        Intent i = new Intent(this, FinalizandoMain.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }
}
