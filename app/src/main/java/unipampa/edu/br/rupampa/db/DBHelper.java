package unipampa.edu.br.rupampa.db;

/**
 * Created by Eric on 04/11/2016.
 */

// This class handles all the database activities
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import unipampa.edu.br.rupampa.model.Refeicao;

public class DBHelper extends SQLiteOpenHelper{


    private static final int DATABASE_VERSAO = 1;
    public static final String DATABASE_NOME = "rupampa.db";
    private static final String TABELA_REFEICOES = "refeicoes";
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_DATA = "data";
    private static final String COLUNA_TIPO = "tipo";
    private static final String COLUNA_PRATOPRINCIPAL = "pratoprincipal";
    private static final String COLUNA_OPCAOVEGETARIANA = "opcaovegetariana";
    private static final String COLUNA_ACOMPANHAMENTO = "acompanhamento";
    private static final String COLUNA_GUARNICAO = "guarnicao";
    private static final String COLUNA_SALADA = "salada";
    private static final String COLUNA_SOBREMESA = "sobremesa";
    private static final String COLUNA_SUCO = "suco";

public String getDatabaseNome(){
    return this.DATABASE_NOME;
}
    //We need to pass database information along to superclass
 //   public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
 //       super(context, DATABASE_NOME, factory, DATABASE_VERSAO);
  //  }

    public DBHelper(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABELA_REFEICOES + "(" +
                COLUNA_ID + " INTEGER PRIMARY KEY, " +
                COLUNA_DATA + " DATE, " +
                COLUNA_TIPO + " TEXT, " +
                COLUNA_PRATOPRINCIPAL + " TEXT, " +
                COLUNA_OPCAOVEGETARIANA + " TEXT, " +
                COLUNA_ACOMPANHAMENTO + " TEXT, " +
                COLUNA_GUARNICAO + " TEXT, " +
                COLUNA_SALADA + " TEXT, " +
                COLUNA_SOBREMESA + " TEXT, " +
                COLUNA_SUCO + " TEXT " +
                ");";
        db.execSQL(query);
    }
    //Lesson 51
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_REFEICOES);
        onCreate(db);
    }

    public void addRefeicao(Refeicao refeicao){
        ContentValues values = new ContentValues();
        values.put(COLUNA_ID, refeicao.getId());
        values.put(COLUNA_DATA, String.valueOf(refeicao.getData()));
        values.put(COLUNA_TIPO, refeicao.getTipo());
        values.put(COLUNA_PRATOPRINCIPAL, refeicao.getPratoPrincipal());
        values.put(COLUNA_OPCAOVEGETARIANA, refeicao.getOpcaoVegetariana());
        values.put(COLUNA_ACOMPANHAMENTO, refeicao.getAcompanhamento());
        values.put(COLUNA_GUARNICAO, refeicao.getGuarnicao());
        values.put(COLUNA_SALADA, refeicao.getSalada());
        values.put(COLUNA_SOBREMESA, refeicao.getSobremesa());
        values.put(COLUNA_SUCO, refeicao.getSuco());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABELA_REFEICOES, null, values);
        db.close();
    }

    public void deleteRefeicao(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABELA_REFEICOES + " WHERE " + COLUNA_ID + "=" + id + ";");
    }

    public List<Refeicao> getRefeicoes(){
        List<Refeicao> resultado = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABELA_REFEICOES + ";";// why not leave out the WHERE  clause?

        //Cursor points to a location in your results
        Cursor cursor = db.rawQuery(query, null);
        //Move to the first row in your results
        cursor.moveToFirst();

        //Position after the last row means the end of the results
        while (!cursor.isAfterLast()) {
            // null could happen if we used our empty constructor
            if (cursor.getString(cursor.getColumnIndex(COLUNA_ID)) != null) {
                Refeicao temp = new Refeicao();
                temp.setId(cursor.getInt(cursor.getColumnIndex(COLUNA_ID)));
                String data = cursor.getString(cursor.getColumnIndex(COLUNA_DATA));
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar dataRefeicao = Calendar.getInstance();
                try {
                    dataRefeicao.setTime(sdf.parse(data));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                temp.setData(dataRefeicao);
                temp.setTipo(cursor.getString(cursor.getColumnIndex(COLUNA_TIPO)));
                temp.setPratoPrincipal(cursor.getString(cursor.getColumnIndex(COLUNA_PRATOPRINCIPAL)));
                temp.setOpcaoVegetariana(cursor.getString(cursor.getColumnIndex(COLUNA_OPCAOVEGETARIANA)));
                temp.setAcompanhamento(cursor.getString(cursor.getColumnIndex(COLUNA_ACOMPANHAMENTO)));
                temp.setGuarnicao(cursor.getString(cursor.getColumnIndex(COLUNA_GUARNICAO)));
                temp.setSalada(cursor.getString(cursor.getColumnIndex(COLUNA_SALADA)));
                temp.setSobremesa(cursor.getString(cursor.getColumnIndex(COLUNA_SOBREMESA)));
                temp.setSuco(cursor.getString(cursor.getColumnIndex(COLUNA_SUCO)));
                resultado.add(temp);
            }
            cursor.moveToNext();
        }
        db.close();
        return resultado;
    }

}
