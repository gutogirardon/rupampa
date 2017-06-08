package unipampa.edu.br.rupampa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirCardapioList (View view) {
        startActivity(new Intent(this, Cardapio.class));
    }

    public void abrirSugestao (View view) {
        startActivity(new Intent(this, Sugestao.class));
    }

    public void abrirElogio (View view) {
        startActivity(new Intent(this, Elogio.class));
    }

    public void abrirReclamacao (View view) {
        startActivity(new Intent(this, Reclamacao.class));
    }
    }


