package com.absolutedev.locadora.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import com.absolutedev.locadora.Models.Carro;
import com.absolutedev.locadora.R;

/**
 * Created by Infranet on 24/10/2017.
 */

public class CarrosAdapter extends BaseAdapter {

    public CarrosAdapter(Context ctx, List<Carro> carros){
        this.ctx = ctx;
        this.carros = carros;
    }

    Context ctx;
    List<Carro> carros;

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int i) {
        return carros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        Carro carro = carros.get(i);
        View linha = LayoutInflater.from(ctx).inflate(R.layout.item_carro, null);
        ImageView imgLogo = (ImageView) linha.findViewById(R.id.imageViewMarca);
        TextView txtModelo = (TextView) linha.findViewById(R.id.txtModelo);
        TextView txtAno = (TextView) linha.findViewById(R.id.txtAno);
        TextView txtCombustivel = (TextView) linha.findViewById(R.id.txtCombustivel);
        Resources res = ctx.getResources();
        TypedArray logos = res.obtainTypedArray(R.array.Logos);
        imgLogo.setImageDrawable(logos.getDrawable(carro.fabricante));
        txtModelo.setText(carro.modelo);
        txtAno.setText(String.valueOf(carro.ano));
        String combustivel = (carro.gasolina ? "G" :"" ) + (carro.etanol ? "E" : "");
        return linha;
    }
}
