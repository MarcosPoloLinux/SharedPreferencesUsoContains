package com.elmundobinario.sharedprefvacio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView texto;
    int i=1;
    int j=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.textoTextView);


        SharedPreferences datos = getSharedPreferences("datos", Context.MODE_PRIVATE);
        //cambiar linea 37 el algumento para clave en metodo conteins() para probar si funciona contains()...
        /*contains(String key):*/

        SharedPreferences.Editor editor = datos.edit();
        editor.putString(String.valueOf(i), "sarraceno");
        editor.putString(String.valueOf(j), "quinoa");
        editor.commit(); //no olvidarlo, si no no guarda la clave ni el valor...
        //no borrar lo siguiente:
        if (datos.contains(String.valueOf(3))) {
            texto.setText(datos.getString(String.valueOf(3),""));
        }
        if (!datos.contains("3")) {
            texto.setText("3 no existe");
        }

    }
}
