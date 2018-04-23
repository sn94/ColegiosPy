package com.example.sonia.colegiospy;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LecturaJson {

        private Context contex;




        public LecturaJson(Context co){
                this.contex=  co;
        }


        public String leerFuenteDeDatos(){
                StringBuffer sb = new StringBuffer();
                BufferedReader br = null;

                try{
                        br = new BufferedReader(
                                new InputStreamReader(
                                       contex.getResources().openRawResource(R.raw.instituciones_lista)));
                        String line;

                        while((line = br.readLine()) != null){
                                sb.append(line);
                        }

                }catch (IOException e){
                        e.printStackTrace();
                }finally {
                        try{
                                br.close();
                        }catch (IOException e){
                                e.printStackTrace();
                        }
                }

                return sb.toString();
        }
    
    
        }







