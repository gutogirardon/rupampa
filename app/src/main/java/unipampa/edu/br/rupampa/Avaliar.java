package unipampa.edu.br.rupampa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import unipampa.edu.br.rupampa.dao.DAORefeicao;
import unipampa.edu.br.rupampa.model.Refeicao;

public class Avaliar extends AppCompatActivity {

    private Button gostei;
    private Button nGostei;
    private TextView data;
    private TextView refeicaoC;
    private TextView pratoPrincipal;
    private TextView acompanhamento;
    private TextView guarnicao;
    private TextView saladas;
    private TextView sobremesa;
    private TextView suco;
    private TextView opcVegetariana;
    private ArrayList<Refeicao> refeicoes;

    DAORefeicao daoRefeicao = new DAORefeicao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliar);

        data = (TextView) findViewById(R.id.cardapio_data);
        refeicaoC = (TextView) findViewById(R.id.cardapio_refeicao);
        pratoPrincipal = (TextView) findViewById(R.id.text_PratoPrincipal);
        acompanhamento = (TextView) findViewById(R.id.text_Acompanhamento);
        guarnicao = (TextView) findViewById(R.id.text_Guarnicao);
        saladas = (TextView) findViewById(R.id.text_Salada);
        sobremesa = (TextView) findViewById(R.id.text_Sobremesa);
        opcVegetariana = (TextView) findViewById(R.id.text_OpcaoVeg);
        suco = (TextView) findViewById(R.id.text_Suco);
        gostei = (Button) findViewById(R.id.button);
        nGostei = (Button) findViewById(R.id.button2);

        Bundle bundle = getIntent().getBundleExtra("main");
        final Refeicao refeicao = (Refeicao)bundle.getSerializable("refeicao");

        data.setText(refeicao.getData());
        refeicaoC.setText(refeicao.getNomeRefeicao());
        pratoPrincipal.setText(refeicao.getPratoPrincipal());
        acompanhamento.setText(refeicao.getAcompanhamentos());
        guarnicao.setText(refeicao.getGuarnicao());
        saladas.setText(refeicao.getSaladas());
        sobremesa.setText(refeicao.getSobremesa());
        suco.setText(refeicao.getSuco());
        opcVegetariana.setText(refeicao.getOpcaoVeg());
        final String refeicaoId = String.valueOf(refeicao.getId());

        refeicoes = daoRefeicao.pesquisarTodos();

        gostei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //VARIAVEIS DE AUXILIO PARA EXIBIR MENSAGEM DE SUCESSO
                Context contexto = getApplicationContext();
                String texto = "AVALIAÇÃO EFETUADA";
                int duracao = Toast.LENGTH_SHORT;


                refeicao.setAvaliacao("Gostei");

                final String avaliacaoId = "1";
                try {
                    Toast toast = Toast.makeText(contexto, texto, duracao);
                    toast.show();
                    daoRefeicao.salvar(refeicao);
                    finish();
                    Intent voltar2 = new Intent(Avaliar.this, MainActivity.class);

                    startActivity(voltar2);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });


        nGostei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context contexto = getApplicationContext();
                String texto = "AVALIAÇÃO EFETUADA";
                int duracao = Toast.LENGTH_SHORT;

                refeicao.setAvaliacao("Não Gostei");



                try {
                    Toast toast = Toast.makeText(contexto, texto, duracao);
                    toast.show();
                    final String avaliacaoId = "2";
                    //new UpdateOnline(contexto).execute(avaliacaoId,refeicaoId);
                    daoRefeicao.salvar(refeicao);
                    finish();

                    Intent voltar = new Intent(Avaliar.this, MainActivity.class);
                    startActivity(voltar);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });



    }
}
