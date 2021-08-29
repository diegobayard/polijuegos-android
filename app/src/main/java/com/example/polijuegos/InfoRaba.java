package com.example.polijuegos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoRaba extends Activity {
    private Typeface Acme;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.raba_info);
        inicio();
    }
    public void inicio(){
        TextView tv1=(TextView)findViewById(R.id.textView11);
        TextView tv2=(TextView)findViewById(R.id.textView12);
        TextView tv3=(TextView)findViewById(R.id.textView13);
        TextView tv4=(TextView)findViewById(R.id.textView14);
        TextView tv5=(TextView)findViewById(R.id.textView15);
        ImageView iv1=(ImageView)findViewById(R.id.imageView6);
        ImageView iv2=(ImageView)findViewById(R.id.imageView7);
        ImageView iv3=(ImageView)findViewById(R.id.imageView8);
        ImageButton ib =(ImageButton)findViewById(R.id.imageButton2);
        String f1 = "Fuentes/Acme.ttf";
        this.Acme = Typeface.createFromAsset(getAssets(),f1);
        tv1.setTypeface(Acme);
        tv2.setTypeface(Acme);
        tv3.setTypeface(Acme);
        tv4.setTypeface(Acme);
        tv5.setTypeface(Acme);
        iv1.setImageResource(android.R.drawable.btn_star_big_on);
        iv2.setImageResource(android.R.drawable.btn_star_big_off);
        iv3.setImageResource(android.R.drawable.ic_popup_sync);
        ib.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
    }
    public void saliendo(View vista){
        finish();
    }
}
