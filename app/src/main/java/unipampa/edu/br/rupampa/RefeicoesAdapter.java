package unipampa.edu.br.rupampa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import unipampa.edu.br.rupampa.model.Refeicao;

/**
 * Created by Eric on 04/11/2016.
 */

class RefeicoesAdapter extends ArrayAdapter<Refeicao>{
    public RefeicoesAdapter(Context context, List<Refeicao> refeicoes) {
        super(context, R.layout.linha_refeicao, refeicoes);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater refeicaoInflater = LayoutInflater.from(getContext());
        View customView = refeicaoInflater.inflate(R.layout.linha_refeicao, parent, false);
        // get references.
        String refeicaoDataItem = String.valueOf(getItem(position).getDataToString());
        TextView data = (TextView) customView.findViewById(R.id.data);
        TextView diaSemana = (TextView) customView.findViewById(R.id.diaSemana);
        ImageView imgRefeicao = (ImageView) customView.findViewById(R.id.imgRefeicao);

        // dynamically update the text from the array
        data.setText(String.valueOf(getItem(position).getPratoPrincipal()));
        diaSemana.setText(String.valueOf(getItem(position).getSuco()));
        // using the same image every time
        imgRefeicao.setImageResource(R.drawable.refeicao_icon);
        // Now we can finally return our custom View or custom item
        return customView;
    }
}
