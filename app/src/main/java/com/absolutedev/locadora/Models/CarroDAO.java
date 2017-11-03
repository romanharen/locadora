package com.absolutedev.locadora.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.absolutedev.locadora.Helpers.*;

import java.util.ArrayList;
import java.util.List;

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
        contentValues.put(COLUNA_MODELO, carro.getModelo());
        contentValues.put(COLUNA_ANO, carro.getAno());
        contentValues.put(COLUNA_FABRICANTE, carro.getFabricante());
        contentValues.put(COLUNA_GASOLINA, carro.getGasolina());
        contentValues.put(COLUNA_ETANOL, carro.getEtanol());
        contentValues.put(COLUNA_PRECO, carro.getPreco());

        long id = database.insert(TABELA_CARROS, null, contentValues);
        database.close();
        return id;
    }
    public long atualizar(Carro carro){
        SQLiteDatabase database = helper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUNA_MODELO, carro.getModelo());
        contentValues.put(COLUNA_ANO, carro.getAno());
        contentValues.put(COLUNA_FABRICANTE, carro.getFabricante());
        contentValues.put(COLUNA_GASOLINA, carro.getGasolina());
        contentValues.put(COLUNA_ETANOL, carro.getEtanol());
        contentValues.put(COLUNA_PRECO, carro.getPreco());

        long linhasAfetadas = database.update(
                TABELA_CARROS,
                contentValues,
                COLUNA_ID + " = ?",
                new String[]{String.valueOf(carro.getId())}
        );

        database.close();

        return linhasAfetadas;
    }
    public long salvar(Carro carro){
        if(carro.getId() != null){
            return atualizar(carro);
        }
        return inserir(carro);
    }
    public int excluir(Carro carro){
        SQLiteDatabase database = helper.getWritableDatabase();

        int linhasDeletadas = database.delete(
                TABELA_CARROS,
                COLUNA_ID + " = ?",
                new String[]{String.valueOf(carro.getId())}
        );
        database.close();
        return linhasDeletadas;
    }

    public List<Carro> all(){
        return buscarCarro(null);
    }
    public List<Carro> buscarCarro(String filtro){
        SQLiteDatabase database = helper.getReadableDatabase();
        String sql = "SELECT * FROM" + TABELA_CARROS;
        String[] args = null;
        if(filtro != null){
            sql += " WHERE " + COLUNA_MODELO + "LIKE ?";
            args = new String[] {filtro};
        }
        sql += " ORDER BY " + COLUNA_MODELO;

        Cursor cursor = database.rawQuery(sql, args);

        List<Carro> carros = new ArrayList<>();

        while(cursor.moveToNext()) {
            Long id = cursor.getLong(cursor.getColumnIndex(COLUNA_ID));
            String modelo = cursor.getString(cursor.getColumnIndex(COLUNA_MODELO));
            int ano = cursor.getInt(cursor.getColumnIndex(COLUNA_ANO));
            int fabricante = cursor.getInt(cursor.getColumnIndex(COLUNA_FABRICANTE));
            boolean gasolina = cursor.getInt(cursor.getColumnIndex(COLUNA_GASOLINA)) == 1;
            boolean etanol = cursor.getInt(cursor.getColumnIndex(COLUNA_ETANOL)) == 1;
            float preco = cursor.getFloat(cursor.getColumnIndex(COLUNA_PRECO));

            Carro carro = new Carro(id, modelo, ano, fabricante, gasolina, etanol, preco);
            carros.add(carro);
        }

        cursor.close();
        database.close();

        return carros;
    }

}
