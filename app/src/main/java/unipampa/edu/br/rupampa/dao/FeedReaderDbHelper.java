package unipampa.edu.br.rupampa.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Guto on 25/11/2016.
 */

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    private static final String BANCO_NOME = "refeicao.db";
    private static final int BANCO_VERSAO = 1;
    public FeedReaderDbHelper(Context context) {
        super(context, BANCO_NOME, null, BANCO_VERSAO);

    }

    private static final String TIPO = " TEXT";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.refeicaoTable.NOME_TABELA + " (" +
                    FeedReaderContract.refeicaoTable._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.refeicaoTable.COLUNA_NOME + TIPO +" , "+
                    FeedReaderContract.refeicaoTable.COLUNA_PRATOPRINCIPAL + TIPO +" , "+
                    FeedReaderContract.refeicaoTable.COLUNA_ACOMPANHAMENTOS + TIPO +" , " +
                    FeedReaderContract.refeicaoTable.COLUNA_GUARNICAO + TIPO +" , "+
                    FeedReaderContract.refeicaoTable.COLUNA_SALADAS + TIPO +" , "+
                    FeedReaderContract.refeicaoTable.COLUNA_SOBREMESA + TIPO +" , " +
                    FeedReaderContract.refeicaoTable.COLUNA_SUCO +TIPO +" , " +
                    FeedReaderContract.refeicaoTable.COLUNA_AVALIACAO + TIPO +" , " +
                    FeedReaderContract.refeicaoTable.COLUNA_DATA + TIPO+ " , "+
                    FeedReaderContract.refeicaoTable.COLUNA_OPCAOVEG + TIPO+ " ) ";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.refeicaoTable.NOME_TABELA;
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        Log.i("Banco de dados","Criando banco de dados!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onOpen(SQLiteDatabase db){

    }


}
