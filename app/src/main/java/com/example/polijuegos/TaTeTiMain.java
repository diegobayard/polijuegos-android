package com.example.polijuegos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaTeTiMain extends Activity {
    private TextView tv;
    private TextView tv2;
    private TextView tv3;
    private RadioButton facil;
    private RadioButton medio;
    private RadioButton dificil;
    private RadioButton epico;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button aj1;
    private Button aj2;
    private Button volver;
    private Button salir;
    private Button again;
    private RadioGroup rg;
    private TableLayout tablero;
    private ImageView iv;
    List<Button> botones = new ArrayList<>();
    private List<Integer> indices = new ArrayList<>();
    private Typeface Acme;
    private boolean circulo;
    private boolean ganador;
    private int contador;
    private int elegir;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tateti);
        iniciando();
        guardandoBotones();
        invisibles();
    }
    public void iniciando(){
        String f1 = "Fuentes/Acme.ttf";
        this.Acme = Typeface.createFromAsset(getAssets(),f1);
        tv=(TextView)findViewById(R.id.textView7);
        tv.setTypeface(Acme);
        tv2=(TextView)findViewById(R.id.textView8);
        tv2.setTypeface(Acme);
        tv3=(TextView)findViewById(R.id.textView9);
        tv3.setTypeface(Acme);
        rg=(RadioGroup)findViewById(R.id.radioGroup);
        facil=(RadioButton)findViewById(R.id.radioButton);
        facil.setTypeface(Acme);
        medio=(RadioButton)findViewById(R.id.radioButton2);
        medio.setTypeface(Acme);
        dificil=(RadioButton)findViewById(R.id.radioButton3);
        dificil.setTypeface(Acme);
        epico=(RadioButton)findViewById(R.id.radioButton4);
        epico.setTypeface(Acme);
        aj1=(Button)findViewById(R.id.button12);
        aj1.setTypeface(Acme);
        aj2=(Button)findViewById(R.id.button13);
        aj2.setTypeface(Acme);
        volver=(Button)findViewById(R.id.button14);
        volver.setTypeface(Acme);
        salir=(Button)findViewById(R.id.button15);
        salir.setTypeface(Acme);
        again=(Button)findViewById(R.id.button16);
        again.setTypeface(Acme);
        tablero=(TableLayout)findViewById(R.id.tableLayout);
        b1=(Button)findViewById(R.id.t1);
        b2=(Button)findViewById(R.id.t2);
        b3=(Button)findViewById(R.id.t3);
        b4=(Button)findViewById(R.id.t4);
        b5=(Button)findViewById(R.id.t5);
        b6=(Button)findViewById(R.id.t6);
        b7=(Button)findViewById(R.id.t7);
        b8=(Button)findViewById(R.id.t8);
        b9=(Button)findViewById(R.id.t9);
        iv = (ImageView)findViewById(R.id.imageView10);
        iv.setImageResource(android.R.drawable.ic_menu_info_details);
        circulo=true;
        ganador=false;
        contador=0;
    }
    public void guardandoBotones(){
        botones.add(b1);
        botones.add(b2);
        botones.add(b3);
        botones.add(b4);
        botones.add(b5);
        botones.add(b6);
        botones.add(b7);
        botones.add(b8);
        botones.add(b9);
    }
    public void aJugarFer(View vista){
        if(facil.isChecked()||medio.isChecked()||dificil.isChecked()||epico.isChecked()){
            iv.setVisibility(View.INVISIBLE);
            mostrando();
            elegir=1;
        }
    }
    public void aJugarDe2(View vista){
        iv.setVisibility(View.INVISIBLE);
        mostrando();
        elegir=2;
    }
    public void mostrando(){
        tv.setVisibility(View.INVISIBLE);
        rg.setVisibility(View.INVISIBLE);
        aj1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        aj2.setVisibility(View.INVISIBLE);
        volver.setVisibility(View.INVISIBLE);
        for(int i=0; i<botones.size();i++){
            botones.get(i).setVisibility(View.VISIBLE);
        }
        salir.setVisibility(View.VISIBLE);
        again.setVisibility(View.VISIBLE);
    }
    public void invisibles(){
        for(int i=0; i<botones.size();i++){
            botones.get(i).setVisibility(View.INVISIBLE);
        }
    }
    public void apretar(View vista){
        if(elegir==1){
            int cod = vista.getId();
            Button b = (Button) findViewById(cod);
            b.setText(R.string.circ);
            b.setClickable(false);
            contador++;
            comprobar();
            if(!ganador&&contador<9){
                for(int j=0;j<botones.size();j++){
                    if(cod==botones.get(j).getId()){
                        indices.add(j);
                    }
                }
                dificultades();
            }
        }
        else if(elegir==2) {
            int cod = vista.getId();
            Button b = (Button) findViewById(cod);
            if (circulo) {
                b.setText(R.string.circ);
                circulo = false;
            } else {
                b.setText(R.string.equis);
                circulo = true;
            }
            b.setClickable(false);
            contador++;
            comprobar();
        }
    }
    public void comprobar(){
        if(contador>4) {
            if (!b1.getText().toString().equals("")&&(b1.getText().toString().equals(b2.getText().toString())) && (b1.getText().toString().equals(b3.getText().toString()))) {
                b1.setBackgroundResource(R.drawable.ganador);
                b1.setTextColor(Color.WHITE);
                b2.setBackgroundResource(R.drawable.ganador);
                b2.setTextColor(Color.WHITE);
                b3.setBackgroundResource(R.drawable.ganador);
                b3.setTextColor(Color.WHITE);
                String textito="La victoria es de las " + b1.getText().toString();
                tv3.setText(textito);
                bloquear();
                ganador=true;
            } else if (!b4.getText().toString().equals("")&&(b4.getText().toString().equals(b5.getText().toString())) && (b4.getText().toString().equals(b6.getText().toString()))) {
                b4.setBackgroundResource(R.drawable.ganador);
                b4.setTextColor(Color.WHITE);
                b5.setBackgroundResource(R.drawable.ganador);
                b5.setTextColor(Color.WHITE);
                b6.setBackgroundResource(R.drawable.ganador);
                b6.setTextColor(Color.WHITE);
                String textito="La victoria es de las " + b4.getText().toString();
                tv3.setText(textito);
                bloquear();
                ganador=true;
            } else if (!b7.getText().toString().equals("")&&(b7.getText().toString().equals(b8.getText().toString())) && (b7.getText().toString().equals(b9.getText().toString()))) {
                b7.setBackgroundResource(R.drawable.ganador);
                b7.setTextColor(Color.WHITE);
                b8.setBackgroundResource(R.drawable.ganador);
                b8.setTextColor(Color.WHITE);
                b9.setBackgroundResource(R.drawable.ganador);
                b9.setTextColor(Color.WHITE);
                String textito="La victoria es de las " + b7.getText().toString();
                tv3.setText(textito);
                bloquear();
                ganador=true;
            } else if (!b1.getText().toString().equals("")&&(b1.getText().toString().equals(b4.getText().toString())) && (b1.getText().toString().equals(b7.getText().toString()))) {
                b1.setBackgroundResource(R.drawable.ganador);
                b1.setTextColor(Color.WHITE);
                b4.setBackgroundResource(R.drawable.ganador);
                b4.setTextColor(Color.WHITE);
                b7.setBackgroundResource(R.drawable.ganador);
                b7.setTextColor(Color.WHITE);
                String textito="La victoria es de las " + b1.getText().toString();
                tv3.setText(textito);
                bloquear();
                ganador=true;
            } else if (!b2.getText().toString().equals("")&&(b2.getText().toString().equals(b5.getText().toString())) && (b2.getText().toString().equals(b8.getText().toString()))) {
                b2.setBackgroundResource(R.drawable.ganador);
                b2.setTextColor(Color.WHITE);
                b5.setBackgroundResource(R.drawable.ganador);
                b5.setTextColor(Color.WHITE);
                b8.setBackgroundResource(R.drawable.ganador);
                b8.setTextColor(Color.WHITE);
                String textito="La victoria es de las " + b2.getText().toString();
                tv3.setText(textito);
                bloquear();
                ganador=true;
            } else if (!b3.getText().toString().equals("")&&(b3.getText().toString().equals(b6.getText().toString())) && (b3.getText().toString().equals(b9.getText().toString()))) {
                b3.setBackgroundResource(R.drawable.ganador);
                b3.setTextColor(Color.WHITE);
                b6.setBackgroundResource(R.drawable.ganador);
                b6.setTextColor(Color.WHITE);
                b9.setBackgroundResource(R.drawable.ganador);
                b9.setTextColor(Color.WHITE);
                String textito="La victoria es de las " + b3.getText().toString();
                tv3.setText(textito);
                bloquear();
                ganador=true;
            } else if (!b1.getText().toString().equals("")&&(b1.getText().toString().equals(b5.getText().toString())) && (b1.getText().toString().equals(b9.getText().toString()))) {
                b1.setBackgroundResource(R.drawable.ganador);
                b1.setTextColor(Color.WHITE);
                b5.setBackgroundResource(R.drawable.ganador);
                b5.setTextColor(Color.WHITE);
                b9.setBackgroundResource(R.drawable.ganador);
                b9.setTextColor(Color.WHITE);
                String textito="La victoria es de las " + b1.getText().toString();
                tv3.setText(textito);
                bloquear();
                ganador=true;
            } else if (!b3.getText().toString().equals("")&&(b3.getText().toString().equals(b5.getText().toString())) && (b3.getText().toString().equals(b7.getText().toString()))) {
                b3.setBackgroundResource(R.drawable.ganador);
                b3.setTextColor(Color.WHITE);
                b5.setBackgroundResource(R.drawable.ganador);
                b5.setTextColor(Color.WHITE);
                b7.setBackgroundResource(R.drawable.ganador);
                b7.setTextColor(Color.WHITE);
                String textito="La victoria es de las " + b3.getText().toString();
                tv3.setText(textito);
                bloquear();
                ganador=true;
            } else {
                if(contador==9){
                    tv3.setText(R.string.empate);
                }
            }
        }
    }
    public void reiniciando(View vista){
        for(int i=0; i<botones.size();i++){
            botones.get(i).setText("");
            botones.get(i).setTextColor(Color.BLACK);
            botones.get(i).setBackgroundResource(R.drawable.cuadri_vacia);
            botones.get(i).setClickable(true);
            circulo=true;
            ganador=false;
        }
        tv3.setText("");
        contador=0;
        indices.clear();
    }
    public void saliendo(View vista){
        reiniciando(null);
        invisibles();
        salir.setVisibility(View.INVISIBLE);
        again.setVisibility(View.INVISIBLE);
        tv.setVisibility(View.VISIBLE);
        rg.setVisibility(View.VISIBLE);
        aj1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        aj2.setVisibility(View.VISIBLE);
        volver.setVisibility(View.VISIBLE);
        iv.setVisibility(View.VISIBLE);
    }
    public void bloquear(){
        for(int i=0;i<botones.size();i++){
            botones.get(i).setClickable(false);
        }
    }
    public void out(View vista){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
    public void dificultades(){
        int i=0;
        boolean ok = false;
        if (facil.isChecked()){
            while(i<botones.size()&& !ok){
                if(botones.get(i).isClickable()){
                    botones.get(i).setText(R.string.equis);
                    botones.get(i).setClickable(false);
                    contador++;
                    ok=true;
                    comprobar();
                }
                i++;
            }
        }
        else if(medio.isChecked()){
            while (!ok){
                int aleatorio = (int) (Math.random() * botones.size());
                aleatorio = estaRepetido(aleatorio);
                if(botones.get(aleatorio).isClickable()){
                    botones.get(aleatorio).setClickable(false);
                    botones.get(aleatorio).setText(R.string.equis);
                    contador++;
                    ok=true;
                    comprobar();
                }
            }
        }
        else if(dificil.isChecked()){
            compX();
        }
        else if(epico.isChecked()){
            compX();
        }
    }
    private int estaRepetido(int aleatorio) {
        boolean repetido = false;
        int nuevoValor;
        for (int i = 0; i < indices.size(); i++) {
            if (indices.get(i) == aleatorio) { //se analiza si el indice generado aleatoriamente ya fue usado anteriormente
                repetido = true;
            }
        }
        if (repetido) {
            nuevoValor = (int) (Math.random() * botones.size()); //en caso de estar repetido genera un nuevo indice aleatorio
            nuevoValor = estaRepetido(nuevoValor); //se analiza si el nuevo numero generado esta repetido o no
        } else {
            nuevoValor = aleatorio; //en caso de que no este repetido se devuelve ese mismo numero
            indices.add(nuevoValor);
        }
        return nuevoValor;
    }
    public void compX(){
        String val="X";
        if((b1.getText().toString().equals(val)&&b2.getText().toString().equals(val))&&b3.isClickable() || (b1.getText().toString().equals(val)&&b3.getText().toString().equals(val))&&b2.isClickable() || (b2.getText().toString().equals(val)&&b3.getText().toString().equals(val)&&b1.isClickable())){
            b1.setText(R.string.equis);
            b2.setText(R.string.equis);
            b3.setText(R.string.equis);
            b1.setClickable(false);
            b2.setClickable(false);
            b3.setClickable(false);
            contador++;
            comprobar();
        }
        else if((b4.getText().toString().equals(val)&&b5.getText().toString().equals(val))&&b6.isClickable() || (b4.getText().toString().equals(val)&&b6.getText().toString().equals(val))&&b5.isClickable() || (b5.getText().toString().equals(val)&&b6.getText().toString().equals(val)&&b4.isClickable())){
            b4.setText(R.string.equis);
            b5.setText(R.string.equis);
            b6.setText(R.string.equis);
            b4.setClickable(false);
            b5.setClickable(false);
            b6.setClickable(false);
            contador++;
            comprobar();
        }
        else if((b7.getText().toString().equals(val)&&b8.getText().toString().equals(val))&&b9.isClickable() || (b7.getText().toString().equals(val)&&b9.getText().toString().equals(val))&&b8.isClickable() || (b8.getText().toString().equals(val)&&b9.getText().toString().equals(val)&&b7.isClickable())){
            b7.setText(R.string.equis);
            b8.setText(R.string.equis);
            b9.setText(R.string.equis);
            b7.setClickable(false);
            b8.setClickable(false);
            b9.setClickable(false);
            contador++;
            comprobar();
        }
        else if((b1.getText().toString().equals(val)&&b4.getText().toString().equals(val))&&b7.isClickable() || (b1.getText().toString().equals(val)&&b7.getText().toString().equals(val))&&b4.isClickable() || (b7.getText().toString().equals(val)&&b4.getText().toString().equals(val)&&b1.isClickable())){
            b1.setText(R.string.equis);
            b4.setText(R.string.equis);
            b7.setText(R.string.equis);
            b1.setClickable(false);
            b4.setClickable(false);
            b7.setClickable(false);
            contador++;
            comprobar();
        }
        else if((b2.getText().toString().equals(val)&&b5.getText().toString().equals(val))&&b8.isClickable() || (b2.getText().toString().equals(val)&&b8.getText().toString().equals(val))&&b5.isClickable() || (b8.getText().toString().equals(val)&&b5.getText().toString().equals(val)&&b2.isClickable())){
            b2.setText(R.string.equis);
            b5.setText(R.string.equis);
            b8.setText(R.string.equis);
            b2.setClickable(false);
            b5.setClickable(false);
            b8.setClickable(false);
            contador++;
            comprobar();
        }
        else if((b3.getText().toString().equals(val)&&b6.getText().toString().equals(val))&&b9.isClickable() || (b3.getText().toString().equals(val)&&b9.getText().toString().equals(val))&&b6.isClickable() || (b9.getText().toString().equals(val)&&b6.getText().toString().equals(val)&&b3.isClickable())){
            b3.setText(R.string.equis);
            b6.setText(R.string.equis);
            b9.setText(R.string.equis);
            b3.setClickable(false);
            b6.setClickable(false);
            b9.setClickable(false);
            contador++;
            comprobar();
        }
        else if((b1.getText().toString().equals(val)&&b5.getText().toString().equals(val))&&b9.isClickable() || (b1.getText().toString().equals(val)&&b9.getText().toString().equals(val))&&b5.isClickable() || (b9.getText().toString().equals(val)&&b5.getText().toString().equals(val)&&b1.isClickable())){
            b1.setText(R.string.equis);
            b5.setText(R.string.equis);
            b9.setText(R.string.equis);
            b1.setClickable(false);
            b5.setClickable(false);
            b9.setClickable(false);
            contador++;
            comprobar();
        }
        else if((b3.getText().toString().equals(val)&&b5.getText().toString().equals(val))&&b7.isClickable() || (b3.getText().toString().equals(val)&&b7.getText().toString().equals(val))&&b5.isClickable() || (b7.getText().toString().equals(val)&&b5.getText().toString().equals(val)&&b3.isClickable())){
            b3.setText(R.string.equis);
            b5.setText(R.string.equis);
            b7.setText(R.string.equis);
            b3.setClickable(false);
            b5.setClickable(false);
            b7.setClickable(false);
            contador++;
            comprobar();
        }
        else{
            compY();
        }
    }
    public void compY(){
        String val="O";
        if((b1.getText().toString().equals(val)&&b2.getText().toString().equals(val))&&b3.isClickable() || (b1.getText().toString().equals(val)&&b3.getText().toString().equals(val))&&b2.isClickable() || (b2.getText().toString().equals(val)&&b3.getText().toString().equals(val)&&b1.isClickable())){
            if(b1.isClickable()){
                b1.setText(R.string.equis);
                b1.setClickable(false);
                contador++;
                comprobar();
            }
            else if(b2.isClickable()){
                b2.setText(R.string.equis);
                b2.setClickable(false);
                contador++;
                comprobar();
            }
            else{
                b3.setText(R.string.equis);
                b3.setClickable(false);
                contador++;
                comprobar();
            }
        }
        else if((b4.getText().toString().equals(val)&&b5.getText().toString().equals(val))&&b6.isClickable() || (b4.getText().toString().equals(val)&&b6.getText().toString().equals(val))&&b5.isClickable() || (b5.getText().toString().equals(val)&&b6.getText().toString().equals(val)&&b4.isClickable())){
            if(b4.isClickable()){
                b4.setText(R.string.equis);
                b4.setClickable(false);
                contador++;
                comprobar();
            }
            else if(b5.isClickable()){
                b5.setText(R.string.equis);
                b5.setClickable(false);
                contador++;
                comprobar();
            }
            else{
                b6.setText(R.string.equis);
                b6.setClickable(false);
                contador++;
                comprobar();
            }
        }
        else if((b7.getText().toString().equals(val)&&b8.getText().toString().equals(val))&&b9.isClickable() || (b7.getText().toString().equals(val)&&b9.getText().toString().equals(val))&&b8.isClickable() || (b8.getText().toString().equals(val)&&b9.getText().toString().equals(val)&&b7.isClickable())){
            if(b7.isClickable()){
                b7.setText(R.string.equis);
                b7.setClickable(false);
                contador++;
                comprobar();
            }
            else if(b8.isClickable()){
                b8.setText(R.string.equis);
                b8.setClickable(false);
                contador++;
                comprobar();
            }
            else{
                b9.setText(R.string.equis);
                b9.setClickable(false);
                contador++;
                comprobar();
            }
        }
        else if((b1.getText().toString().equals(val)&&b4.getText().toString().equals(val))&&b7.isClickable() || (b1.getText().toString().equals(val)&&b7.getText().toString().equals(val))&&b4.isClickable() || (b7.getText().toString().equals(val)&&b4.getText().toString().equals(val)&&b1.isClickable())){
            if(b1.isClickable()){
                b1.setText(R.string.equis);
                b1.setClickable(false);
                contador++;
                comprobar();
            }
            else if(b4.isClickable()){
                b4.setText(R.string.equis);
                b4.setClickable(false);
                contador++;
                comprobar();
            }
            else{
                b7.setText(R.string.equis);
                b7.setClickable(false);
                contador++;
                comprobar();
            }
        }
        else if((b2.getText().toString().equals(val)&&b5.getText().toString().equals(val))&&b8.isClickable() || (b2.getText().toString().equals(val)&&b8.getText().toString().equals(val))&&b5.isClickable() || (b8.getText().toString().equals(val)&&b5.getText().toString().equals(val)&&b2.isClickable())){
            if(b5.isClickable()){
                b5.setText(R.string.equis);
                b5.setClickable(false);
                contador++;
                comprobar();
            }
            else if(b2.isClickable()){
                b2.setText(R.string.equis);
                b2.setClickable(false);
                contador++;
                comprobar();
            }
            else{
                b8.setText(R.string.equis);
                b8.setClickable(false);
                contador++;
                comprobar();
            }
        }
        else if((b3.getText().toString().equals(val)&&b6.getText().toString().equals(val))&&b9.isClickable() || (b3.getText().toString().equals(val)&&b9.getText().toString().equals(val))&&b6.isClickable() || (b9.getText().toString().equals(val)&&b6.getText().toString().equals(val)&&b3.isClickable())){
            if(b3.isClickable()){
                b3.setText(R.string.equis);
                b3.setClickable(false);
                contador++;
                comprobar();
            }
            else if(b6.isClickable()){
                b6.setText(R.string.equis);
                b6.setClickable(false);
                contador++;
                comprobar();
            }
            else{
                b9.setText(R.string.equis);
                b9.setClickable(false);
                contador++;
                comprobar();
            }
        }
        else if((b1.getText().toString().equals(val)&&b5.getText().toString().equals(val))&&b9.isClickable() || (b1.getText().toString().equals(val)&&b9.getText().toString().equals(val))&&b5.isClickable() || (b9.getText().toString().equals(val)&&b5.getText().toString().equals(val)&&b1.isClickable())){
            if(b1.isClickable()){
                b1.setText(R.string.equis);
                b1.setClickable(false);
                contador++;
                comprobar();
            }
            else if(b5.isClickable()){
                b5.setText(R.string.equis);
                b5.setClickable(false);
                contador++;
                comprobar();
            }
            else{
                b9.setText(R.string.equis);
                b9.setClickable(false);
                contador++;
                comprobar();
            }
        }
        else if((b3.getText().toString().equals(val)&&b5.getText().toString().equals(val))&&b7.isClickable() || (b3.getText().toString().equals(val)&&b7.getText().toString().equals(val))&&b5.isClickable() || (b7.getText().toString().equals(val)&&b5.getText().toString().equals(val)&&b3.isClickable())){
            if(b5.isClickable()){
                b5.setText(R.string.equis);
                b5.setClickable(false);
                contador++;
                comprobar();
            }
            else if(b7.isClickable()){
                b7.setText(R.string.equis);
                b7.setClickable(false);
                contador++;
                comprobar();
            }
            else{
                b3.setText(R.string.equis);
                b3.setClickable(false);
                contador++;
                comprobar();
            }
        }
        else{
            if(dificil.isChecked()){
                caso3();
            }
            else if(epico.isChecked()){
                caso3b();
            }
        }
    }
    public void caso3(){
        if (b1.isClickable()){
            b1.setText(R.string.equis);
            b1.setClickable(false);
            contador++;
            comprobar();
        }
        else if(b3.isClickable()){
            b3.setText(R.string.equis);
            b3.setClickable(false);
            contador++;
            comprobar();
        }
        else if(b7.isClickable()){
            b7.setText(R.string.equis);
            b7.setClickable(false);
            contador++;
            comprobar();
        }
        else if(b9.isClickable()){
            b9.setText(R.string.equis);
            b9.setClickable(false);
            contador++;
            comprobar();
        }
        else{
            if(dificil.isChecked()){
                caso4();
            }
            else if(epico.isChecked()){
                caso4b();
            }
        }
    }
    public void caso4(){
        if(b5.isClickable()){
            b5.setText(R.string.equis);
            b5.setClickable(false);
            contador++;
            comprobar();
        }
        else if(b2.isClickable()){
            b2.setText(R.string.equis);
            b2.setClickable(false);
            contador++;
            comprobar();
        }
        else if(b4.isClickable()){
            b4.setText(R.string.equis);
            b4.setClickable(false);
            contador++;
            comprobar();
        }
        else if(b6.isClickable()){
            b6.setText(R.string.equis);
            b6.setClickable(false);
            contador++;
            comprobar();
        }
        else if(b8.isClickable()){
            b8.setText(R.string.equis);
            b8.setClickable(false);
            contador++;
            comprobar();
        }
    }
    public void caso3b(){
        if(b5.isClickable()){
            b5.setText(R.string.equis);
            b5.setClickable(false);
            contador++;
            comprobar();
        }
        else{
            caso3();
        }
    }
    public void caso4b(){
        if(b2.isClickable()){
            b2.setText(R.string.equis);
            b2.setClickable(false);
            contador++;
            comprobar();
        }
        else if(b4.isClickable()){
            b4.setText(R.string.equis);
            b4.setClickable(false);
            contador++;
            comprobar();
        }
        else if(b6.isClickable()){
            b6.setText(R.string.equis);
            b6.setClickable(false);
            contador++;
            comprobar();
        }
        else if(b8.isClickable()){
            b8.setText(R.string.equis);
            b8.setClickable(false);
            contador++;
            comprobar();
        }
    }
    public void inf(View vista){
        Intent i = new Intent (this,InfoFer.class);
        startActivity(i);
    }
}