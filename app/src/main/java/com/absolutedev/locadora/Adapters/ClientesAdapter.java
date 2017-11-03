package com.absolutedev.locadora.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.absolutedev.locadora.Models.Cliente;

import java.util.List;

/**
 * Created by Infranet on 03/11/2017.
 */

public class ClientesAdapter extends BaseAdapter{

    Context context;
    List<Cliente>  clientes;

    public ClientesAdapter(Context context, List<Cliente> clientes){
        this.context = context;
        this.clientes = clientes;
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int i) {
        return clientes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return clientes.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        Cliente cliente = clientes.get(i) ;
        View linha = LayoutInflater.from(context).inflate()
        return null;
    }
}
