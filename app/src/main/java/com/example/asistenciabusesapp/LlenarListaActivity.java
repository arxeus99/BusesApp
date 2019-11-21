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

import java.util.ArrayList;
import java.util.HashMap;

public class LlenarListaActivity extends AppCompatActivity {

    public EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenar_lista);
        et = findViewById(R.id.lista);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            et.setText(extras.getString("Valor"));
        }
    }


    public void finish(){
        String message = et.getText().toString();
        Intent data = new Intent();
        data.putExtra("Return1", message);
        setResult(RESULT_OK, data);
        super.finish();
    }

}
