package unipampa.edu.br.rupampa.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import unipampa.edu.br.rupampa.R;
import unipampa.edu.br.rupampa.model.Refeicao;

/**
 * Created by Guto on 25/11/2016.
 */

public class ListViewAdapter extends ArrayAdapter<Refeicao> {

    Context mContext;
    int layoutResourceId;
    ArrayList<Refeicao> refeicoes;


    public ListViewAdapter(Context mContext, int layoutResourceId, ArrayList<Refeicao> refeicao) {

        super(mContext, layoutResourceId, refeicao);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.refeicoes = refeicao;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        Refeicao objectItem = refeicoes.get(position);
        TextView textPratoPrincipal = (TextView) convertView.findViewById(R.id.text_PratoPrincipal);
        TextView textAcompanhamento = (TextView) convertView.findViewById(R.id.text_Acompanhamento);
        TextView textOpcaoVeg = (TextView) convertView.findViewById(R.id.text_OpcaoVeg);
        TextView textGuarnicao = (TextView) convertView.findViewById(R.id.text_Guarnicao);
        TextView textSobremesa = (TextView) convertView.findViewById(R.id.text_Sobremesa);
        TextView textSalada = (TextView) convertView.findViewById(R.id.text_Salada);
        TextView textSuco = (TextView) convertView.findViewById(R.id.text_Suco);
        TextView textData = (TextView) convertView.findViewById(R.id.text_Data);
        TextView textNomeRefeicao = (TextView) convertView.findViewById(R.id.text_nomeRefeicao);

        textPratoPrincipal.setText(objectItem.getPratoPrincipal());
        textAcompanhamento.setText(objectItem.getAcompanhamentos());
        textOpcaoVeg.setText(objectItem.getOpcaoVeg());
        textGuarnicao.setText(objectItem.getGuarnicao());
        textSobremesa.setText(objectItem.getSobremesa());
        textSalada.setText(objectItem.getSaladas());
        textSuco.setText(objectItem.getSuco());
        textData.setText(objectItem.getData());
        textNomeRefeicao.setText(objectItem.getNomeRefeicao());
        //textAvaliacao.setText(String.valueOf("Para Avaliar"));
        //VAI VERIFICAR SE ESTIVER TRUE OU FALSE, MUDAR O TEXTVIEW PARA AVALIADO!!
        //COMO O BOOLEAN ESTÁ SEMPRE INICINDO EM FALSE, ELE VAI PEGAR SÓ AVALIADO!!! E NÃO AVALIAÇÃO, IREI CORRIGIR ISSO DIA 18/10/2016
       /* if (objectItem.getAvaliacao().equals("Avaliar")) {
            textAvaliacao.setText("Para Avaliar");
        } else if (objectItem.getAvaliacao().equals("Gostei")) {

            textAvaliacao.setText("Gostei");
            convertView.setEnabled(false);
            convertView.setOnClickListener(null);
        } else if (objectItem.getAvaliacao().equals("Não Gostei")) {
            textAvaliacao.setText("Não Gostei");
            convertView.setEnabled(false);
            convertView.setOnClickListener(null);

        }*/

        return convertView;

    }


}
