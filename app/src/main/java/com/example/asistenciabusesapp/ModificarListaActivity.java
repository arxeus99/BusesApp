package com.example.asistenciabusesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asistenciabusesapp.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class ModificarListaActivity extends AppCompatActivity {


    public HashMap<Integer, String> alumnos = new HashMap<Integer,String>();
    public EditText etNumero;
    public EditText etNombre;
    public TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_lista);
        etNombre = findViewById(R.id.nombre);
        etNumero = findViewById(R.id.numero);
        tv = findViewById(R.id.lista);
        alumnos = Utils.getHashMap("Lista_Alumnos",this);
        for(Map.Entry<Integer, String> entry: alumnos.entrySet()){
            tv.setText(tv.getText()+"\n"+entry.getKey()+": "+entry.getValue());
        }
        /*for(Integer i : alumnos.keySet()){
            tv.setText(tv.getText()+"\n"+i+": "+alumnos.get(i));
        }*/
    }

    public void añadirAlumnoVoid(View view) {
        String nombre = etNombre.getText().toString();
        boolean encontrado = false;
        for(Integer i: alumnos.keySet()){
            if(alumnos.get(i).equals(nombre)){
                encontrado = true;
            }
        }
        if(encontrado == true){
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Este alumno ya se encuentra en la lista")
                    .setPositiveButton(android.R.string.yes,null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }else{
            alumnos.put(alumnos.size()+ 1, nombre);
            Toast.makeText(this, nombre+ " añadido", Toast.LENGTH_SHORT).show();
            etNumero.setText("");
            etNombre.setText("");
            tv.setText("");
            for(Integer i : alumnos.keySet()){
                tv.setText(tv.getText()+"\n"+i+": "+alumnos.get(i));
            }
        }
    }

    public void buscarVoid(View view) {
        if(etNumero.getText().toString().isEmpty()){
            String nombre = etNombre.getText().toString();
            for(Integer i : alumnos.keySet()){
                if(alumnos.get(i).equals(nombre)){
                    etNumero.setText(i+"");
                }
            }
        }else{
            if(etNombre.getText().toString().isEmpty()){
                Integer numero = Integer.parseInt(etNumero.getText().toString());
                etNombre.setText(alumnos.get(numero));
            }else{
                Toast.makeText(this, "Escriba nombre o numero del alumno que quiere encontrar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void modificarVoid(View view) {
        Integer numero = Integer.parseInt(etNumero.getText().toString());
        alumnos.remove(numero);
        alumnos.put(numero, etNombre.getText().toString());
        Toast.makeText(this, "Alumno modificado con exito", Toast.LENGTH_SHORT).show();
        etNombre.setText("");
        etNumero.setText("");
        tv.setText("");
        for(Integer i : alumnos.keySet()){
            tv.setText(tv.getText()+"\n"+i+": "+alumnos.get(i));
        }
    }

    public void guardarListaVoid(View view) {
        Utils.saveHashmap("Lista_Alumnos",alumnos, this);
        Toast.makeText(this,"Lista guardada con exito",Toast.LENGTH_SHORT).show();
    }
}
