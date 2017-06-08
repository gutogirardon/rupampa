package unipampa.edu.br.rupampa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import unipampa.edu.br.rupampa.db.DBHelper;
import unipampa.edu.br.rupampa.model.Refeicao;

public class ListaRefeicoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_refeicoes);
        DBHelper dbHelper = new DBHelper(this);
        //DBHelper dbHelper = new DBHelper(this, null, null, 1);
        List<Refeicao> lista = dbHelper.getRefeicoes();
        ListAdapter customListAdapter = new RefeicoesAdapter(this,lista);// Pass the food arrary to the constructor.
        ListView customListView = (ListView) findViewById(R.id.refeicoesListView);
        customListView.setAdapter(customListAdapter);

        customListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String data = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(ListaRefeicoes.this, data, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
