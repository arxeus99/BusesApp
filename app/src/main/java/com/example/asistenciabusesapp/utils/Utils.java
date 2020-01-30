package com.example.asistenciabusesapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class Utils {

    public static HashMap<Integer,String> getHashMap(String key, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = prefs.getString(key,"");
        java.lang.reflect.Type type = new TypeToken<HashMap<Integer,String>>(){}.getType();
        HashMap<Integer,String> obj = gson.fromJson(json, type);
        return obj;
    }

    public static void saveHashmap(String key, Object hashmap, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(hashmap);
        editor.putString("Lista_Alumnos",json);
        editor.apply();   // This line is IMPORTANT !!!
    }

    public static void saveArrayList(ArrayList<String> list, String key, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public static ArrayList<String> getArrayList(String key, Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public static String ordenarString(String numeros){
        numeros = numeros.trim();
        String[] info = numeros.split("\n");
        ArrayList<Integer> numerosArrayList = new ArrayList<>();
        for(String s : info){
            numerosArrayList.add(Integer.parseInt(s));
        }
        int[] numerosArray = new int[numerosArrayList.size()];
        for(int i=0; i<numerosArray.length; i++){
            numerosArray[i] = numerosArrayList.get(i);
        }
        Arrays.sort(numerosArray);
        String resultado = "";
        for(int i : numerosArray) {
            resultado = resultado+i+"\n";
        }
        return resultado;
    }

    public static String corregirString(String numeros){
        String[] info = numeros.split("\n");
        String resultado = "";
        String aux;
        for(String s : info){
            switch (s){
                case "16":{
                    aux = "15";
                    break;
                }case "17":{
                    aux = "16";
                    break;
                }case "18":{
                    aux = "17";
                    break;
                }case "19":{
                    aux = "18";
                    break;
                }case "20":{
                    aux = "19";
                    break;
                }case "21":{
                    aux = "20";
                    break;
                }case "22":{
                    aux = "21";
                    break;
                }case "23":{
                    aux = "22";
                    break;
                }case "24":{
                    aux = "23";
                    break;
                }case "25":{
                    aux = "24";
                    break;
                }case "26":{
                    aux = "25";
                    break;
                }case "27":{
                    aux = "26";
                    break;
                }case "28":{
                    aux = "27";
                    break;
                }case "29":{
                    aux = "28";
                    break;
                }case "56":{
                    aux = "29";
                    break;
                }default:{
                    aux = s;
                }
            }
            resultado = resultado+"\n"+aux;
        }
        return resultado;
    }
}
