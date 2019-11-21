package com.example.asistenciabusesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.asistenciabusesapp.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class BuscarAlumno extends AppCompatActivity {

    public EditText et;
    public TextView tv;
    public HashMap<Integer, String> alumnos = new HashMap<Integer, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_alumno);
        alumnos = Utils.getHashMap("Lista_Alumnos",this);

        et = (EditText)findViewById(R.id.nombreAlumno);
        tv = (TextView)findViewById(R.id.numeroAlumno);
    }

    public void buscarVoid(View view) {
        String nombre = et.getText().toString();
        for(Integer i : alumnos.keySet()){
            if(alumnos.get(i).equals(nombre)){
                tv.setText(tv.getText()+" "+i);
            }
        }
    }
}
