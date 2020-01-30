package com.example.asistenciabusesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.asistenciabusesapp.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    final int CODI_PETICIO = 11;
    public String message="";
    public String intro = "";
    public EditText et;
    public TextView lista;
    public HashMap<Integer, String> alumnos = new HashMap<Integer, String>();
    public Context context = MainActivity.this;
    public int contador = 0;
    public int bach = 1;
    public ArrayList<String> listaAlumnos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText)findViewById(R.id.editText);
//        et.setOnKeyListener(new View.OnKeyListener(){
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if(keyCode == KeyEvent.KEYCODE_ENTER){
//                    if(et.getText().toString().isEmpty()){
//                        new AlertDialog.Builder(getApplicationContext())
//                                .setTitle("Error")
//                                .setMessage("No ha escrito ningún numero")
//                                .setPositiveButton(android.R.string.yes,null)
//                                .setIcon(android.R.drawable.ic_dialog_alert)
//                                .show();
//                    }else{
//                        Integer numero = Integer.parseInt(et.getText().toString());
//                        if(numero > alumnos.size()){
//                            new AlertDialog.Builder(getApplicationContext())
//                                    .setTitle("Error")
//                                    .setMessage("Este numero no se encuentra en la lista")
//                                    .setPositiveButton(android.R.string.yes,null)
//                                    .setIcon(android.R.drawable.ic_dialog_alert)
//                                    .show();
//                        }else{
//                            if(listaAlumnos.contains(numero+"")){
//                                new AlertDialog.Builder(getApplicationContext())
//                                        .setTitle("Error")
//                                        .setMessage("Alumno ya añadido")
//                                        .setPositiveButton("Buscar el nombre", new DialogInterface.OnClickListener() {
//                                            @Override
//                                            public void onClick(DialogInterface dialog, int which) {
//                                                startActivity(new Intent(context, BuscarAlumno.class));
//                                            }
//                                        })
//                                        .setNegativeButton(android.R.string.no, null)
//                                        .setIcon(android.R.drawable.ic_dialog_alert)
//                                        .show();
//                            }else{
//                                message = message+"\n"+numero;
//                                listaAlumnos.add(numero+"");
//                                listaAlumnos.add(alumnos.get(numero));
//                                Toast.makeText(getApplicationContext(), alumnos.get(numero)+" añadido", Toast.LENGTH_SHORT).show();
//                                et.setText("");
//                                contador++;
//                            }
//                        }
//                        lista.setText(intro+"\n"+message+"\nTotal: "+contador);
//                    }
//                }
//                return false;
//            }
//        });
        if(Utils.getHashMap("Lista_Alumnos",this)==null){
            startActivity(new Intent(this,LlenarListaActivity.class));
            alumnos = Utils.getHashMap("Lista_Alumnos",this);
        }else{
            alumnos = Utils.getHashMap("Lista_Alumnos",this);
        }
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            intro = extras.getString("Valor");
        }
        lista = findViewById(R.id.lista);
        lista.setText(intro+"\n"+message+"\nTotal: "+contador);
    }


    public void añadirVoid(View view) {
        if(et.getText().toString().isEmpty()){
            new AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("No ha escrito ningún numero")
                    .setPositiveButton(android.R.string.yes,null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }else{
            Integer numero = Integer.parseInt(et.getText().toString());
            if(numero > alumnos.size()){
                new AlertDialog.Builder(this)
                        .setTitle("Error")
                        .setMessage("Este numero no se encuentra en la lista")
                        .setPositiveButton(android.R.string.yes,null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }else{
                if(listaAlumnos.contains(numero+"")){
                    new AlertDialog.Builder(this)
                            .setTitle("Error")
                            .setMessage("Alumno ya añadido")
                            .setPositiveButton("Buscar el nombre", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(context, BuscarAlumno.class));
                                }
                            })
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }else{
                    message = message+"\n"+numero;
                    listaAlumnos.add(numero+"");
                    listaAlumnos.add(alumnos.get(numero));
                    Toast.makeText(this, alumnos.get(numero)+" añadido", Toast.LENGTH_SHORT).show();
                    et.setText("");
                    contador++;
                }
            }
            lista.setText(intro+"\n"+message+"\nTotal: "+contador);
        }

    }

    public void enviarVoid(View view) {
        Intent compartit = new Intent(Intent.ACTION_SEND);
        compartit.setType("text/plain");
        compartit.putExtra(android.content.Intent.EXTRA_TEXT,intro+"\n"+Utils.ordenarString(Utils.corregirString(message))+"\nTotal de alumnos: "+contador);
        startActivity(compartit);
    }

    public void buscarAlumnoVoid(View view) {
        startActivity(new Intent(this, BuscarAlumno.class));
    }

    public void añadirBachillerVoid(View view) {
        Toast.makeText(this, "Alumno de bachiller añadido", Toast.LENGTH_SHORT).show();
        et.setText("");
        contador++;
        lista.setText(intro+"\n"+message+"\nTotal: "+contador);
        listaAlumnos.add(bach+"b");
        listaAlumnos.add("Bachiller");
        bach++;
    }

    public void manualVoid(View view) {
        new AlertDialog.Builder(context)
                .setTitle("Atención")
                .setMessage("Modificar la lista manualmente puede provocar problemas de recuento")
                .setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(context, LlenarListaActivity.class);
                        i.putExtra("Valor", message);
                        startActivityForResult(i,CODI_PETICIO);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == CODI_PETICIO) {
            if (data.hasExtra("Return1")) {
                message = data.getExtras().getString("Return1");
            }
        }
        lista.setText(intro + "\n" + message + "\nTotal: " + contador);
    }

    public void borrarUltimoVoid(View view) {
        if(listaAlumnos.size()==0){
            new AlertDialog.Builder(context)
                    .setTitle("Error")
                    .setMessage("No ha añadido nigún alumno a la lista")
                    .setPositiveButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }else{
            String numero = listaAlumnos.get(listaAlumnos.size()-2);
            String nombre = listaAlumnos.get(listaAlumnos.size()-1);
            String numaux = numero.replace("b","");
            int truncateIndex = message.length();
            for (int i = 0; i < 1; i++) {
                truncateIndex = message.lastIndexOf('\n', truncateIndex - 1);
            }

            message = message.substring(0, truncateIndex);
            contador--;
            lista.setText(message+"\nTotal: "+contador);
            Toast.makeText(this, nombre+" borrado", Toast.LENGTH_SHORT).show();
            listaAlumnos.remove(listaAlumnos.indexOf(numero));
            listaAlumnos.remove(listaAlumnos.indexOf(nombre));
        }
    }
}
