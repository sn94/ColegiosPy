package com.example.sonia.colegiospy.GrillaAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.example.sonia.colegiospy.R;

import org.w3c.dom.Text;

public class GrillaAdapter extends BaseAdapter {

private Context mContext;
private String[] list_departs;

    public GrillaAdapter(Context c) {
        mContext=c;
        list_departs= c.getResources().getStringArray(R.array.departamentos );
    }

    @Override
    public int getCount() {
        return list_departs.length;
    }

    @Override
    public Object getItem(int position) {
        return list_departs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView txt1;
        if( convertView == null ){
            txt1= new TextView( mContext );
            txt1.setText( list_departs[position ] );
            txt1.setLayoutParams(  new GridLayout.LayoutParams());
            txt1.setPadding(8,8,8,8);
        }else{
            txt1= (TextView) convertView;
        }
        return txt1;
    }
}
