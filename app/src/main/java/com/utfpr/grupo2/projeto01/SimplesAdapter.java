package com.utfpr.grupo2.projeto01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class SimplesAdapter extends BaseAdapter {

    private String[] dias = new String[]{"Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado", "Domingo"};
    private Context context;

    public SimplesAdapter(Context context){
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return dias.length;
    }

    @Override
    public Object getItem(int position) {
        return dias[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String dia = dias[position];
        View view = LayoutInflater.from(context).inflate(R.layout.days_layout,parent,false);
        CheckBox checkBox = (CheckBox)view.findViewById(R.id.checkDays);
        checkBox.setHint(dia);
        return view;
    }
}
