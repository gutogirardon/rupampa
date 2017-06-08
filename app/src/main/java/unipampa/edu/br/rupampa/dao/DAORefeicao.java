package unipampa.edu.br.rupampa.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import unipampa.edu.br.rupampa.model.Refeicao;

/**
 * Imported by Guto on 22/11/2016.
 */

public class DAORefeicao {
    private FeedReaderDbHelper refeicaoHelper;
    SQLiteDatabase database;



    public DAORefeicao(Context context) {
        refeicaoHelper = new FeedReaderDbHelper(context);
    }

    public boolean update(Refeicao refeicao) {
        try {

            database = refeicaoHelper.getWritableDatabase();

            ContentValues valores = new ContentValues();
            String where;

            where = FeedReaderContract.refeicaoTable._ID + "=" + refeicao.getId();

            valores.put(FeedReaderContract.refeicaoTable.COLUNA_AVALIACAO, refeicao.getAvaliacao());

            //criar o resto

            database.update(FeedReaderContract.refeicaoTable.NOME_TABELA,
                    valores, where, null);

            return true;
        } catch (Exception e) {

            return false;
        } finally {
            database.close();
        }
    }


    public void salvar(Refeicao refeicao) {
        SQLiteDatabase database = refeicaoHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FeedReaderContract.refeicaoTable.COLUNA_NOME, refeicao.getNomeRefeicao());
        values.put(FeedReaderContract.refeicaoTable.COLUNA_PRATOPRINCIPAL, refeicao.getPratoPrincipal());
        values.put(FeedReaderContract.refeicaoTable.COLUNA_ACOMPANHAMENTOS, refeicao.getAcompanhamentos());
        values.put(FeedReaderContract.refeicaoTable.COLUNA_GUARNICAO, refeicao.getGuarnicao());
        values.put(FeedReaderContract.refeicaoTable.COLUNA_SALADAS, refeicao.getSaladas());
        values.put(FeedReaderContract.refeicaoTable.COLUNA_SOBREMESA, refeicao.getSobremesa());
        values.put(FeedReaderContract.refeicaoTable.COLUNA_SUCO, refeicao.getSuco());
        values.put(FeedReaderContract.refeicaoTable.COLUNA_AVALIACAO, refeicao.getAvaliacao());
        values.put(FeedReaderContract.refeicaoTable.COLUNA_DATA, refeicao.getData().toString());
        values.put(FeedReaderContract.refeicaoTable.COLUNA_OPCAOVEG, refeicao.getOpcaoVeg());
        values.put(FeedReaderContract.refeicaoTable.COLUNA_ID, refeicao.getId());
        database.insert(
                FeedReaderContract.refeicaoTable.NOME_TABELA,
                FeedReaderContract.refeicaoTable.COLUNA_NOME,
                values);

    }

    public void deletar(long id) {
        SQLiteDatabase database = refeicaoHelper.getWritableDatabase();
        String where;

        where = FeedReaderContract.refeicaoTable._ID + "=" + id;

        database.delete(FeedReaderContract.refeicaoTable.NOME_TABELA,where,null);

    }

    public Refeicao retrieve(long cod){

        SQLiteDatabase database = refeicaoHelper.getReadableDatabase();
        Refeicao refeicao = new Refeicao();


        try {
            String selectQuery =
                    "SELECT * FROM correspondente WHERE id =" + cod;
            Cursor c = database.rawQuery(selectQuery,null);
            c.moveToFirst();

            for (int i = 0; i < c.getCount(); i++) {
                long id = c.getLong(
                        c.getColumnIndex(FeedReaderContract.refeicaoTable._ID)
                );
                String nome = c.getString(
                        c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_NOME)
                );
                String pratoPrincipal = c.getString(
                        c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_PRATOPRINCIPAL)
                );
                String acompanhamentos = c.getString(
                        c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_ACOMPANHAMENTOS)
                );

                String guarnicao = c.getString(
                        c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_GUARNICAO)
                );

                String saladas = c.getString(
                        c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_SALADAS)
                );

                String sobreMesas = c.getString(
                        c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_SOBREMESA)
                );
                String suco = c.getString(
                        c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_SUCO)
                );
                String avaliacao = c.getString(
                        c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_AVALIACAO)
                );
                String data = c.getString(
                        c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_DATA)
                );
                String opcaoVeg = c.getString(
                        c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_OPCAOVEG)
                );

                refeicao.setId(id);
                refeicao.setNomeRefeicao(nome);
                refeicao.setPratoPrincipal(pratoPrincipal);
                refeicao.setAcompanhamentos(acompanhamentos);
                refeicao.setGuarnicao(guarnicao);
                refeicao.setSaladas(saladas);
                refeicao.setSobremesa(sobreMesas);
                refeicao.setSuco(suco);
                refeicao.setAvaliacao(avaliacao);
                refeicao.setData(data);
                refeicao.setOpcaoVeg(opcaoVeg);



            }
            return refeicao;
        }catch(Exception e){
            System.out.println("Erro na busca");
            return null;
        }


    }

    public ArrayList<Refeicao> pesquisarTodos() {

        ArrayList<Refeicao> refeicoes = new ArrayList<>();

        SQLiteDatabase database = refeicaoHelper.getReadableDatabase();

        String[] colunas = {FeedReaderContract.refeicaoTable._ID,
                FeedReaderContract.refeicaoTable.COLUNA_NOME,
                FeedReaderContract.refeicaoTable.COLUNA_PRATOPRINCIPAL,
                FeedReaderContract.refeicaoTable.COLUNA_ACOMPANHAMENTOS, FeedReaderContract.refeicaoTable.COLUNA_GUARNICAO,
                FeedReaderContract.refeicaoTable.COLUNA_SALADAS, FeedReaderContract.refeicaoTable.COLUNA_SOBREMESA,
                FeedReaderContract.refeicaoTable.COLUNA_AVALIACAO,
                FeedReaderContract.refeicaoTable.COLUNA_SUCO, FeedReaderContract.refeicaoTable.COLUNA_DATA,
                FeedReaderContract.refeicaoTable.COLUNA_OPCAOVEG};

        Cursor c = database.query(
                FeedReaderContract.refeicaoTable.NOME_TABELA,  // The table to query
                colunas,                               // The columns to return
                // The columns for the WHERE clause
                // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        c.moveToFirst();

        for(int i = 0; i < c.getCount(); i++){
            long id = c.getLong(
                    c.getColumnIndex(FeedReaderContract.refeicaoTable._ID)
            );
            String nome = c.getString(
                    c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_NOME)
            );
            String pratoPrincipal = c.getString(
                    c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_PRATOPRINCIPAL)
            );
            String acompanhamentos = c.getString(
                    c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_ACOMPANHAMENTOS)
            );

            String guarnicao = c.getString(
                    c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_GUARNICAO)
            );

            String saladas = c.getString(
                    c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_SALADAS)
            );

            String sobreMesas = c.getString(
                    c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_SOBREMESA)
            );
            String suco = c.getString(
                    c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_SUCO)
            );
            String avaliacao = c.getString(
                    c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_AVALIACAO)
            );
            String data = c.getString(
                    c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_DATA)
            );
            String opcaoveg = c.getString(
                    c.getColumnIndex(FeedReaderContract.refeicaoTable.COLUNA_OPCAOVEG)
            );

            Refeicao refeicao = new Refeicao();
            refeicao.setId(id);
            refeicao.setNomeRefeicao(nome);
            refeicao.setPratoPrincipal(pratoPrincipal);
            refeicao.setAcompanhamentos(acompanhamentos);
            refeicao.setGuarnicao(guarnicao);
            refeicao.setSaladas(saladas);
            refeicao.setSobremesa(sobreMesas);
            refeicao.setSuco(suco);
            refeicao.setAvaliacao(avaliacao);
            refeicao.setData(data);
            refeicao.setOpcaoVeg(opcaoveg);

            refeicoes.add(refeicao);
            c.moveToNext();
        }

        return refeicoes;
    }
}
