package com.example.sonia.colegiospy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.sonia.colegiospy.GrillaAdapter.GrillaAdapter;

public class home extends AppCompatActivity {


            
            
    SwipeRefreshLayout MiSwpLayout;
    ListView MyListView;
    Adapter adaptador;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        crearLista();
        crear_fab();
    
    }

    public void crearLista(){

        MiSwpLayout=  (SwipeRefreshLayout) findViewById(R.id.MiSwpRefresh );
        MyListView= (ListView) findViewById( R.id.MiListView);
        String[] planetas= getResources().getStringArray( R.array.planets );
        
        ArrayAdapter arrayAdapter=
                new ArrayAdapter(this,android.R.layout.simple_list_item_1,planetas);
        
        MyListView.setAdapter( arrayAdapter );

        MiSwpLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescar_contenido();
            }
        });
    }
    
    
    
    public void refrescar_contenido(){
        String[] planetas= getResources().getStringArray( R.array.planets );
        ArrayAdapter arrayAdapter=
                new ArrayAdapter(this,android.R.layout.simple_list_item_1,planetas);
        MyListView.setAdapter( arrayAdapter );
        MiSwpLayout.setRefreshing( false );//deshabilitar la visibilidad del progreso
        
        
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
