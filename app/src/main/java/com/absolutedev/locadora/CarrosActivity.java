package com.absolutedev.locadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.absolutedev.locadora.Adapters.CarrosAdapter;
import com.absolutedev.locadora.Models.Carro;

import java.util.List;

public class CarrosActivity extends AppCompatActivity {
    List<Carro> carros;
    CarrosAdapter adapter;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carros);

        lista = (ListView) findViewById(R.id.listaCarros);

    }
}
