package com.example.polijuegos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AhorcadoMain extends Activity {
    TextView palabra;
    TextView guiones;
    TextView informacion;
    ImageView ahorcadin;
    TableLayout tablita;
    Button sig;
    Button vol;
    Button h;
    Button inf;
    private final String palabras[] = {"hilos", "socket", "teclado", "subrutina", "benchmarks", "heap", "stack", "spec", "multiplexor", "bit", "flipflop", "arquitectura", "excepcion", "alu", "memoria", "interrupcion"};
    private final String info[] = {"miniprocesos que se ejecutan cuasi en paralelo", "punto terminal de una comunicacion", "dispositivo de entrada", "procedimiento que permite resolver una tarea especifica", "programas de prueba que aproximan el rendimiento", "area para la memoria dinamica", "estructura de datos tipo LIFO", "benchmark exitoso", "circuito combinacional con varias entradas y una salida", "unidad minima de informacion", "elemento basico de memoria, puede ser SR, JK, D, T", "caracteristicas del computador visibles a nivel de programacion en ensamblador", "evento inesperado que se genera en la misma CPU", "unidad encargada de las operaciones aritmeticas y logicas", "almacena instrucciones y datos", "evento que proviene del exterior de la CPU"};
    private List<Integer> indices = new ArrayList<>(); //Lista con los numeros generados aleatoriamente para evitar repeticiones
    private List<Button> conj_botones = new ArrayList<>();
    private int cont;
    private int errores;
    private String aux = ""; //cadena que contendra guiones bajos segun la cantidad de letras de la palabra a adivinar. Tiene un espacio entre cada guion bajo
    private char[] aux2; //arreglo de caracteres referidos a la palabra a adivinar. se usa para mostrar por pantalla luego de cada letra ingresada
    private char[] aux3; // arreglo de caracteres para comparar si la palabra a adivinar y la ingresada son las mismas
    private String aux4 = ""; //cadena que contendra un guion bajo segun la cantidad de letras de la palabra a adivinar. NO tiene un espacio entre cada guion
    private String comparar=""; //string que copia el valor de aux3 para comparar si la palabra ingresada es la misma a la palabra por adivinar
    private boolean acierto = false; //booleano para indicar si se acerto a la letra o no
    private int aleatorio;
    private String p;
    private Typeface Acme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ahorcado);
        palabra = (TextView) findViewById(R.id.textView5);
        guiones = (TextView) findViewById(R.id.textView6);
        informacion = (TextView)findViewById(R.id.textView4);
        ahorcadin = (ImageView)findViewById(R.id.hang);
        tablita = (TableLayout)findViewById(R.id.tableLayout);
        sig = (Button)findViewById(R.id.button8);
        h=(Button)findViewById(R.id.button9);
        vol=(Button)findViewById(R.id.button11);
        inf=(Button)findViewById(R.id.button20);
        String f1 = "Fuentes/Acme.ttf";
        Acme = Typeface.createFromAsset(getAssets(),f1);
        palabra.setTypeface(Acme);
        guiones.setTypeface(Acme);
        informacion.setTypeface(Acme);
        sig.setTypeface(Acme);
        h.setTypeface(Acme);
        vol.setTypeface(Acme);
        inf.setTypeface(Acme);
        cont = 0;
        errores = 0;
        inicioPrograma();
    }
    public void inicioPrograma(){
        aux="";
        aux4="";
        errores=0;
        sig.setVisibility(View.INVISIBLE);
        dibujo();
        reiniciandoBotones();
        if (cont < palabras.length) { //son 16 palabras
            aleatorio = (int) (Math.random() * palabras.length); //generar un numero aleatorio entre 0 y 15
            aleatorio = estaRepetido(aleatorio);
            p = palabras[aleatorio].toUpperCase();
            palabra.setText(p);
            lineas(p);
            for (int j = 0; j < p.length(); j++) {
                aux += "_ ";
                aux4 += "_";
            }
            aux2 = aux.toCharArray();
            aux3 = aux4.toCharArray();
            cont++; //se suma uno al contador
        } else {
            informacion.setVisibility(View.INVISIBLE);
            guiones.setVisibility(View.INVISIBLE);
            palabra.setText("Lo sentimos, no hay mas palabras disponibles. Espera hasta la proxima actualizacion!");
            palabra.setVisibility(View.VISIBLE);
            tablita.setVisibility(View.INVISIBLE);
            h.setVisibility(View.INVISIBLE);
            vol.setVisibility(View.VISIBLE);
            ahorcadin.setImageResource(R.drawable.sad);
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
            nuevoValor = (int) (Math.random() * palabras.length); //en caso de estar repetido genera un nuevo indice aleatorio
            nuevoValor = estaRepetido(nuevoValor); //se analiza si el nuevo numero generado esta repetido o no
        } else {
            nuevoValor = aleatorio; //en caso de que no este repetido se devuelve ese mismo numero
            indices.add(nuevoValor);
        }
        return nuevoValor;

    }

    private void lineas(String p) {
        String aux = ""; //cadena que contendra guiones bajos segun la cantidad de letras de la palabra a adivinar. Tiene un espacio entre cada guion bajo
        for (int j = 0; j < p.length(); j++) {
            aux += "_ ";
        }
        guiones.setText(aux);
    }
    public void valorBoton(View vista){
        int val = vista.getId();
        Button b = (Button)findViewById(val);
        conj_botones.add(b);
        char letra = b.getText().charAt(0);
        jugar(p, letra,b);
    }

    private void jugar(String p, char letra, Button botoncinho) {
        if (errores != 6 && !p.equals(comparar)) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == letra) {
                    aux2[i * 2] = Character.toUpperCase(letra); //para mostrar por pantalla se ponen en mayusculas
                    aux3[i] = letra; // para comparar se ponen en minusculas
                    acierto = true; //en caso de que la letra pertenezca a la palabra a adivinar, hay un acierto
                    botoncinho.setBackgroundResource(R.drawable.acierto);
                }
            }
            guiones.setText(String.valueOf(aux2));
            comparar = String.valueOf(aux3); //se transforma el arreglo de caracteres a string
            if (!acierto) { //si la letra ingresada no pertenecia a la palabra entonces al contador de errores se le suma uno
                errores++;
                botoncinho.setBackgroundResource(R.drawable.fallo);
            }
            acierto = false;
            dibujo(); //funcion que muestra el dibujo del ahorcado segun los errores que se acumulen
        }
        if (errores == 6) {
            palabra.setText("Esta vez no pudo ser. La palabra era " + p);
            palabra.setVisibility(View.VISIBLE);
            informacion.setText(info[aleatorio].toUpperCase());
            informacion.setVisibility(View.VISIBLE);
            tablita.setVisibility(View.INVISIBLE);
            sig.setVisibility(View.VISIBLE);
        } else if (p.equals(comparar)) {
            palabra.setText("Felicidades! Sigue jugando!");
            palabra.setVisibility(View.VISIBLE);
            informacion.setText(info[aleatorio].toUpperCase());
            informacion.setVisibility(View.VISIBLE);
            tablita.setVisibility(View.INVISIBLE);
            sig.setVisibility(View.VISIBLE);
        }
    }

    private void dibujo() {
        switch (errores){
            case 0:
                ahorcadin.setImageResource(R.drawable.hangman);
                break;
            case 1:
                ahorcadin.setImageResource(R.drawable.hangman1);
                break;
            case 2:
                ahorcadin.setImageResource(R.drawable.hangman2);
                break;
            case 3:
                ahorcadin.setImageResource(R.drawable.hangman3);
                break;
            case 4:
                ahorcadin.setImageResource(R.drawable.hangman4);
                break;
            case 5:
                ahorcadin.setImageResource(R.drawable.hangman5);
                break;
            case 6:
                ahorcadin.setImageResource(R.drawable.hangman6);
                break;
        }
    }
    public void botoncitoSig(View vista){
        palabra.setVisibility(View.INVISIBLE);
        informacion.setVisibility(View.INVISIBLE);
        sig.setVisibility(View.INVISIBLE);
        tablita.setVisibility(View.VISIBLE);
        inicioPrograma();
    }
    public void huyendo(View vista){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
    public void reiniciandoBotones(){
        for(int i=0; i<conj_botones.size(); i++){
            conj_botones.get(i).setBackgroundResource(R.drawable.teclas);
        }
    }
    public void infox(View vista){
        Intent i = new Intent(this, InfoAle.class);
        startActivity(i);
    }
}