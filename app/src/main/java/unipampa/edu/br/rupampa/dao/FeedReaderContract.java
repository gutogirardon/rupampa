package unipampa.edu.br.rupampa.dao;

import android.provider.BaseColumns;

/**
 * Created by Guto on 25/11/2016.
 */
public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public FeedReaderContract() {}

    /* Inner class that defines the table contents */

    public static abstract class refeicaoTable implements BaseColumns {

        public static final String NOME_TABELA = "refeicao";
        public static final String COLUNA_ID = "_id";
        public static final String COLUNA_NOME = "nome_refeicao";
        public static final String COLUNA_ACOMPANHAMENTOS = "acompanhamentos";
        public static final String COLUNA_PRATOPRINCIPAL = "pratoPrincipal";
        public static final String COLUNA_GUARNICAO = "guarnicao";
        public static final String COLUNA_SALADAS = "saladas";
        public static final String COLUNA_SOBREMESA = "sobremesa";
        public static final String COLUNA_SUCO = "suco";
        public static final String COLUNA_AVALIACAO ="avaliacao" ;
        public static final String COLUNA_DATA = "data";
        public static final String COLUNA_OPCAOVEG = "opcaoVeg";


    }
}
