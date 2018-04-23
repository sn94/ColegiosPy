package com.example.sonia.colegiospy.pojos;

import android.content.Context;
import android.util.JsonReader;
import android.util.Log;

import com.example.sonia.colegiospy.LecturaJson;
import com.example.sonia.colegiospy.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ListaInstituciones {
    
    private Context contex;
        private ArrayList<Institucion> lista;
    
    
    
    
    public ListaInstituciones(Context co){
        this.contex=  co;
        this.lista=  new ArrayList<Institucion>();
    }



     
    private Institucion leerObjetoDesdeJson(JsonReader arg){

        Institucion temp_inst= new Institucion();
        
        try {
            arg.beginObject();
            while(arg.hasNext()){
                //recorrer propiedad
                
                String propiedad="";
                String valor_pro="";
                try {
                    propiedad=  arg.nextName();

                    Log.d("propiedad", propiedad);
                    //leer valor de propiedad
                    try {
                        valor_pro= arg.nextString();
                    }catch (IllegalStateException se){
                        //se.printStackTrace();
                    }
                    //verificar de que propiedad se trata
                    temp_inst.setPropertyValue(contex,  temp_inst,  propiedad, valor_pro );

                }catch (IllegalStateException se){
                    //se.printStackTrace();
                }
                }
            arg.endObject();
            
        } 
        
        catch (IOException e) {
            e.printStackTrace();
        }

        return temp_inst;    }
    
 private void CargarListaDesdeJson(JsonReader jsonr){
     try {
         jsonr.beginArray();
         while( jsonr.hasNext() ){ 
             lista.add(leerObjetoDesdeJson( jsonr ) );
         }
         jsonr.endArray();//libera de la memoria
     } catch (IOException e) {
         e.printStackTrace();
     }

    
 }
    
    private JsonReader LeerDesdeArchivo(){

      InputStream input_stream= contex.getResources().openRawResource(R.raw.instituciones_lista);
        try {
            JsonReader jsonr= new JsonReader( new InputStreamReader( input_stream ,"UTF-8"));
        return jsonr;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
    
    public ArrayList<Institucion>  getLista(){
        JsonReader jsr= LeerDesdeArchivo();
        CargarListaDesdeJson(  jsr  );
        return this.lista;
    }
    
}
