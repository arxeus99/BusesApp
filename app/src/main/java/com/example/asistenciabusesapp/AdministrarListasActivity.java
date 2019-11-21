package com.example.asistenciabusesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.asistenciabusesapp.utils.Utils;

import java.util.ArrayList;

public class AdministrarListasActivity extends AppCompatActivity {

    public ArrayList<String> nombres = new ArrayList<String>();
    public Context context = AdministrarListasActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar_listas);
        LinearLayout linearLayout = new LinearLayout(this);
        nombres = Utils.getArrayList("Nombres_Listas",this);
        for(String s: nombres){
            Button b = new Button(this);
            b.setText(s);
            b.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    Button button = (Button)view;
                    Intent i = new Intent(context, ModificarListaActivity.class);
                    i.putExtra("Valor", button.getText().toString());
                    startActivity(i);
                }
            });
            linearLayout.addView(b);
        }
        Button b = new Button(this);
        b.setText("Crear nueva lista");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, LlenarListaActivity.class));
            }
        });
        linearLayout.addView(b);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        this.setContentView(linearLayout, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        ));
    }

    public void verListaVoid(){

    }
}
