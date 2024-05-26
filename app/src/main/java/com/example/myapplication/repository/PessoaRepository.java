package com.example.myapplication.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.constantes.DbConstants;
import com.example.myapplication.model.Pessoa;
import com.example.myapplication.model.PessoaDbHelper;

public class PessoaRepository {

    private static PessoaRepository INSTANCE;

    private PessoaDbHelper mHelper;

    public PessoaRepository(Context context) {
        this.mHelper = new PessoaDbHelper(context);
    }

    public boolean insert(Pessoa pessoa) {

     try {
            SQLiteDatabase db = this.mHelper.getWritableDatabase();

            ContentValues contentValues = new ContentValues();

            contentValues.put(DbConstants.PESSOA.COLUMNS.USUARIO, pessoa.getUsuario());
            contentValues.put(DbConstants.PESSOA.COLUMNS.SENHA, pessoa.getSenha());
            contentValues.put(DbConstants.PESSOA.COLUMNS.NOME, pessoa.getNome());
            contentValues.put(DbConstants.PESSOA.COLUMNS.RUA, pessoa.getRua());
            contentValues.put(DbConstants.PESSOA.COLUMNS.BAIRRO, pessoa.getUsuario());
            contentValues.put(DbConstants.PESSOA.COLUMNS.NUMERO, pessoa.getNumero());

            db.insert(DbConstants.PESSOA.TABLE_NAME, null, contentValues);
            db.close();
            return true;

     } catch (Exception e) {
            e.printStackTrace();
     }
     return false;
    }

    public boolean checkUser(String usuario, String senha) {
        Cursor cursor;
        SQLiteDatabase db = this.mHelper.getReadableDatabase();
        if (senha != null && !senha.trim().isEmpty()) {

           cursor  = db.rawQuery("SELECT * FROM " + DbConstants.PESSOA.TABLE_NAME + " WHERE " + DbConstants.PESSOA.COLUMNS.USUARIO + " = ? AND " + DbConstants.PESSOA.COLUMNS.SENHA + " = ?", new String[]{usuario, senha});
        } else {
            cursor = db.rawQuery("SELECT * FROM " + DbConstants.PESSOA.TABLE_NAME + " WHERE " + DbConstants.PESSOA.COLUMNS.USUARIO + " = ? ", new String[]{usuario});
        }
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }
}
