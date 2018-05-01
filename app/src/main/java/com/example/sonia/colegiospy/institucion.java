package com.example.sonia.colegiospy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class institucion extends AppCompatActivity {

    
    private TextView anio, idInstitu, codInstitu,nomInstitu, uriInstitu, codDepart,nomDepart,
    codDistrito, nomDistrito, codBarrio, nomBarrio, codZona, nomZona;
    
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institucion);
        construirTextviews();
        recibirMensaje();
    }
    
    
    
    private void construirTextviews(){
        anio= (TextView)findViewById(R.id.infoAnio);
        idInstitu= (TextView)findViewById(R.id.infoIdInstitu);
        codInstitu= (TextView)findViewById(R.id.infoCodInstitu);
        nomInstitu= (TextView)findViewById(R.id.infoNomInstitu);
        uriInstitu= (TextView)findViewById(R.id.infoUriInstitu);
        codDepart= (TextView)findViewById(R.id.infoCodDepart);
        nomDepart= (TextView)findViewById(R.id.infoNomDepart);
        codDistrito= (TextView)findViewById(R.id.infoCodDistri);
        nomDistrito= (TextView)findViewById(R.id.infoNomDistri); 
        codBarrio= (TextView)findViewById(R.id.infoCodBarrio);
        nomBarrio= (TextView)findViewById(R.id.infoNomBarrio);
        codZona= (TextView)findViewById(R.id.infoCodZona);
        nomZona= (TextView)findViewById(R.id.infoNomZona);
    }
    
    
    
    
    private void recibirMensaje(){

        Bundle extras = getIntent().getExtras();
        String[] stringArray = getResources().getStringArray(R.array.prop_instituciones);
        for (String key : stringArray ) {
            if (key.equals("anio"))
                anio.setText( extras.getString(key));
            if (key.equals("anio"))
                idInstitu.setText( extras.getString(key));
            if (key.equals("anio"))
                codInstitu.setText( extras.getString(key));
            if (key.equals("anio"))
                nomInstitu.setText( extras.getString(key));
            if (key.equals("anio"))
                uriInstitu.setText( extras.getString(key));
            if (key.equals("anio"))
                codDepart.setText( extras.getString(key));
            if (key.equals("anio"))
                nomDepart.setText( extras.getString(key));
            if (key.equals("anio"))
                codDistrito.setText( extras.getString(key));
            if (key.equals("anio"))
                nomDistrito.setText( extras.getString(key));
            if (key.equals("anio"))
                codBarrio.setText( extras.getString(key));
            if (key.equals("anio"))
                nomBarrio.setText( extras.getString(key));
            if (key.equals("anio"))
                codZona.setText( extras.getString(key));
            if (key.equals("anio"))
                nomZona.setText( extras.getString(key));
          }
    }
}
