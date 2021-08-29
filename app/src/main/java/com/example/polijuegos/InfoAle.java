package com.example.polijuegos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoAle extends Activity {
    private Typeface Acme;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ale_info);
        TextView tv = (TextView)findViewById(R.id.textView16);
        TextView tv2 = (TextView)findViewById(R.id.textView17);
        ImageView iv =(ImageView)findViewById(R.id.imageView9);
        iv.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
        String f1 = "Fuentes/Acme.ttf";
        this.Acme = Typeface.createFromAsset(getAssets(),f1);
        tv.setTypeface(Acme);
        tv2.setTypeface(Acme);
    }
    public void saliendo(View vista){
        finish();
    }
}
