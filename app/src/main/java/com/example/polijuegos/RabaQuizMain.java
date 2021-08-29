package com.example.polijuegos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RabaQuizMain extends Activity {
    private ImageView info;
    private ImageButton enter;
    private ImageView vida1;
    private ImageView vida2;
    private ImageView vida3;
    private ImageView vida4;
    private ImageView reinicio;
    private TextView ingresa;
    private TextView numero;
    private TextView preguntax;
    private TextView masomenos;
    private EditText introNum;
    private RadioGroup rg;
    private RadioButton opc1;
    private RadioButton opc2;
    private RadioButton opc3;
    private Button ayuda;
    private Button responder;
    private Button salir;
    private Typeface Acme;
    private int aleatorio;
    private int numerillo;
    private int numEdit;
    private int vidas;
    private int contador;
    private final String []preguntas = {"Siendo f(n) = n y g(n) = log n","Siendo f(n) = n y g(n) = n . log n","Siendo f(n) = n y g(n) = n²","Siendo f(n) = n² y g(n) = log n","Tecnica de diseño de algoritmos como divide y venceras","Algoritmo que siempre elige, en cada paso, una solucion optima","Los problemas solapados son una caracteristica de:","¿Los algoritmos Greedy conducen a un optimo global?","Algoritmo que guarda la solucion de un problema luego de calcularla y se usa en caso de tener una situacion ya resuelta","Algoritmo que resuelve primero los problemas mas chicos y los combina para resolver problemas mas grandes","Si T(n) = 4T(n/2) + n","Si T(n) = 4T(n/2) + n²","Si T(n) = 4T(n/2) + n³","En los heaps el minimo se encuentra en:","En los Red-Black Trees ningun nodo rojo tiene hijos rojos"};
    private final String []rb1 = {"f(n) E O(g(n))","f(n) E Ω g(n)","f(n) E O(g(n))","f(n) E O(g(n))","Programacion Dinamica", "Programacion Dinamica","Greedy","Siempre","Top Down","Top Down","T(n) E θ(n²)", "T(n) E θ(n²)", "T(n) E θ(n²)","El Hijo Izquierdo","Verdadero"};
    private final String []rb2 = {"g(n) E O(f(n))", "g(n) E Ω f(n)","g(n) E O(f(n))","g(n) E Ω f(n)","Induccion", "Induccion","Programacion Dinamica","Nunca","Bottom Up", "Bottom Up","T(n) E θ(n² . log n)", "T(n) E θ(n² . log n)", "T(n) E θ(n² . log n)","La Raiz","Falso"};
    private final String []rb3 = {"Ninguno","Ambos son correctos","Ninguno", "Ninguno","Greedy","Greedy","Ambos","En ocasiones","Shift Right","Ambos","T(n) E θ(n)", "T(n) E θ(n)", "T(n) E θ(n³)","El Hijo Derecho","Depende de la altura"};
    private final RadioButton[] aciertos = new RadioButton[preguntas.length];
    private List<Integer> indices = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rabaquiz);
        iniciar();
        EventoTeclado tecladillo = new EventoTeclado();
        introNum.setOnEditorActionListener(tecladillo);
    }
    public void iniciar(){
        String f1 = "Fuentes/Acme.ttf";
        this.Acme = Typeface.createFromAsset(getAssets(),f1);
        info=(ImageView) findViewById(R.id.info_i);
        info.setImageResource(android.R.drawable.ic_menu_info_details);
        enter=(ImageButton)findViewById(R.id.imageButton);
        enter.setImageResource(android.R.drawable.ic_menu_send);
        reinicio=(ImageView)findViewById(R.id.reini1);
        reinicio.setImageResource(android.R.drawable.ic_popup_sync);
        vida1=(ImageView) findViewById(R.id.vida01);
        vida2=(ImageView) findViewById(R.id.vida02);
        vida3=(ImageView) findViewById(R.id.vida03);
        vida4=(ImageView) findViewById(R.id.vida04);
        ingresa=(TextView)findViewById(R.id.ingreso);
        ingresa.setTypeface(Acme);
        masomenos=(TextView)findViewById(R.id.textView10);
        masomenos.setTypeface(Acme);
        numero=(TextView)findViewById(R.id.numamostrar);
        numero.setTypeface(Acme);
        preguntax=(TextView)findViewById(R.id.pregunta);
        preguntax.setTypeface(Acme);
        introNum=(EditText)findViewById(R.id.editText);
        rg=(RadioGroup)findViewById(R.id.radioGroup2);
        opc1=(RadioButton)findViewById(R.id.opc1);
        opc1.setTypeface(Acme);
        opc2=(RadioButton)findViewById(R.id.opc2);
        opc2.setTypeface(Acme);
        opc3=(RadioButton)findViewById(R.id.opc3);
        opc3.setTypeface(Acme);
        ayuda=(Button)findViewById(R.id.button17);
        ayuda.setTypeface(Acme);
        responder=(Button)findViewById(R.id.button18);
        responder.setTypeface(Acme);
        salir=(Button)findViewById(R.id.button19);
        salir.setTypeface(Acme);
        numerillo = (int) ((Math.random() * 1000)+100);
        vidas=4;
        vida1.setImageResource(android.R.drawable.btn_star_big_on);
        vida2.setImageResource(android.R.drawable.btn_star_big_on);
        vida3.setImageResource(android.R.drawable.btn_star_big_on);
        vida4.setImageResource(android.R.drawable.btn_star_big_on);
        contador=0;
        aciertos[0]=opc2;aciertos[1]=opc2;aciertos[2]=opc1;aciertos[3]=opc3;aciertos[4]=opc1;aciertos[5]=opc3;aciertos[6]=opc2;aciertos[7]=opc3;aciertos[8]=opc1;aciertos[9]=opc2;aciertos[10]=opc1;aciertos[11]=opc2;aciertos[12]=opc3;aciertos[13]=opc2;aciertos[14]=opc1;

    }
    class EventoTeclado implements TextView.OnEditorActionListener{

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId== EditorInfo.IME_ACTION_DONE){
                entercito(null);
            }
            return false;
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
            nuevoValor = (int) (Math.random() * preguntas.length); //en caso de estar repetido genera un nuevo indice aleatorio
            nuevoValor = estaRepetido(nuevoValor); //se analiza si el nuevo numero generado esta repetido o no
        } else {
            nuevoValor = aleatorio; //en caso de que no este repetido se devuelve ese mismo numero
            indices.add(nuevoValor);
        }
        return nuevoValor;
    }
    public void entercito(View vista){
        try{
            numEdit=Integer.parseInt(introNum.getText().toString());
        }
        catch (Exception e){
            numEdit=0;
        }
        if (numEdit==numerillo){
            masomenos.setText(R.string.ganaste);
            numero.setText(""+numerillo);
            numero.setTextColor(Color.GREEN);
            ayuda.setClickable(false);
            enter.setClickable(false);
            preguntax.setText("");
        }
        else{
            if(numEdit<numerillo){
                masomenos.setText(R.string.menor);
            }
            else{
                masomenos.setText(R.string.mayor);
            }
            numero.setText(""+numEdit);
            numero.setTextColor(Color.RED);
        }
        InputMethodManager teclado = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        teclado.hideSoftInputFromWindow(introNum.getWindowToken(),0);
    }
    public void ayudines(View vista){
        if (preguntas.length == indices.size()){
            indices.clear();
        }
        preguntax.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        switch (vidas){
            case 0:
                preguntax.setText(R.string.vi);
                break;
            case 1:
                ayuda.setClickable(false);
                vida4.setImageResource(android.R.drawable.btn_star_big_off);
                vidas--;
                rg.setVisibility(View.VISIBLE);
                responder.setVisibility(View.VISIBLE);
                aleatorio = (int) (Math.random() * preguntas.length);
                aleatorio = estaRepetido(aleatorio);
                preguntax.setText(preguntas[aleatorio]);
                opc1.setText(rb1[aleatorio]);
                opc2.setText(rb2[aleatorio]);
                opc3.setText(rb3[aleatorio]);
                break;
            case 2:
                ayuda.setClickable(false);
                vida3.setImageResource(android.R.drawable.btn_star_big_off);
                vidas--;
                rg.setVisibility(View.VISIBLE);
                responder.setVisibility(View.VISIBLE);
                aleatorio = (int) (Math.random() * preguntas.length);
                aleatorio = estaRepetido(aleatorio);
                preguntax.setText(preguntas[aleatorio]);
                opc1.setText(rb1[aleatorio]);
                opc2.setText(rb2[aleatorio]);
                opc3.setText(rb3[aleatorio]);
                break;
            case 3:
                ayuda.setClickable(false);
                vida2.setImageResource(android.R.drawable.btn_star_big_off);
                vidas--;
                rg.setVisibility(View.VISIBLE);
                responder.setVisibility(View.VISIBLE);
                aleatorio = (int) (Math.random() * preguntas.length);
                aleatorio = estaRepetido(aleatorio);
                preguntax.setText(preguntas[aleatorio]);
                opc1.setText(rb1[aleatorio]);
                opc2.setText(rb2[aleatorio]);
                opc3.setText(rb3[aleatorio]);
                break;
            case 4:
                ayuda.setClickable(false);
                vida1.setImageResource(android.R.drawable.btn_star_big_off);
                vidas--;
                rg.setVisibility(View.VISIBLE);
                responder.setVisibility(View.VISIBLE);
                aleatorio = (int) (Math.random() * preguntas.length);
                aleatorio = estaRepetido(aleatorio);
                preguntax.setText(preguntas[aleatorio]);
                opc1.setText(rb1[aleatorio]);
                opc2.setText(rb2[aleatorio]);
                opc3.setText(rb3[aleatorio]);
                break;
        }
    }
    public void selRes(View vista){
        ayuda.setClickable(true);
        rg.setVisibility(View.INVISIBLE);
        responder.setVisibility(View.INVISIBLE);
        if(aciertos[aleatorio].isChecked()){
            contador++;
            pista();
        }
        else{
            preguntax.setText("Perdiste tu ayuda :( La respuesta correcta es: " + aciertos[aleatorio].getText().toString());
        }
        rg.clearCheck();
    }
    public void reiniciandox(View vista){
        rg.setVisibility(View.INVISIBLE);
        responder.setVisibility(View.INVISIBLE);
        preguntax.setText("");
        masomenos.setText("");
        numero.setText("");
        introNum.setText("");
        numerillo = (int) ((Math.random() * 1000)+100);
        vida1.setImageResource(android.R.drawable.btn_star_big_on);
        vida2.setImageResource(android.R.drawable.btn_star_big_on);
        vida3.setImageResource(android.R.drawable.btn_star_big_on);
        vida4.setImageResource(android.R.drawable.btn_star_big_on);
        vidas=4;
        contador=0;
        enter.setClickable(true);
        ayuda.setClickable(true);
    }
    public void inform(View vista){
        Intent i = new Intent(this,InfoRaba.class);
        startActivity(i);
    }
    public void saliendo(View vista){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
    public void pista(){
        int largo= Integer.toString(numerillo).length();
        preguntax.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        switch (contador){
            case 1:
                char n = Integer.toString(numerillo).charAt(0);
                int n1 = Integer.parseInt(Character.toString(n));
                String t;
                if(n1<=5){
                    t = "igual o menor que 5";
                }
                else{
                    t = "mayor que 5";
                }
                preguntax.setText("Tiene " + largo + " digitos. El primero es "+t);
                break;
            case 2:
                if(numerillo%2==0){
                    preguntax.setText("Es un numero par");
                }
                else{
                    preguntax.setText("Es un numero impar");
                }
                break;
            case 3:
                char n2 = Integer.toString(numerillo).charAt(1);
                preguntax.setText("El segundo digito es " + n2);
                break;
            case 4:
                int dif = numerillo - numEdit;
                preguntax.setText("La diferencia entre el numero ingresado y el buscado es de " + Math.abs(dif));
                break;
        }
    }
}