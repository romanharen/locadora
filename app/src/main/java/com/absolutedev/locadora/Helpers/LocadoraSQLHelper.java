package com.absolutedev.locadora.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abner on 14/10/17.
 */

public class LocadoraSQLHelper extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "dbRevenda";
    private static final int VERSAO_BANCO = 1;

    public static final String TABELA_CLIENTES = "CLIENTES";
    public static final String TABELA_CARROS = "CARROS";
    public static final String TABELA_VENDEDORES = "VENDEDORES";

    public LocadoraSQLHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABELA_CLIENTES + " (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TIPO TEXT NOT NULL, " +
                "DOCUMENTO TEXT, " +
                "NOME TEXT, " +
                "RENDA INTEGER, " +
                "OBSERVACAO TEXT " +
                ") ");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABELA_CARROS + " (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "MODELO TEXT NOT NULL, " +
                "ANO TEXT NOT NULL, " +
                "FABRICANTE INTEGER NOT NULL, " +
                "GASOLINA INTEGER, " +
                "ETANOL INTEGER, " +
                "PRECO TEXT" +
                ") ");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABELA_VENDEDORES + " (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NOME TEXT, " +
                "CPF INTEGER, " +
                "TELEFONE INTEGER," +
                "EMAIL TEXT," +
                ") ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // PARA AS PRÓXIMAS VERSÕES
    }
}
