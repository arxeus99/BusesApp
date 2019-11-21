package com.example.asistenciabusesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertarMatriculaNombreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_matricula_nombre);
    }

    public void crearViajeVoid(View view) {
        EditText matricula = findViewById(R.id.matricula);
        EditText nombre = findViewById(R.id.nombre);
        String message = "Matricula: "+matricula.getText().toString()+"\n Nombre del conductor: "+nombre.getText().toString();
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("Valor", message);
        startActivity(i);
    }
}
