package com.absolutedev.locadora.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.absolutedev.locadora.Helpers.*;

/**
 * Created by Infranet on 03/11/2017.
 */

public class CarroDAO {
    private LocadoraSQLHelper helper;

    public static final String TABELA_CARROS = "CARROS";
    public static final String COLUNA_ID = "ID";
    public static final String COLUNA_MODELO = "MODELO";
    public static final String COLUNA_ANO = "ANO";
    public static final String COLUNA_FABRICANTE = "FABRICANTE";
    public static final String COLUNA_GASOLINA = "GASOLINA";
    public static final String COLUNA_ETANOL = "ETANOL";
    public static final String COLUNA_PRECO = "PRECO";

    public CarroDAO(Context context){
        helper = new LocadoraSQLHelper(context);
    }
    public long inserir(Carro carro){
        SQLiteDatabase database = helper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put();
    }


}
