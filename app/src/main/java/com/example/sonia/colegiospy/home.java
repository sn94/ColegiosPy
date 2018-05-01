package com.example.sonia.colegiospy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.sonia.colegiospy.GrillaAdapter.GrillaAdapter;
import com.example.sonia.colegiospy.pojos.Institucion;
import com.example.sonia.colegiospy.pojos.ListaInstituciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class home extends AppCompatActivity {



    ArrayList<Institucion> lista=  null ; 
    SwipeRefreshLayout MiSwpLayout;
    ListView MyListView;
    Adapter adaptador;
    
    
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        obtLista();
        crearListView();
        crear_fab();
   
    }

    private void obtLista(){
       lista = new ListaInstituciones(getBaseContext()).getLista();
    }
    
    public void crearListView(){

        /*MiSwpLayout=  (SwipeRefreshLayout) findViewById(R.id.MiSwpRefresh );*/
        MyListView= (ListView) findViewById( R.id.MiListView);
        String[] inst_pro= getResources().getStringArray( R.array.prop_instituciones );
        MyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               buscarPorDepartamento( position);
            }
        });
             
 
        ArrayAdapter arrayAdapter=
                new ArrayAdapter(this,android.R.layout.simple_list_item_1,lista);
        
        MyListView.setAdapter( arrayAdapter );

        /*
        MiSwpLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescar_contenido();
            }
        });*/
    }
    
    
    /*
    public void refrescar_contenido(){
        String[] inst_pro= getResources().getStringArray( R.array.prop_instituciones );
        ArrayAdapter arrayAdapter=
                new ArrayAdapter(this,android.R.layout.simple_list_item_1,inst_pro);
        MyListView.setAdapter( arrayAdapter );
        MiSwpLayout.setRefreshing( false );//deshabilitar la visibilidad del progreso
        
        
    }*/
    
    
    
    private void buscarPorDepartamento( int pos){
        Institucion institucion = lista.get(pos);
        // Enviar datos a otro activity
        Intent activiIndi= new Intent(this, 
        com.example.sonia.colegiospy.institucion.class);
       
        //Propiedades de objeto institucion
        String[] stringArray = getResources().getStringArray(R.array.prop_instituciones);

        for (String ele: stringArray ) {
           activiIndi.putExtra(ele,
                   institucion.getPropertyValue(this, institucion, ele) );
        }
        startActivity( activiIndi);

    }
    
    public void  crear_fab(){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.snackbar_welcome), Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
     
                        .setActionTextColor( getResources().getColor( R.color.colorPrimaryDark))
                        .show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    
    
   
  

}
