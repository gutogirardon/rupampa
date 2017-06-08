package unipampa.edu.br.rupampa.view;

import java.util.Comparator;

import unipampa.edu.br.rupampa.model.Refeicao;

/**
 * Created by Guto on 25/11/2016.
 */

public abstract class CompararDatas implements Comparator<Refeicao> {
    @Override
    public int compare(Refeicao refeicao1, Refeicao refeicao2) {
        return refeicao1.getData().compareToIgnoreCase(refeicao2.getData());
    }
}
