package com.example.asistenciabusesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import com.example.asistenciabusesapp.utils.Utils;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

    public void nuevoViajeVoid(View view) {
        startActivity(new Intent(this, InsertarMatriculaNombreActivity.class));
    }

    public void administrarListasVoid(View view) {
        startActivity(new Intent(this, ModificarListaActivity.class));
    }


}
