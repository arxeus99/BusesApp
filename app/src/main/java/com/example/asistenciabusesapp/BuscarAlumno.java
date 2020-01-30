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
import java.util.Map;

public class BuscarAlumno extends AppCompatActivity {

    public EditText nombreEt, numeroEt;
    public TextView tv;
    public HashMap<Integer, String> alumnos = new HashMap<Integer, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_alumno);
        alumnos = Utils.getHashMap("Lista_Alumnos",this);

        nombreEt = (EditText)findViewById(R.id.nombreAlumno);
        numeroEt = (EditText)findViewById(R.id.numeroAlumno);
        tv = (TextView)findViewById(R.id.alumno);
        for(Map.Entry<Integer, String> entry: alumnos.entrySet()){
            tv.setText(tv.getText()+"\n"+entry.getKey()+": "+entry.getValue());
        }
    }

    public void buscarVoid(View view) {
        String nombre = nombreEt.getText().toString();
        for(Integer i : alumnos.keySet()){
            if(alumnos.get(i).equals(nombre)){
                tv.setText(i+"");
            }
        }
    }
}
