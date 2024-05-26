package com.example.myapplication.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.constantes.DbConstants;

public class PessoaDbHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "pessoas.db";
    private final static int DB_VERSION = 1;

    private static final String CREATE_TABLE_PESSOA = "create table " + DbConstants.PESSOA.TABLE_NAME + " ("
            + DbConstants.PESSOA.COLUMNS.ID + " integer primary key autoincrement, "
            + DbConstants.PESSOA.COLUMNS.USUARIO + " text UNIQUE,"
            + DbConstants.PESSOA.COLUMNS.SENHA + " text, "
            + DbConstants.PESSOA.COLUMNS.NOME + " text, "
            + DbConstants.PESSOA.COLUMNS.RUA + " text, "
            + DbConstants.PESSOA.COLUMNS.BAIRRO + " text, "
            + DbConstants.PESSOA.COLUMNS.NUMERO +" integer);";

    public PessoaDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PESSOA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
