package com.example.polijuegos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class PantallaPrincipal extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_ini);
        ImageView img = (ImageView)findViewById(R.id.imageView4);
        img.setImageResource(R.drawable.poli);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(PantallaPrincipal.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },3000);
    }
}
